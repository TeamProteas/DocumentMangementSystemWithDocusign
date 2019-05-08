package com.nineleaps.DocumentManagementSystem;

import com.nineleaps.DocumentManagementSystem.dao.EmployeeAccounts;
import com.nineleaps.DocumentManagementSystem.dto.TokenRequestedData;
import com.nineleaps.DocumentManagementSystem.exceptions.NotAllowedToUpload;
import com.nineleaps.DocumentManagementSystem.exceptions.SignInInvalidTokenError;
import com.nineleaps.DocumentManagementSystem.exceptions.SignInUserDataNotFound;
import com.nineleaps.DocumentManagementSystem.repository.EmployeeAccountsRepository;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class DocumentManagementInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    EmployeeAccountsRepository employeeAccountsRepo;

    @Autowired
    TokenRequestedData tokenRequestedData;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        System.out.println(req.getRequestURI());
        if (!req.getMethod().equalsIgnoreCase("OPTIONS")) {
            String userId = req.getParameter("userId");
            String tokenId = req.getHeader("tokenid");

            CloseableHttpClient client;
            client = HttpClients.createDefault();
            HttpGet request = new HttpGet("https://www.googleapis.com/oauth2/v3/tokeninfo?id_token=" + tokenId);
            CloseableHttpResponse closeableHttpResponse = null;

            closeableHttpResponse = client.execute(request);
            StatusLine statusLine = closeableHttpResponse.getStatusLine();
            int status = statusLine.getStatusCode();

            if (!(status >= 200 && status < 300)) {
                System.out.println("Unexpected Response status: " + status);

                //GIVES ERROR IF THE TOKEN IS INVALID
                throw new SignInInvalidTokenError("the token provided is INVALID");
            }

            HttpEntity entity = closeableHttpResponse.getEntity();
            String responseString = EntityUtils.toString(entity, "UTF-8");

            //VALIDATING THE USER INFORMATION PROVIDED IN THE TOKEN

            JSONObject json = (JSONObject) new JSONParser().parse(responseString);
            String email = (String) json.get("email");
            String googleid = (String) json.get("sub");
            String username = (String) json.get("name");
            System.out.println(email);
            System.out.println(username);
            System.out.println(googleid);

            boolean value = employeeAccountsRepo.existsByEmailId(email);
            System.out.println(value);

            if (value == false) {
                throw new SignInUserDataNotFound("The User Records is not available in the database");
            }
            tokenRequestedData.setGoogleId(googleid);
            tokenRequestedData.setUserEmail(email);
            tokenRequestedData.setUserName(username);
            tokenRequestedData.setUserId(userId);

            if (req.getRequestURI().equals("/v1/upload")) {
                accessControl(googleid, userId);
            }
            return value;
        }
        return true;
    }

    public void accessControl(String googleid, String userId) {
        EmployeeAccounts employeeAccounts = employeeAccountsRepo.findbyGoogleId(googleid);
        if (!googleid.equals(userId) && !employeeAccounts.getDesignation().equals("HR")) {
            throw new NotAllowedToUpload("You are not allowed to upload into other employee accounts");
        }
    }
}

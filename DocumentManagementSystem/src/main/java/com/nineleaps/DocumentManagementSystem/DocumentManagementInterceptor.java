package com.nineleaps.DocumentManagementSystem;

import com.nineleaps.DocumentManagementSystem.dao.EmployeeAccounts;
import com.nineleaps.DocumentManagementSystem.dto.TokenRequestedData;
import com.nineleaps.DocumentManagementSystem.exceptions.NotAllowedToUpload;
import com.nineleaps.DocumentManagementSystem.exceptions.SignInInvalidTokenError;
import com.nineleaps.DocumentManagementSystem.exceptions.SignInUserDataNotFound;
import com.nineleaps.DocumentManagementSystem.repository.EmployeeAccountsRepository;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
//        res.setHeader("Access-Control-Allow-Origin", "*"); res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS,PUT, HEAD, DELETE"); res.setHeader("Access-Control-Max-Age", "3600"); res.setHeader("Access-Control-Allow-Headers", "Content-Type"); res.setHeader("Access-Control-Allow-Credentials", "true");
        String fileType = req.getParameter("fileType");
        String userId = req.getParameter("userId");
        String tokenId = req.getHeader("tokenId");
        String temp = req.getParameter("login");
        System.out.println(req.getRequestURI());
        System.out.println(temp);

        System.out.println("TOKENID " + req.getHeader("tokenId"));

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet("https://www.googleapis.com/oauth2/v3/tokeninfo?id_token=" + temp);
        CloseableHttpResponse response = null;
        response = client.execute(request);
        int status = response.getStatusLine().getStatusCode();
        if (!(status >= 200 && status < 300)) {
            System.out.println("Unexpected response status: " + status);
            //GIVES ERROR IF THE TOKEN IS INVALID

            throw new SignInInvalidTokenError("the token provided is INVALID");
        }

        HttpEntity entity = response.getEntity();
        String responseString = EntityUtils.toString(entity, "UTF-8");
        System.out.println(responseString);

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



    public void accessControl(String googleid, String userId) {
        EmployeeAccounts employeeAccounts = employeeAccountsRepo.findbyGoogleId(googleid);
        if (!googleid.equals(userId) && !employeeAccounts.getDesignation().equals("HR")) {
            throw new NotAllowedToUpload("You are not allowed to upload into other employee accounts");
        }

    }


}

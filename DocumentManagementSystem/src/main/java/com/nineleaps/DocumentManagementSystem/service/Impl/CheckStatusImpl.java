package com.nineleaps.DocumentManagementSystem.service.Impl;

import com.nineleaps.DocumentManagementSystem.dao.DigitalSignData;
import com.nineleaps.DocumentManagementSystem.repository.DigitalSignRepository;
import com.nineleaps.DocumentManagementSystem.service.CheckStatusService;
import com.signaturit.api.java_sdk.Client;
import okhttp3.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class CheckStatusImpl implements CheckStatusService {

    @Autowired
    DigitalSignRepository digitalSignRepo;

    public String checkStatus(String name, String documentname) throws IOException, ParseException {

        //create signaturit client
        Client client = new Client("ZZlAEJyoeHkBIuezNagwtaXZxaXWQJyUyHpVgzRamorLNVQCieYiyyhQsdYgmDxUxrWbwIXhdMFHTzvjcMwvsR", false);

        //find person's credentials
        DigitalSignData digitalSignData;
        try {
            digitalSignData = digitalSignRepo.findDocumentRow(name, documentname);
        } catch (Exception e) {
            return "NO RECORD FOUND";
        }

        //get status
        Response response = client.getSignature(digitalSignData.getSignatureRequestId());
        String bodyString = response.body().string();
        System.out.println(bodyString);

        //extract document id
        JSONObject json = (JSONObject) new JSONParser().parse(bodyString);
        ArrayList arr = (ArrayList) json.get("documents");
        JSONObject assignObject = (JSONObject) arr.get(0);
        JSONObject json1 = (JSONObject) new JSONParser().parse(assignObject.toString());
        String signStatus = (String) json1.get("status");
        String documentId = (String) json1.get("id");
        System.out.println(documentId);
        System.out.println(signStatus);

        digitalSignData.setDocumentId(documentId);
        digitalSignRepo.save(digitalSignData);
        return signStatus;
    }
}


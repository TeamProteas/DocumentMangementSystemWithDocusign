package com.nineleaps.DocumentManagementSystem.service.Impl;

import com.nineleaps.DocumentManagementSystem.dao.DigitalSignData;
import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
import com.nineleaps.DocumentManagementSystem.repository.DigitalSignRepository;
import com.nineleaps.DocumentManagementSystem.service.CheckStatusService;
import com.signaturit.api.java_sdk.Client;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@Service
public class CheckStatusImpl implements CheckStatusService {

    @Autowired
    DigitalSignRepository digitalSignRepo;

    public ResponseEntity<CustomResponse> checkStatus(String name, String documentname) throws IOException, ParseException {

        CustomResponse customResponse = new CustomResponse(new Date(), "No Data Found",
                "Current Status ", HttpStatus.CREATED.getReasonPhrase());


        //create signaturit client
        Client client = new Client("ZZlAEJyoeHkBIuezNagwtaXZxaXWQJyUyHpVgzRamorLNVQCieYiyyhQsdYgmDxUxrWbwIXhdMFHTzvjcMwvsR", false);


        //find person's credentials
        DigitalSignData digitalSignData;
        try {
            digitalSignData = digitalSignRepo.findDocumentRow(name, documentname);
        } catch (Exception e) {
            return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.NO_CONTENT);
        }

        //get status
        Response response = client.getSignature(digitalSignData.getSignatureRequestId());
        ResponseBody responseBody = response.body();
        String bodyString = responseBody.toString();

        //extract document id
        JSONObject json = (JSONObject) new JSONParser().parse(bodyString);
        ArrayList arr = (ArrayList) json.get("documents");
        JSONObject assignObject = (JSONObject) arr.get(0);
        JSONObject json1 = (JSONObject) new JSONParser().parse(assignObject.toString());
        String signStatus = (String) json1.get("status");
        String documentId = (String) json1.get("id");

        digitalSignData.setDocumentId(documentId);
        digitalSignRepo.save(digitalSignData);
        customResponse.setMessage(signStatus);
        return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.OK);

    }
}


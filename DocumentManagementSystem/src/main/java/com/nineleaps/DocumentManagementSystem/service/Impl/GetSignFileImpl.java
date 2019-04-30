package com.nineleaps.DocumentManagementSystem.service.Impl;

import com.nineleaps.DocumentManagementSystem.dao.DigitalSignData;
import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
import com.nineleaps.DocumentManagementSystem.repository.DigitalSignRepository;
import com.signaturit.api.java_sdk.Client;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

@Service
public class GetSignFileImpl {

    @Autowired
    DigitalSignRepository digitalSignRepo;

    public ResponseEntity<CustomResponse> getFile(String name, String documentname) throws IOException {

        //creating  signaturit client
        CustomResponse customResponse = new CustomResponse(new Date(), "Success",
                "Downloaded", HttpStatus.OK.getReasonPhrase());
        try {
            Client client = new Client("ZZlAEJyoeHkBIuezNagwtaXZxaXWQJyUyHpVgzRamorLNVQCieYiyyhQsdYgmDxUxrWbwIXhdMFHTzvjcMwvsR", false);


            DigitalSignData digitalSignData = digitalSignRepo.findDocumentRow(name, documentname);
            Response response = client.downloadSignedDocument(digitalSignData.getSignatureRequestId(), digitalSignData.getDocumentId());
            ResponseBody responseBody ;
            responseBody= response.body();

            File file = new File("/home/nineleaps/Desktop/UserData/" + digitalSignData.getDocumentName() + "-" + digitalSignData.getPerson());
            OutputStream os = new FileOutputStream(file);

            byte[] byteArray = responseBody.bytes();
            os.write(byteArray);
            System.out.println("File Downloaded");
            os.close();
        } catch (Exception e) {
            customResponse.setMessage("File Not Present");
            customResponse.setDetails("File is not signed till now");
            customResponse.setHttpCodeMessage(HttpStatus.FORBIDDEN.toString());
            e.printStackTrace();
            return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.FORBIDDEN);
        }

        return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.OK);

    }
}


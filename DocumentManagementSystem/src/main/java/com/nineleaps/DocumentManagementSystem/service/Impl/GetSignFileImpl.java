package com.nineleaps.DocumentManagementSystem.service.Impl;

import com.nineleaps.DocumentManagementSystem.dao.DigitalSignData;
import com.nineleaps.DocumentManagementSystem.repository.DigitalSignRepository;
import com.signaturit.api.java_sdk.Client;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Service
public class GetSignFileImpl {

    @Autowired
    DigitalSignRepository digitalSignRepo;

    public void getFile(String name, String documentname) throws IOException {

        //creating  signaturit client
        Client client = new Client("ZZlAEJyoeHkBIuezNagwtaXZxaXWQJyUyHpVgzRamorLNVQCieYiyyhQsdYgmDxUxrWbwIXhdMFHTzvjcMwvsR", false);

        //getting credentials
        DigitalSignData digitalSignData = digitalSignRepo.findDocumentRow(name, documentname);

        if (digitalSignData == null) {
            System.out.println("NO RECORD FOUND");
        } else {
            Response response = client.downloadSignedDocument(digitalSignData.getSignatureRequestId(), digitalSignData.getDocumentId());
            File file = new File("/home/nineleaps/Desktop/UserData/" + digitalSignData.getDocumentName() + "-" + digitalSignData.getPerson());
            try {
                ResponseBody responseBody = response.body();
                OutputStream os = new FileOutputStream(file);

                byte[] byteArray = responseBody.bytes();
                os.write(byteArray);
                System.out.println("File Downloaded");
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

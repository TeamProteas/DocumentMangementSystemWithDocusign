package com.nineleaps.DocumentManagementSystem.service.Impl;

import com.nineleaps.DocumentManagementSystem.dao.DigitalSignData;
import com.nineleaps.DocumentManagementSystem.repository.DigitalSignRepository;
import com.nineleaps.DocumentManagementSystem.service.DigitalSignService;
import com.signaturit.api.java_sdk.Client;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

@Service
public class DigitalSignImpl implements DigitalSignService {

    @Autowired
    DigitalSignRepository digitalSignRepo;


    public void sendSignRequest(String signeeEmailid, String signeeName, String name, MultipartFile file, String documentName) throws IOException, ParseException {//getting the file
        File fileContent = new File("/home/nineleaps/Desktop/SignedFiles/" + file.getOriginalFilename());
        fileContent.createNewFile();
        FileOutputStream fout = new FileOutputStream(fileContent);
        fout.write(file.getBytes());
        fout.close();

        //adding the files
        ArrayList<File> signFiles = new ArrayList<File>();
        signFiles.add(fileContent);

        //adding the recipient
        ArrayList<HashMap<String, Object>> recipients = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> recipient = new HashMap<String, Object>();
        recipient.put("email", signeeEmailid);
        recipient.put("name", signeeName);
        recipients.add(recipient);

        //sending request
        Client client = new Client("ZZlAEJyoeHkBIuezNagwtaXZxaXWQJyUyHpVgzRamorLNVQCieYiyyhQsdYgmDxUxrWbwIXhdMFHTzvjcMwvsR", false);

        Response response = client.createSignature(signFiles, recipients);
        //extracting response
        ResponseBody responseBody = response.body();
        String a = responseBody.toString();
        JSONObject json = (JSONObject) new JSONParser().parse(a);
        String id = (String) json.get("id");
        System.out.println(id);

        //updating database
        DigitalSignData digitalSignData = new DigitalSignData(UUID.randomUUID(), null, file.getOriginalFilename(), name, id, signeeName, documentName);
        digitalSignRepo.save(digitalSignData);
    }
}


package com.nineleaps.DocumentManagementSystem.controller;

import com.nineleaps.DocumentManagementSystem.service.Impl.GetSignFileImpl;
import okio.ByteString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
public class GetSignFileController {

    @Autowired
    GetSignFileImpl getSignFileImpl;

    @RequestMapping("/v1/getFile")
    public ByteString getFile(@RequestHeader("tokenId") String tokenData, @RequestParam("name") String name, @RequestParam("documentname") String documentname) throws IOException {

        getSignFileImpl.getFile(name, documentname);
        return null;
    }

}

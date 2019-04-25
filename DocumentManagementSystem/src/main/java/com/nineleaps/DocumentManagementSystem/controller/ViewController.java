package com.nineleaps.DocumentManagementSystem.controller;


import com.nineleaps.DocumentManagementSystem.dao.EmployeeData;
import com.nineleaps.DocumentManagementSystem.service.Impl.ViewServiceImpl;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
public class ViewController {
    @Autowired
    ViewServiceImpl viewServiceImpl;

    @ResponseBody
    @GetMapping("v1/view")
    public List<EmployeeData> getView(@RequestParam String userId) throws IOException, ParseException {

        System.out.println("VIEW:");
        return viewServiceImpl.fetchViewData(userId);
    }

}

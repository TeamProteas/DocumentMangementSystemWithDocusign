package com.nineleaps.DocumentManagementSystem.controller;

import com.nineleaps.DocumentManagementSystem.dto.StatusTableData;
import com.nineleaps.DocumentManagementSystem.service.Impl.StatusTableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class StatusTableController {
    @Autowired
    StatusTableServiceImpl statusTableService;

    @GetMapping("/v1/table")
    @ResponseBody
    public List<StatusTableData> getstatus() {
        return statusTableService.getTableData();


    }
}

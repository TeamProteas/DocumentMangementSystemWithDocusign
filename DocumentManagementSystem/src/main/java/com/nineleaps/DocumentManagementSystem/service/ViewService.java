package com.nineleaps.DocumentManagementSystem.service;

import com.nineleaps.DocumentManagementSystem.dao.EmployeeData;
import com.nineleaps.DocumentManagementSystem.exceptions.ViewNoRecordsFound;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ViewService {

    public List<EmployeeData> fetchViewData() throws ViewNoRecordsFound;
}


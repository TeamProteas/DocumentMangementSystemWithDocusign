package com.nineleaps.DocumentManagementSystem.service;

import com.nineleaps.DocumentManagementSystem.dto.StatusTableData;

import java.util.List;

public interface StatusTableService {

    public List<StatusTableData> getTableData();
    public void checkStatus(String folderuid);
}

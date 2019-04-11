package com.nineleaps.DocumentManagementSystem.service;

import com.nineleaps.DocumentManagementSystem.dao.DocumentType;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DocumentTypeService {
    public List<DocumentType> fetchTypeOfDocument();
}

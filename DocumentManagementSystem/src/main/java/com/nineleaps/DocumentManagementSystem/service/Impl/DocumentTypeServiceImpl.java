package com.nineleaps.DocumentManagementSystem.service.Impl;

import com.nineleaps.DocumentManagementSystem.dao.DocumentType;
import com.nineleaps.DocumentManagementSystem.repository.DocumentTypeRepository;
import com.nineleaps.DocumentManagementSystem.service.DocumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentTypeServiceImpl implements DocumentTypeService {
    @Autowired
    DocumentTypeRepository documentTypeRepo;


    @Override
    public List<DocumentType> fetchTypeOfDocument() {

        //RETURNS A LIST OF ALL THE DOCUMENTS PRESENT IN THE DATABASE
        System.out.println(documentTypeRepo.count());
        return documentTypeRepo.findFileType();
    }

}

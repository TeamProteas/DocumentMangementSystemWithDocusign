package com.nineleaps.DocumentManagementSystem.service.Impl;

import com.nineleaps.DocumentManagementSystem.dao.DocumentType;
import com.nineleaps.DocumentManagementSystem.repository.DocumentTypeRepository;
import com.nineleaps.DocumentManagementSystem.service.Impl.DocumentTypeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class DocumentTypeServiceImplTest {
    @InjectMocks
    DocumentTypeServiceImpl documentTypeService;

    @Mock
    DocumentTypeRepository documentTypeRepository;



    @Test
    public void fetchTypeOfDocument() {
        when(documentTypeRepository.count()).thenReturn(2l);
        when(documentTypeRepository.findFileType()).thenReturn(Stream.of(new DocumentType(UUID.fromString("33e38e51-fd8b-4d2c-8f20-05d38b607dc7"), "aadharcard", "Aadhar Card"), new DocumentType(UUID.fromString("33e38e51-fd8b-4d2c-8f20-05d38b607dc7"), "aadharcard", "Aadhar Card")).collect(Collectors.toList()));

        List<DocumentType> documentTypes = documentTypeService.fetchTypeOfDocument();

        assertEquals(documentTypes.size(),2);
    }


}

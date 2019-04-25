package com.nineleaps.DocumentManagementSystem.service.Impl;//package com.nineleaps.DocumentManagementSystem.Service;


import com.nineleaps.DocumentManagementSystem.dao.DocumentType;
import com.nineleaps.DocumentManagementSystem.exceptions.CustomResponse;
import com.nineleaps.DocumentManagementSystem.repository.DocumentTypeRepository;
import com.nineleaps.DocumentManagementSystem.service.Impl.AddDocumentTypeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class AddDocumentTypeServiceImplTest {

    @InjectMocks
    AddDocumentTypeServiceImpl addDocumentTypeService;
    @Mock
    DocumentTypeRepository documentTypeRepository;
    @Mock
    CustomResponse customResponse;

    DocumentType documentType = new DocumentType(UUID.randomUUID(), "aadharcard", "Aadhar Card");

    @Test
    public void addDoctype() throws  Exception{


        ResponseEntity<CustomResponse> customResponseResponseEntity = addDocumentTypeService.addDoctype( "aadharcard", "Aadhar Card");
        assertEquals(customResponseResponseEntity.getStatusCode().getReasonPhrase(), "OK");
    }


}

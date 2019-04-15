package com.nineleaps.DocumentManagementSystem.exceptions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class FileTypeEmptyTest  {


    @Test
    public void myTest() {
        FileTypeEmpty fileTypeEmpty = new FileTypeEmpty("abc");
        assertEquals(fileTypeEmpty.getMessage(), "abc");
    }


}


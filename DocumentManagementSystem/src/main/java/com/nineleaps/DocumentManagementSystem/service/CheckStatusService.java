package com.nineleaps.DocumentManagementSystem.service;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface CheckStatusService {
    public String checkStatus(String name,String documentname) throws IOException, ParseException;
}
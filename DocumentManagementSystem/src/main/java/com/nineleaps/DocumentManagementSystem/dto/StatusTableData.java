package com.nineleaps.DocumentManagementSystem.dto;

public class StatusTableData {
    private String emailId;
    private String employeeId;
    private boolean allVerified;
    private boolean allUploaded;
    private String firstName;
    private String lastName;
    public StatusTableData() {
    }

    public StatusTableData(String emailId, String employeeId, boolean allVerified, boolean allUploaded, String firstName, String lastName) {
        this.emailId = emailId;
        this.employeeId = employeeId;
        this.allVerified = allVerified;
        this.allUploaded = allUploaded;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public boolean isAllVerified() {
        return allVerified;
    }

    public void setAllVerified(boolean allVerified) {
        this.allVerified = allVerified;
    }

    public boolean isAllUploaded() {
        return allUploaded;
    }

    public void setAllUploaded(boolean allUploaded) {
        this.allUploaded = allUploaded;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

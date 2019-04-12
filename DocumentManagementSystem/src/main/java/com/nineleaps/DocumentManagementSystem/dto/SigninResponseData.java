package com.nineleaps.DocumentManagementSystem.dto;

public class SigninResponseData {

    private String emailId;
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }


    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    private String view;

    public SigninResponseData() {
    }

    public SigninResponseData(String emailId, String userId, String view) {
        this.emailId = emailId;
        this.userId = userId;
        this.view = view;
    }
}

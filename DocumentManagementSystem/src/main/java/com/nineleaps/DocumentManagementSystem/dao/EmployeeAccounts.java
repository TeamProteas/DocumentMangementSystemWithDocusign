package com.nineleaps.DocumentManagementSystem.dao;



import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.sql.Timestamp;
import java.util.UUID;


@Table(value="EmployeeAccounts")
public class EmployeeAccounts {
    public EmployeeAccounts() {
    }

    public EmployeeAccounts(boolean allUploaded, String emailId, boolean allVerified, String employeeId, String googleId, long dateOfBirth, long dateOfJoining, String designation, String firstName, String lastName) {
        this.allUploaded = allUploaded;
        this.emailId = emailId;
        this.allVerified = allVerified;
        this.employeeId = employeeId;
        this.googleId = googleId;
        this.dateOfBirth = dateOfBirth;
        this.dateOfJoining = dateOfJoining;
        this.designation = designation;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Id
    @PrimaryKeyColumn(name = "uid")
    UUID uid= UUID.randomUUID();

    @Column(value="alluploaded")
    private boolean allUploaded;

    @Column(value="emailid")
    private String emailId;

    @Column(value="allverified")
    private boolean allVerified;

    public boolean isAllUploaded() {
        return allUploaded;
    }

    public void setAllUploaded(boolean allUploaded) {
        this.allUploaded = allUploaded;
    }

    public boolean isAllVerified() {
        return allVerified;
    }

    public void setAllVerified(boolean allVerified) {
        this.allVerified = allVerified;
    }

    @Column(value = "employeeid")
    private String employeeId;

    @Column(value = "googleid")
    private String googleId;

    @Column(value = "dateofbirth")
    private long dateOfBirth;

    @Column(value = "dateofjoining")
    private long dateOfJoining;

    @Column(value = "designation")
    private String designation;

    @Column(value = "firstname")
    private String firstName;

    @Column(value = "lastname")
    private String lastName;

    public UUID getUid() {
        return uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
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

    public String getGoogleId() {
        return googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }

    public long getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(long dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public long getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(long dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
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

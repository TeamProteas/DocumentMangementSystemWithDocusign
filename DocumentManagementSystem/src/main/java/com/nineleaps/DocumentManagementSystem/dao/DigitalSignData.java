package com.nineleaps.DocumentManagementSystem.dao;

import org.springframework.data.annotation.Id;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;


import java.util.UUID;

@Table("DigitalSignData")
public class DigitalSignData {
    public DigitalSignData() {
    }

    @Id
    @Column("uid")
    UUID uid = UUID.randomUUID();

    @Column("filename")
    private String filename;

    @Column("person")
    private String person;

    @Column("documentId")
    private String documentId;

    @Column("signatureRequestId")
    private String signatureRequestId;

    @Column("signedby")
    private String signedby;

    @Column("documentName")
    private String documentName;

    public DigitalSignData(UUID uid, String documentId, String filename, String person, String signatureRequestId, String signedby, String documentName) {
        this.uid = uid;
        this.documentId = documentId;
        this.filename = filename;
        this.person = person;
        this.signatureRequestId = signatureRequestId;
        this.signedby = signedby;
        this.documentName = documentName;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getSignedby() {
        return signedby;
    }

    public void setSignedby(String signedby) {
        this.signedby = signedby;
    }

    public UUID getUid() {
        return uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getSignatureRequestId() {
        return signatureRequestId;
    }

    public void setSignatureRequestId(String signatureRequestId) {
        this.signatureRequestId = signatureRequestId;
    }
}


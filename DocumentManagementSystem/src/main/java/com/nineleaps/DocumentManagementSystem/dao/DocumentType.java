package com.nineleaps.DocumentManagementSystem.dao;

import org.springframework.data.annotation.Id;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;


import java.util.UUID;


@Table("DocumentType")
public class DocumentType {
    public DocumentType() {
    }

    @Id
    @Column(value = "uid")
    UUID uid = UUID.randomUUID();

    @Column(value = "filetype")
    private String fileType;

    @Column(value = "displayname")
    private String displayName;

    public UUID getUid() {
        return uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public DocumentType(UUID uid, String fileType, String displayName) {
        this.uid = uid;
        this.fileType = fileType;
        this.displayName = displayName;
    }
}

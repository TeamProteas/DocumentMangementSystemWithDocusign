package com.nineleaps.DocumentManagementSystem.repository;

import com.nineleaps.DocumentManagementSystem.dao.DocumentType;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DocumentTypeRepository extends CassandraRepository<DocumentType,String> {

    @Query("SELECT * FROM DocumentType")
    public List<DocumentType> findFileType();

}

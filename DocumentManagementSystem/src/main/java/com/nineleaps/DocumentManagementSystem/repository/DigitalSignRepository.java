package com.nineleaps.DocumentManagementSystem.repository;

import com.nineleaps.DocumentManagementSystem.dao.DigitalSignData;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

public interface DigitalSignRepository extends CassandraRepository<DigitalSignData, String> {

    @Query("select * from digitalsigndata where person=?0 and documentname=?1 Allow Filtering")
    public DigitalSignData findDocumentRow(String person, String documentname);
}

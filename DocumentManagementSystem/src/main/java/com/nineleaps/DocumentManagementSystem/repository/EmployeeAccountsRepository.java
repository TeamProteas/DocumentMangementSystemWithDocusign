package com.nineleaps.DocumentManagementSystem.repository;


import com.nineleaps.DocumentManagementSystem.dao.EmployeeAccounts;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface EmployeeAccountsRepository extends CassandraRepository<EmployeeAccounts, String> {


    @Query("Select * from EmployeeAccounts where emailid=?0 ALLOW FILTERING")
    EmployeeAccounts findbyEmailId(String email);

    @Query("Select * from EmployeeAccounts where googleid=?0 ALLOW FILTERING")
    EmployeeAccounts findbyGoogleId(String userId);


    @Query("update EmployeeAccounts SET googleid=?0 WHERE uid=?1")
    void updateGoogleId(String googleid, UUID uid);

    @Query("update EmployeeAccounts SET alluploaded=?0 WHERE uid=?1")
    void updateallUploaded(boolean allUploaded, UUID Uid);

    @Query("update EmployeeAccounts SET allverified=?0 WHERE uid=?1")
    void updateallVerified(boolean allVerified, UUID Uid);


    @Query(allowFiltering = true)
    boolean existsByEmailId(String emailId);

}

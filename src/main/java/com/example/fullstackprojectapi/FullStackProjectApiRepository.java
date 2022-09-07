package com.example.fullstackprojectapi;

import org.springframework.stereotype.Repository;

@Repository
public interface FullStackProjectApiRepository extends JpaRepository<>{

    String insertDataToSQLFromCSV
}

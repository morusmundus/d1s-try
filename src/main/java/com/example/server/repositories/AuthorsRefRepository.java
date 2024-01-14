package com.example.server.repositories;

import com.example.server.entity.AuthorsRef;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AuthorsRefRepository extends Repository<AuthorsRef> {
    @Query("SELECT a FROM AuthorsRef a WHERE a.fName = :fName AND a.sName = :sName AND a.tName = :tName")
    Optional<AuthorsRef> findByFNameAndSNameAndTName(String sName, String fName, String tName);
}

package com.example.server.service;

import com.example.server.entity.AuthorsRef;
import com.example.server.repositories.AuthorsRefRepository;
import com.example.server.repositories.Repository;
import org.springframework.stereotype.Service;

@Service
public class AuthorService extends AbstractService<AuthorsRef> {

    public AuthorService(Repository<AuthorsRef> repository) {
        super(repository);
    }

    public AuthorsRef findByAuthorFIO(String fio) {
        String[] fioOrd = fio.split(" ");
        System.out.println(fio);
        return ((AuthorsRefRepository) repository).findByFNameAndSNameAndTName(fioOrd[0],fioOrd[1], fioOrd[2]).orElseThrow();
    }
}
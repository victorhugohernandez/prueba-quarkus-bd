package com.neoris.repository;

import com.neoris.entity.User;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class UserRepository implements PanacheMongoRepository<User> {

    public List<User> findAllUser() {
        return listAll(Sort.by("name"));
    }
}

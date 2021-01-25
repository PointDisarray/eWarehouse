package com.example.springboot.repos;

import com.example.springboot.domain.DBuser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<DBuser, Integer> {

}
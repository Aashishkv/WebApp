package com.example.Spring.CURDOp.repository;

import com.example.Spring.CURDOp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface UserJpaRepository extends JpaRepository<Users,Long > {

//    //custom query
//    @Query("SELECT u FROM Users u WHERE u.name=:name")
//    Users findByName(@Param("name") String name);

    Users findByName(String name);
}

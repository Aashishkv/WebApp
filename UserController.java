package com.example.Spring.CURDOp.controller;

import com.example.Spring.CURDOp.model.Users;
import com.example.Spring.CURDOp.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserJpaRepository userJpaReository;

    @GetMapping("/select")
  //  @ResponseBody
    public Users[] findAll()
    {
       return userJpaReository.findAll().toArray(new Users[0]);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Users> findByName(@PathVariable final String name)
    {

        if(userJpaReository.findByName(name)==null )
        {
            return new ResponseEntity(HttpStatus.NOT_FOUND);

           // return userJpaReository.findByName(name);
        }
        return new ResponseEntity(userJpaReository.findByName(name),HttpStatus.OK);

    }
    @PostMapping("/load")
    public ResponseEntity<Users> load(@RequestBody final Users users)
    {
        userJpaReository.save(users);
        return new ResponseEntity(userJpaReository.findByName(users.getName()),HttpStatus.CREATED);
    }
}

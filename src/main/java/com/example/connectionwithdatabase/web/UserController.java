package com.example.connectionwithdatabase.web;

import com.example.connectionwithdatabase.core.entity.User;
import com.example.connectionwithdatabase.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    //Create a new user
    @PostMapping
    public ResponseEntity<?> create (@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    //Read a user
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id){
        Optional<User> oUser = userService.findById(id);
        if(!oUser.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oUser);
    }


    //Update a user
    @PutMapping({"/{id}"})
    public ResponseEntity<?> update (@RequestBody User userDetails, @PathVariable Long id) {
        Optional<User> oUser = userService.findById(id);
        if(!oUser.isPresent()){
            return ResponseEntity.notFound().build();
        }

        oUser.get().setName(userDetails.getName());
        oUser.get().setSurname(userDetails.getSurname());
        oUser.get().setEmail(userDetails.getEmail());
        oUser.get().setEnabled(userDetails.isEnabled());

        //Forma para modificar un objeto entero:
        //BeanUtils.copyProperties(userDetails,oUser.get());

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(oUser.get()));
    }

    //Delete a user
    @DeleteMapping({"/{id}"})
    public ResponseEntity<?> delete (@PathVariable Long id) {
        if(!userService.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    //Read all users
    @GetMapping
    public List<User> readAll(){
        List<User> users = StreamSupport.stream(userService.findAll().spliterator(),false).collect(Collectors.toList());
        return users;
    }


    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filter){
        return ResponseEntity.status(HttpStatus.OK).body(userService.search(filter));
    }

}
package com.tiendaonline.usuariosservicio.controllers;

import com.tiendaonline.usuariosservicio.entity.User;
import com.tiendaonline.usuariosservicio.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Obtener todos los usuarios
    @GetMapping
    public List<User> productList(){
        return userService.listUser();
    }

    @PostMapping("/registro")
    public ResponseEntity<User> registUser(@RequestBody User user){
        User newUser = userService.registerUsers(user);
        return ResponseEntity.ok(newUser);
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email){
        Optional<User> user = userService.findByEmail(email);
        return user.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}

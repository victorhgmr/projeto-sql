package unip.prj_trab_sql.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unip.prj_trab_sql.funcionario.Funcionario;
import unip.prj_trab_sql.funcionario.FuncionarioDTO;
import unip.prj_trab_sql.services.FuncionarioService;
import unip.prj_trab_sql.services.UserService;
import unip.prj_trab_sql.user.User;
import unip.prj_trab_sql.user.UserDTO;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    // Imports
    @Autowired
    private UserService userService;

    @Autowired
    private FuncionarioService funcionarioService;

    // Controller para User
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDTO user){
        User newUser = userService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        var users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
        this.userService.deleteUser(id);
        return ResponseEntity.ok("resource deleted successfully");
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id,@Valid @RequestBody User user) throws Exception {
        var upadatedUser = this.userService.updateUser(id, user);
        return new ResponseEntity<>(upadatedUser, HttpStatus.OK );
    }

    // Controller para Funcionario

    @PostMapping("/funcionario")
    public ResponseEntity<Funcionario> createFuncionario(@Valid @RequestBody FuncionarioDTO funcionario){
        Funcionario newFuncionario = funcionarioService.createFuncionario(funcionario);
        return new ResponseEntity<>(newFuncionario, HttpStatus.CREATED);
    }

    @GetMapping("/funcionario")
    public ResponseEntity<List<Funcionario>> getAllFuncionarios(){
        var funcionarios = funcionarioService.getAllFuncionarios();
        return new ResponseEntity<>(funcionarios, HttpStatus.OK);
    }

    @DeleteMapping("/funcionario/{id}")
    public ResponseEntity<String> deleteFuncionario(@PathVariable("id") Long id){
        this.funcionarioService.deleteFuncionario(id);
        return ResponseEntity.ok("resource deleted successfully");
    }

    @PutMapping("/funcionario/{id}")
    public ResponseEntity<Funcionario> updateFuncionario(@PathVariable("id") Long id,@Valid @RequestBody Funcionario funcionario) throws Exception {
        var upadatedFuncionario = this.funcionarioService.updateFuncionario(id, funcionario);
        return new ResponseEntity<>(upadatedFuncionario, HttpStatus.OK );
    }
}

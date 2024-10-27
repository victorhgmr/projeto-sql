package unip.prj_trab_sql.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unip.prj_trab_sql.animal.Animal;
import unip.prj_trab_sql.animal.AnimalDTO;
import unip.prj_trab_sql.services.AnimalService;
import unip.prj_trab_sql.user.User;
import unip.prj_trab_sql.user.UserDTO;

import java.util.List;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    private AnimalService service;


    @PostMapping
    public ResponseEntity<Animal> createUser(@Valid @RequestBody AnimalDTO animal){
        Animal newAnimal = service.createAnimal(animal);
        return new ResponseEntity<>(newAnimal, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Animal>> getAllAnimals(){
        var animals = service.getAllAnimals();
        return new ResponseEntity<>(animals, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAnimal(@PathVariable("id") Long id){
        this.service.delete(id);
        return ResponseEntity.ok("resource deleted successfully");
    }

    @PutMapping("{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable("id") Long id,@Valid @RequestBody Animal animal) throws Exception {
        var upadatedAnimal = this.service.update(id, animal);
        return new ResponseEntity<>(upadatedAnimal, HttpStatus.OK );
    }
}

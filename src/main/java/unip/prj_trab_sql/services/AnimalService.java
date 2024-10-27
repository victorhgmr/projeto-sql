package unip.prj_trab_sql.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unip.prj_trab_sql.animal.Animal;
import unip.prj_trab_sql.animal.AnimalDTO;
import unip.prj_trab_sql.repositories.AnimalRepository;
import java.util.List;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository repository;

    public void saveAnimal(Animal animal){
        this.repository.save(animal);
    }

    public Animal createAnimal(AnimalDTO animal){
        Animal newAnimal = new Animal(animal);
        this.saveAnimal(newAnimal);
        return newAnimal;
    }

    public List<Animal> getAllAnimals(){
        return this.repository.findAll();
    }

    public Animal findAnimalById(Long id) throws Exception {
        return this.repository.findAnimalById(id).orElseThrow(()-> new Exception("Usuário não encontrado"));
    }

    public void delete(Long id){
        this.repository.deleteById(id);
    }

    public Animal update(Long id, Animal animal) throws Exception {
        Animal passAnimal = findAnimalById(id);
        if (animal.getNome()!= null) {
            passAnimal.setNome(animal.getNome());
        }
        if (animal.getEspecie() != null) {
            passAnimal.setEspecie(animal.getEspecie());
        }
        if (animal.getRaca() != null) {
            passAnimal.setRaca(animal.getRaca());
        }
        if (animal.getIdade() != null) {
            passAnimal.setIdade(animal.getIdade());
        }
        if (animal.getDono() != null) {
            passAnimal.setDono(animal.getDono());
        }
        return repository.save(passAnimal);
    }

}

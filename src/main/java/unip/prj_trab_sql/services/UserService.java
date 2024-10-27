package unip.prj_trab_sql.services;

import org.springframework.beans.factory.annotation.Autowired;
import unip.prj_trab_sql.funcionario.Funcionario;
import unip.prj_trab_sql.funcionario.FuncionarioDTO;
import unip.prj_trab_sql.repositories.FuncionarioRepository;
import unip.prj_trab_sql.repositories.UserRepository;
import unip.prj_trab_sql.user.User;
import unip.prj_trab_sql.user.UserDTO;

import java.util.List;

@org.springframework.stereotype.Service
public class UserService {

    //Imports
    @Autowired
    private UserRepository userRepository;

    // Service User

    public void saveUser(User user){
        this.userRepository.save(user);
    }

    public User createUser(UserDTO user){
        User newUser = new User(user);
        this.saveUser(newUser);
        return newUser;
    }

    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    public User findUserById(Long id) throws Exception {
        return this.userRepository.findUserById(id).orElseThrow(()-> new Exception("Usuário não encontrado"));
    }

    public void deleteUser(Long id){
        this.userRepository.deleteById(id);
    }

    public User updateUser(Long id, User user) throws Exception {
        User passUser = findUserById(id);
        if (user.getNome()!= null) {
            passUser.setNome(user.getNome());
        }
        if (user.getEndereco() != null) {
            passUser.setEndereco(user.getEndereco());
        }
        if (user.getEmail() != null) {
            passUser.setEmail(user.getEmail());
        }
        if (user.getTelefone() != null) {
            passUser.setTelefone(user.getTelefone());
        }
        if (user.getSenha() != null) {
            passUser.setSenha(user.getSenha());
        }
        return userRepository.save(passUser);
    }



}

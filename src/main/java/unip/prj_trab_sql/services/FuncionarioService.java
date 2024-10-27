package unip.prj_trab_sql.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unip.prj_trab_sql.funcionario.Funcionario;
import unip.prj_trab_sql.funcionario.FuncionarioDTO;
import unip.prj_trab_sql.repositories.FuncionarioRepository;

import java.util.List;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    // Service Funcionario

    public void saveFuncionario(Funcionario funcionario){
        this.funcionarioRepository.save(funcionario);
    }

    public Funcionario createFuncionario(FuncionarioDTO funcionario){
        Funcionario newFuncionario = new Funcionario(funcionario);
        this.saveFuncionario(newFuncionario);
        return newFuncionario;
    }

    public List<Funcionario> getAllFuncionarios(){
        return this.funcionarioRepository.findAll();
    }

    public Funcionario findFuncionarioById(Long id) throws Exception {
        return this.funcionarioRepository.findFuncionarioById(id).orElseThrow(()-> new Exception("Usuário não encontrado"));
    }

    public void deleteFuncionario(Long id){
        this.funcionarioRepository.deleteById(id);
    }

    public Funcionario updateFuncionario(Long id, Funcionario funcionario) throws Exception {
        Funcionario passFuncionario = findFuncionarioById(id);
        if (funcionario.getNome()!= null) {
            passFuncionario.setNome(funcionario.getNome());
        }
        if (funcionario.getCargo() != null) {
            passFuncionario.setCargo(funcionario.getCargo());
        }
        if (funcionario.getTelefone() != null) {
            passFuncionario.setTelefone(funcionario.getTelefone());
        }
        return funcionarioRepository.save(passFuncionario);
    }
}

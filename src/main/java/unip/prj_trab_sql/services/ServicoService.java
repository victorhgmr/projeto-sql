package unip.prj_trab_sql.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unip.prj_trab_sql.animal.Animal;
import unip.prj_trab_sql.animal.AnimalDTO;
import unip.prj_trab_sql.repositories.ServicoRepository;
import unip.prj_trab_sql.servico.Servico;
import unip.prj_trab_sql.servico.ServicoDTO;

import java.util.List;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository repository;

    public void saveServico(Servico servico){
        this.repository.save(servico);
    }

    public Servico createServico(ServicoDTO servico){
        Servico newServico = new Servico(servico);
        this.saveServico(newServico);
        return newServico;
    }

    public List<Servico> getAllServicos(){
        return this.repository.findAll();
    }

    public Servico findServicoById(Long id) throws Exception {
        return this.repository.findServicoById(id).orElseThrow(()-> new Exception("Usuário não encontrado"));
    }

    public void delete(Long id){
        this.repository.deleteById(id);
    }

    public Servico update(Long id, Servico servico) throws Exception {
        Servico passServico = findServicoById(id);
        if (servico.getNome()!= null) {
            passServico.setNome(servico.getNome());
        }
        if (servico.getDescricao() != null) {
            passServico.setDescricao(servico.getDescricao());
        }
        if (servico.getPreco() != null) {
            passServico.setPreco(servico.getPreco());
        }
        return repository.save(passServico);
    }
}

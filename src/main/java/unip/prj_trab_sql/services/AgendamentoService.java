package unip.prj_trab_sql.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unip.prj_trab_sql.agendamento.Agendamento;
import unip.prj_trab_sql.agendamento.AgendamentoDTO;
import unip.prj_trab_sql.repositories.AgendamentoRepository;

import java.util.List;

@Service
public class AgendamentoService {
    @Autowired
    private AgendamentoRepository agendamentoRepository;

    // Service Agendamento

    public void saveAgendamento(Agendamento agendamento){
        this.agendamentoRepository.save(agendamento);
    }

    public Agendamento createAgendamento(AgendamentoDTO agendamento){
        Agendamento newAgendamento = new Agendamento(agendamento);
        this.saveAgendamento(newAgendamento);
        return newAgendamento;
    }

    public List<Agendamento> getAllAgendamentos(){
        return this.agendamentoRepository.findAll();
    }

    public Agendamento findAgendamentoById(Long id) throws Exception {
        return this.agendamentoRepository.findAgendamentoById(id).orElseThrow(()-> new Exception("Usuário não encontrado"));
    }

    public void deleteAgendamento(Long id){
        this.agendamentoRepository.deleteById(id);
    }

    public Agendamento updateAgendamento(Long id, Agendamento agendamento) throws Exception {
        Agendamento passAgendamento = findAgendamentoById(id);
        if (agendamento.getData()!= null) {
            passAgendamento.setData(agendamento.getData());
        }
        if (agendamento.getStatus() != null) {
            passAgendamento.setStatus(agendamento.getStatus());
        }
        if (agendamento.getId_usuario() != null) {
            passAgendamento.setId_usuario(agendamento.getId_usuario());
        }
        if (agendamento.getId_animal() != null) {
            passAgendamento.setId_animal(agendamento.getId_animal());
        }
        if (agendamento.getId_servico() != null) {
            passAgendamento.setId_servico(agendamento.getId_servico());
        }
        return agendamentoRepository.save(passAgendamento);
    }
}

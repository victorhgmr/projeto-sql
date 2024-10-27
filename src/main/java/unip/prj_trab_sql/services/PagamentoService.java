package unip.prj_trab_sql.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unip.prj_trab_sql.agendamento.Agendamento;
import unip.prj_trab_sql.agendamento.AgendamentoDTO;
import unip.prj_trab_sql.pagamento.Pagamento;
import unip.prj_trab_sql.pagamento.PagamentoDTO;
import unip.prj_trab_sql.repositories.AgendamentoRepository;
import unip.prj_trab_sql.repositories.PagamentoRepository;

import java.util.List;

@Service
public class PagamentoService {
    @Autowired
    private PagamentoRepository pagamentoRepository;

    // Service Pagamento

    public void savePagamento(Pagamento pagamento){
        this.pagamentoRepository.save(pagamento);
    }

    public Pagamento createPagamento(PagamentoDTO pagamento){
        Pagamento newPagamento = new Pagamento(pagamento);
        this.savePagamento(newPagamento);
        return newPagamento;
    }

    public List<Pagamento> getAllPagamentos(){
        return this.pagamentoRepository.findAll();
    }

    public Pagamento findPagamentoById(Long id) throws Exception {
        return this.pagamentoRepository.findPagamentoById(id).orElseThrow(()-> new Exception("Usuário não encontrado"));
    }

    public void deletePagamento(Long id){
        this.pagamentoRepository.deleteById(id);
    }

    public Pagamento updatePagamento(Long id, Pagamento pagamento) throws Exception {
        Pagamento passPagamento = findPagamentoById(id);
        if (pagamento.getId_agendamento()!= null) {
            passPagamento.setId_agendamento(pagamento.getId_agendamento());
        }
        if (pagamento.getValor() != null) {
            passPagamento.setValor(pagamento.getValor());
        }
        if (pagamento.getMetodo() != null) {
            passPagamento.setMetodo(pagamento.getMetodo());
        }
        if (pagamento.getStatus() != null) {
            passPagamento.setStatus(pagamento.getStatus());
        }
        return pagamentoRepository.save(passPagamento);
    }
}

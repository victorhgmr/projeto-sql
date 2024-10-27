package unip.prj_trab_sql.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unip.prj_trab_sql.agendamento.Agendamento;
import unip.prj_trab_sql.agendamento.AgendamentoDTO;
import unip.prj_trab_sql.pagamento.Pagamento;
import unip.prj_trab_sql.pagamento.PagamentoDTO;
import unip.prj_trab_sql.services.AgendamentoService;
import unip.prj_trab_sql.services.PagamentoService;
import unip.prj_trab_sql.services.ServicoService;
import unip.prj_trab_sql.servico.Servico;
import unip.prj_trab_sql.servico.ServicoDTO;
import unip.prj_trab_sql.user.User;
import unip.prj_trab_sql.user.UserDTO;

import java.util.List;

@RestController
@RequestMapping("/servico")
public class ServicoController {
    //Imports
    @Autowired
    private ServicoService servicoService;

    @Autowired
    private AgendamentoService agendamentoService;

    @Autowired
    private PagamentoService pagamentoService;

    // Servico Controllerr

    @PostMapping("/servicos")
    public ResponseEntity<Servico> createUser(@Valid @RequestBody ServicoDTO servico){
        Servico newServico = servicoService.createServico(servico);
        return new ResponseEntity<>(newServico, HttpStatus.CREATED);
    }

    @GetMapping("/servicos")
    public ResponseEntity<List<Servico>> getAllServicos(){
        var servicos = servicoService.getAllServicos();
        return new ResponseEntity<>(servicos, HttpStatus.OK);
    }

    @DeleteMapping("/servicos/{id}")
    public ResponseEntity<String> deleteServico(@PathVariable("id") Long id){
        this.servicoService.delete(id);
        return ResponseEntity.ok("resource deleted successfully");
    }

    @PutMapping("/servicos/{id}")
    public ResponseEntity<Servico> updateServico(@PathVariable("id") Long id,@Valid @RequestBody Servico servico) throws Exception {
        var upadatedServico = this.servicoService.update(id, servico);
        return new ResponseEntity<>(upadatedServico, HttpStatus.OK );
    }

    // Agendamento Controller

    @PostMapping("/agendamento")
    public ResponseEntity<Agendamento> createAgendamento(@Valid @RequestBody AgendamentoDTO agendamento){
        Agendamento newAgendamento = agendamentoService.createAgendamento(agendamento);
        return new ResponseEntity<>(newAgendamento, HttpStatus.CREATED);
    }

    @GetMapping("/agendamento")
    public ResponseEntity<List<Agendamento>> getAllAgendamentos(){
        var agendamentos = agendamentoService.getAllAgendamentos();
        return new ResponseEntity<>(agendamentos, HttpStatus.OK);
    }

    @DeleteMapping("/agendamento/{id}")
    public ResponseEntity<String> deleteAgendamento(@PathVariable("id") Long id){
        this.agendamentoService.deleteAgendamento(id);
        return ResponseEntity.ok("resource deleted successfully");
    }

    @PutMapping("/agendamento/{id}")
    public ResponseEntity<Agendamento> updateAgendamento(@PathVariable("id") Long id,@Valid @RequestBody Agendamento agendamento) throws Exception {
        var upadatedAgendamento = this.agendamentoService.updateAgendamento(id, agendamento);
        return new ResponseEntity<>(upadatedAgendamento, HttpStatus.OK );
    }

    // Pagamento Controller

    @PostMapping("/pagamento")
    public ResponseEntity<Pagamento> createPagamento(@Valid @RequestBody PagamentoDTO pagamento){
        Pagamento newPagamento = pagamentoService.createPagamento(pagamento);
        return new ResponseEntity<>(newPagamento, HttpStatus.CREATED);
    }

    @GetMapping("/pagamento")
    public ResponseEntity<List<Pagamento>> getAllPagamentos(){
        var pagamentos = pagamentoService.getAllPagamentos();
        return new ResponseEntity<>(pagamentos, HttpStatus.OK);
    }

    @DeleteMapping("/pagamento/{id}")
    public ResponseEntity<String> deletePagamento(@PathVariable("id") Long id){
        this.pagamentoService.deletePagamento(id);
        return ResponseEntity.ok("resource deleted successfully");
    }

    @PutMapping("/pagamento/{id}")
    public ResponseEntity<Pagamento> updatePagamento(@PathVariable("id") Long id,@Valid @RequestBody Pagamento pagamento) throws Exception {
        var upadatedPagamento = this.pagamentoService.updatePagamento(id, pagamento);
        return new ResponseEntity<>(upadatedPagamento, HttpStatus.OK );
    }
}

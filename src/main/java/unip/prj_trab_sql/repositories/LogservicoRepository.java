package unip.prj_trab_sql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import unip.prj_trab_sql.agendamento.Agendamento;
import unip.prj_trab_sql.logservico.Logservico;

import java.util.Optional;

public interface LogservicoRepository extends JpaRepository<Logservico,Long> {
    Optional<Logservico> findLogservicoById(Long id);
}

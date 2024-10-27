package unip.prj_trab_sql.repositories;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unip.prj_trab_sql.agendamento.Agendamento;

import java.util.Optional;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento,Long> {
    Optional<Agendamento> findAgendamentoById(Long id);
}

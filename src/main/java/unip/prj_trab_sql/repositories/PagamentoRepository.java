package unip.prj_trab_sql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import unip.prj_trab_sql.agendamento.Agendamento;
import unip.prj_trab_sql.pagamento.Pagamento;

import java.util.Optional;

public interface PagamentoRepository extends JpaRepository<Pagamento,Long> {
    Optional<Pagamento> findPagamentoById(Long id);
}

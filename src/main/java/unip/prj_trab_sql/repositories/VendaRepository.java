package unip.prj_trab_sql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import unip.prj_trab_sql.user.User;
import unip.prj_trab_sql.venda.Venda;

import java.util.Optional;

public interface VendaRepository extends JpaRepository<Venda, Long> {
    Optional<Venda> findVendaById(Long id);
}

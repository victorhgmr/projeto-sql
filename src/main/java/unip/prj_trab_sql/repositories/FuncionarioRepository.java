package unip.prj_trab_sql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unip.prj_trab_sql.funcionario.Funcionario;
import java.util.Optional;
@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Optional<Funcionario> findFuncionarioById(Long id);
}

package unip.prj_trab_sql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import unip.prj_trab_sql.vendaproduto.Vendaproduto;

public interface VendaprodutoRepository extends JpaRepository<Vendaproduto, Long> {
}

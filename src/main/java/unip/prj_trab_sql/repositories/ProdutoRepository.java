package unip.prj_trab_sql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import unip.prj_trab_sql.produto.Produto;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
    Optional<Produto> findProdutoById(Long id);
}

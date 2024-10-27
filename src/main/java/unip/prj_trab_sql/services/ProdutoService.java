package unip.prj_trab_sql.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unip.prj_trab_sql.produto.Produto;
import unip.prj_trab_sql.produto.ProdutoDTO;
import unip.prj_trab_sql.repositories.ProdutoRepository;
import unip.prj_trab_sql.repositories.UserRepository;
import unip.prj_trab_sql.user.User;
import unip.prj_trab_sql.user.UserDTO;

import java.util.List;

@Service
public class ProdutoService {
    //Imports
    @Autowired
    private ProdutoRepository produtoRepository;

    // Service User

    public void saveProduto(Produto produto){
        this.produtoRepository.save(produto);
    }

    public Produto createProduto(ProdutoDTO produto){
        Produto newProduto = new Produto(produto);
        this.saveProduto(newProduto);
        return newProduto;
    }

    public List<Produto> getAllProdutos(){
        return this.produtoRepository.findAll();
    }

    public Produto findProdutoById(Long id) throws Exception {
        return this.produtoRepository.findProdutoById(id).orElseThrow(()-> new Exception("Usuário não encontrado"));
    }

    public void deleteProduto(Long id){
        this.produtoRepository.deleteById(id);
    }

    public Produto updateProduto(Long id, Produto produto) throws Exception {
        Produto passProduto = findProdutoById(id);
        if (produto.getNome()!= null) {
            passProduto.setNome(produto.getNome());
        }
        if (produto.getDescricao() != null) {
            passProduto.setDescricao(produto.getDescricao());
        }
        if (produto.getPreco() != null) {
            passProduto.setPreco(produto.getPreco());
        }

        return produtoRepository.save(passProduto);
    }
}

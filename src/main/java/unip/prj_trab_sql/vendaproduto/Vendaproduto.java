package unip.prj_trab_sql.vendaproduto;

import jakarta.persistence.*;
import lombok.*;
import unip.prj_trab_sql.venda.VendaDTO;

@Entity(name = "vendaproduto")
@Table(name = "vendaproduto")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Vendaproduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_venda")
    private Long id_venda;

    @Column(name = "id_produto")
    private Long id_produto;

    @Column(name = "quantidade")
    private Long quantidade;

    public Vendaproduto(VendaprodutoDTO dto){
        this.id_venda = dto.id_venda();
        this.id_produto = dto.id_produto();
        this.quantidade = dto.quantidade();
    }

}

package unip.prj_trab_sql.produto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import unip.prj_trab_sql.animal.AnimalDTO;

@Entity(name = "produto")
@Table(name = "produto")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max=50)
    @NotBlank(message = "campo não pode ser nulo")
    @Column(name = "nome")
    private String nome;

    @Size(max=50)
    @NotBlank(message = "campo não pode ser nulo")
    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco")
    private Long preco;

    public Produto(ProdutoDTO dto){
        this.nome = dto.nome();
        this.descricao = dto.descricao();
        this.preco = dto.preco();
    }
}

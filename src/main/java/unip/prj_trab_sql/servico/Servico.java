package unip.prj_trab_sql.servico;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
@Entity(name = "servico")
@Table(name = "servico")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max=50)
    @NotBlank(message = "campo não pode ser nulo")
    private String nome;

    @Size(max=50)
    @NotBlank(message = "campo não pode ser nulo")
    private String descricao;

    private Long preco;

    public Servico(ServicoDTO dto){
        this.nome = dto.nome();
        this.descricao = dto.descricao();
        this.preco = dto.preco();
    }
}

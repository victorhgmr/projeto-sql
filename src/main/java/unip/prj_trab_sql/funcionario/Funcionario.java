package unip.prj_trab_sql.funcionario;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import unip.prj_trab_sql.user.UserDTO;

@Entity(name = "funcionario")
@Table(name = "funcionario")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max=50)
    @NotBlank(message = "campo não pode ser nulo")
    private String nome;

    @Size(max=50)
    @NotBlank(message = "campo não pode ser nulo")
    private String cargo;

    @Size(max=50)
    @NotBlank(message = "campo não pode ser nulo")
    private String telefone;

    public Funcionario(FuncionarioDTO dto){
        this.nome = dto.nome();
        this.cargo = dto.cargo();
        this.telefone = dto.telefone();
    }
}

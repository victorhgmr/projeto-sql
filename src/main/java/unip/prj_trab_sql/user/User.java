package unip.prj_trab_sql.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max=50)
    @NotBlank(message = "campo não pode ser nulo")
    private String nome;

    @Size(max=50)
    @Column(unique = true)
    @NotBlank(message = "campo não pode ser nulo")
    @Email(message = "cadastre um email valido")
    private String email;

    @Size(max=50)
    @NotBlank(message = "campo não pode ser nulo")
    private String senha;

    @Size(max=50)
    @NotBlank(message = "campo não pode ser nulo")
    private String telefone;

    @Size(max=50)
    @NotBlank(message = "campo não pode ser nuloo")
    private String endereco;

    public User(UserDTO dto){
        this.nome = dto.nome();
        this.email = dto.email();
        this.senha = dto.senha();
        this.telefone = dto.telefone();
        this.endereco = dto.endereco();
    }
}

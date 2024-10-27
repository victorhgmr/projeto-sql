package unip.prj_trab_sql.animal;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import unip.prj_trab_sql.user.UserDTO;

@Entity(name = "animal")
@Table(name = "animal")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max=50)
    @NotBlank(message = "campo não pode ser nulo")
    private String nome;

    @Size(max=50)
    @NotBlank(message = "campo não pode ser nulo")
    private String especie;

    @Size(max=50)
    @NotBlank(message = "campo não pode ser nulo")
    private String raca;

    @Size(max=50)
    @NotBlank(message = "campo não pode ser nulo")
    private Long idade;

    @Size(max=50)
    @NotBlank(message = "campo não pode ser nulo")
    private Long dono;


    public Animal(AnimalDTO dto){
        this.nome = dto.nome();
        this.especie = dto.especie();
        this.raca = dto.raca();
        this.idade = dto.idade();
        this.dono = dto.dono();
    }
}

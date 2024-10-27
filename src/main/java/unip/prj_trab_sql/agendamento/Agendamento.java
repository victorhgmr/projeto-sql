package unip.prj_trab_sql.agendamento;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "agendamento")
@Table(name = "agendamento")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime data;

    @Size(max=50)
    @NotBlank(message = "campo não pode ser nulo")
    private String status;

    @Column(name = "id_usuario")
    private Long id_usuario;

    @Column(name = "id_animal")
    private Long id_animal;

    @Column(name = "id_servico")
    private Long id_servico;

    public Agendamento(AgendamentoDTO dto){
        this.data = dto.data();
        this.status = dto.status();
        this.id_usuario = dto.id_usuario();
        this.id_animal = dto.id_animal();
        this.id_servico = dto.id_servico();
    }
}

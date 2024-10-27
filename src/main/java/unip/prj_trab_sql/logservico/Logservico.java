package unip.prj_trab_sql.logservico;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import unip.prj_trab_sql.agendamento.AgendamentoDTO;

import java.time.LocalDateTime;

@Entity(name = "logservico")
@Table(name = "logservico")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Logservico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime data;

    @Column(name = "id_agendamento")
    private Long id_agendamento;

    @Column(name = "id_servico")
    private Long id_servico;

    @Column(name = "id_funcionario")
    private Long id_funcionario;

    @Size(max=50)
    @NotBlank(message = "campo não pode ser nulo")
    private String observacao;

    public Logservico(LogservicoDTO dto){
        this.data = dto.data();
        this.id_agendamento = dto.id_agendamento();
        this.id_servico = dto.id_servico();
        this.id_funcionario = dto.id_funcionario();
        this.observacao = dto.observacao();
    }
}

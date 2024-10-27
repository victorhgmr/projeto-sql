package unip.prj_trab_sql.pagamento;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import unip.prj_trab_sql.servico.ServicoDTO;

@Entity(name = "pagamento")
@Table(name = "pagamento")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_agendamento")
    private Long id_agendamento;

    @Column(name = "valor")
    private Long valor;

    @Column(name = "metodo")
    @Size(max=50)
    @NotBlank(message = "campo não pode ser nulo")
    private String metodo;

    @Column(name = "status")
    @Size(max=50)
    @NotBlank(message = "campo não pode ser nulo")
    private String status;

    public Pagamento(PagamentoDTO dto){
        this.id_agendamento = dto.id_agendamento();
        this.valor = dto.valor();
        this.metodo = dto.metodo();
        this.status = dto.status();
    }

}

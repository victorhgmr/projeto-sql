package unip.prj_trab_sql.venda;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import unip.prj_trab_sql.user.UserDTO;

import java.time.LocalDateTime;

@Entity(name = "venda")
@Table(name = "venda")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime data;

    @Column(name = "valor_total")
    private Long valor_total;

    @Column(name = "id_user")
    private Long id_user;

    public Venda(VendaDTO dto){
        this.data = dto.data();
        this.valor_total = dto.valor_total();
        this.id_user = dto.id_user();
    }
}

package unip.prj_trab_sql.venda;

import java.time.LocalDateTime;

public record VendaDTO(
        LocalDateTime data,
        Long valor_total,
        Long id_user

        ) {
}

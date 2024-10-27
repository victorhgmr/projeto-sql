package unip.prj_trab_sql.agendamento;

import java.time.LocalDateTime;

public record AgendamentoDTO(
        LocalDateTime data,
        String status,
        Long id_usuario,
        Long id_animal,
        Long id_servico
) {
}

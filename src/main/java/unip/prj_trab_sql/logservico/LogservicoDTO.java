package unip.prj_trab_sql.logservico;

import java.time.LocalDateTime;

public record LogservicoDTO(
        LocalDateTime data,
        Long id_agendamento,
        Long id_servico,
        Long id_funcionario,
        String observacao
) {
}

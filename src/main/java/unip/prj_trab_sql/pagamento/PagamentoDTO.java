package unip.prj_trab_sql.pagamento;

public record PagamentoDTO(
        Long id_agendamento,
        Long valor,
        String metodo,
        String status
        ) {
}

package unip.prj_trab_sql.animal;

public record AnimalDTO(
        String nome,
        String especie,
        String raca,
        Long idade,
        Long dono
) {
}

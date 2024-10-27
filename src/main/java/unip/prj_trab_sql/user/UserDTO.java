package unip.prj_trab_sql.user;

import java.math.BigDecimal;

public record UserDTO(

        String nome,
        String email,
        String senha,
        String telefone,
        String endereco

) {
}


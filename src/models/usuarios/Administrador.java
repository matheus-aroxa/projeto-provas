package models.usuarios;

import java.time.LocalDate;

public class Administrador extends Usuario {

    public Administrador(int id, String nome, long cpf, LocalDate dataDeNascimento, String email, String senha) {
        super(id, nome, cpf, dataDeNascimento, email, senha);
    }

    public Administrador() {
    }


}

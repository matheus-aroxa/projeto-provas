package models.usuarios;

import java.time.LocalDate;

public class Administrador extends Usuario {
    public Administrador(int id, String nome, int cpf, LocalDate dataDeNascimento, String email, String senha) {
        super(id, nome, cpf, dataDeNascimento, email, senha);
    }
    public Administrador() {
        super();
    }
}

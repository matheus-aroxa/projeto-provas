package DAO;

import models.usuarios.Administrador;

import java.time.LocalDate;

public interface AdministradorDAO {
    public Administrador criarAdministrador(int id, String nome, int cpf, LocalDate dataDeNascimento, String email, String senha);

    public void removerAdministrador(int id);
}

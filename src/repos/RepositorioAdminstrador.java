package repos;

import models.usuarios.Administrador;

import java.time.LocalDate;

public class RepositorioAdminstrador {
    private static RepositorioAdminstrador instancia;
    private Administrador[] administradores;


    private RepositorioAdminstrador (int tamanho) {
        this.administradores = new Administrador[tamanho];
    }

    public static RepositorioAdminstrador getInstancia (int tamanho) {
        if (instancia == null) {
            instancia = new RepositorioAdminstrador(tamanho);
        }
        return instancia;
    }

    //private adicionar(Administrador administrador){
    //    return ;
    //}
}

package repos;

import DAO.AdministradorDAO;
import models.usuarios.Administrador;
import models.usuarios.Usuario;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class RepositorioAdminstrador {
    private static RepositorioAdminstrador instancia;
    private static AtomicInteger contador = new AtomicInteger();
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

    private void criar(String nome, long cpf, LocalDate dataDeNascimento, String email, String senha){
        Administrador administrador = new Administrador();

        administrador.setId(contador.incrementAndGet());
        administrador.setNome(nome);
        administrador.setCpf(cpf);
        administrador.setDataDeNascimento(dataDeNascimento);
        administrador.setEmail(email);
        administrador.setSenha(senha);

        administradores[contador.get() -1 ] = administrador;
    }

    //public void remover (int id){
    //
    //}

}

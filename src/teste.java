import models.usuarios.Aluno;
import models.usuarios.Usuario;
import models.usuarios.professor.Professor;
import repos.RepositorioUsuarios;

import java.time.LocalDate;

public class teste {
    public static void main(String[] args) {
        RepositorioUsuarios repositorio = RepositorioUsuarios.getInstance(10);
        repositorio.criarAdministrador("paulo", 10, LocalDate.now(), "paulo@gmail.com", "123456");
        repositorio.criarAluno("paula", 12, LocalDate.now(), "paula@gmail.com", "123456", 10);
        repositorio.criarProfessor("marcos", 12, LocalDate.now(), "marcos@gmail.com", "123456", 10);

        repositorio.removerUsuario(2);

        for(Usuario user: repositorio.getUsuarios()) {
                System.out.println(user);
        }


    }
}
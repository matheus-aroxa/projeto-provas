import models.provas.CartaoResposta;
import models.provas.Questao;
import models.usuarios.Aluno;
import models.usuarios.Usuario;
import models.usuarios.professor.Professor;
import repos.RepositorioProvas;
import repos.RepositorioQuestoes;
import repos.RepositorioUsuarios;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class teste {
    public static void main(String[] args) {
        RepositorioUsuarios repositorio = RepositorioUsuarios.getInstance(10);
        RepositorioQuestoes repoQuestoes = RepositorioQuestoes.getInstance(10);
        RepositorioProvas repoProvas = RepositorioProvas.getInstance(10);

        repositorio.criarAdministrador("paulo", 11111111111L , LocalDate.now(), "paulo@gmail.com", "123456");
        repositorio.criarAluno("paula", 21111111111L, LocalDate.now(), "paula@gmail.com", "123456", 10);
        repositorio.criarProfessor("marcos", 31111111111L, LocalDate.now(), "marcos@gmail.com", "123456", 10,20);


        repositorio.removerUsuario(2);

        for(Usuario user: repositorio.getUsuarios()) {
                System.out.println(user);
        }


    }
}

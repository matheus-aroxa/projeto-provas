import models.provas.Questao;
import repos.RepositorioAdminstrador;
import repos.RepositorioQuestoes;

public class teste {
    public static void main(String[] args) {
        RepositorioAdminstrador repositorioAdminstrador = RepositorioAdminstrador.getInstancia(10);
        RepositorioAdminstrador repositorioAdminstrador2 = RepositorioAdminstrador.getInstancia(10);

        System.out.println(repositorioAdminstrador);
        System.out.println(repositorioAdminstrador2);

    }
}

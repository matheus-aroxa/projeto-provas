import models.Questao;
import repos.RepositorioQuestoes;

public class teste {
    public static void main(String[] args) {
//        RepositorioQuestoes dados = new RepositorioQuestoes().criaRepositorio(100);
//        if(dados.adicionarQuestao(new Questao(1,"Caça pombo",new int[]{1,2,3,4})))
//            System.out.printf("Adicionado com sucesso!\n");;
//        if(dados.buscarQuestao(1) != -1)
//            System.out.printf("encontrado com sucesso!\n");
//        if(dados.removerQuestao(1))
//            System.out.println("Removido com sucesso!");



        RepositorioQuestoes repo = RepositorioQuestoes.criaRepositorio(10);
        RepositorioQuestoes repo2 = RepositorioQuestoes.criaRepositorio(13);
        RepositorioQuestoes repo3 = RepositorioQuestoes.criaRepositorio(14);
        RepositorioQuestoes repo4 = RepositorioQuestoes.criaRepositorio(17);

        System.out.println(repo);
        System.out.println(repo2);
        System.out.println(repo3);
        System.out.println(repo4);

        repo.adicionarQuestao(new Questao(1,"adedonha",null));
        repo.adicionarQuestao(new Questao(2,"pau no gato",null));
        repo.adicionarQuestao(new Questao(3,"fila indiana",null));
        repo.listarQuestoes();
    }
}

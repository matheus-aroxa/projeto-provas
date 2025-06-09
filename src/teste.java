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



        RepositorioQuestoes repo = RepositorioQuestoes.criar(10);
        RepositorioQuestoes repo2 = RepositorioQuestoes.criar(13);
        RepositorioQuestoes repo3 = RepositorioQuestoes.criar(14);
        RepositorioQuestoes repo4 = RepositorioQuestoes.criar(17);

        System.out.println(repo);
        System.out.println(repo2);
        System.out.println(repo3);
        System.out.println(repo4);

        repo.adicionar(new Questao(1,"adedonha",null));
        repo.adicionar(new Questao(2,"pau no gato",null));
        repo.adicionar(new Questao(3,"fila indiana",null));
        repo.listar();
    }
}

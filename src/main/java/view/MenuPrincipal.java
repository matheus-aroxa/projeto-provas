package view;

import services.QuestaoService;
import services.UsuarioService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPrincipal {

    private static UsuarioService usuarioService = new UsuarioService();
    private static QuestaoService questaoService = new QuestaoService();

    public static void start() {
        int opcao;
        do {
            System.out.printf("\n%sBem vindo ao gerenciador de Provas!%s\n", VERDE, NEUTRO);
            System.out.println("\nDeseja Cadastrar qual classe?\n" +
                    "1 ⟶ Administrador\n" +
                    "2 ⟶ Aluno\n" +
                    "3 ⟶ Professor\n" +
                    "4 ⟶ Questão\n" +
                    "5 ⟶ Prova\n" +
                    "0 ⟶ Sair\n");

            opcao = lerOpcao();

            switch (opcao) {
                case ADMINISTRADOR:
                    System.out.println("Cadastrando Administrador...");
                    CadastroUsuariosView.cadastroAdministrador(usuarioService);
                    break;
                case ALUNO:
                    System.out.println("Cadastrando Aluno...");
                    CadastroUsuariosView.cadastroAluno(usuarioService);
                    break;
                case PROFESSOR:
                    System.out.println("Cadastrando Professor...");
                    CadastroUsuariosView.cadastroProfessor(usuarioService);
                    break;
                case QUESTAO:
                    System.out.println("Cadastrando Questão...");
                    CadastroQuestaoView.cadatro(questaoService);
                    break;
                case PROVA:
                    System.out.println("Cadastrando Prova...");
                    CadastroProvaView.cadatro();
                    break;
                case SAIR:
                    System.out.println("Saindo...");
                    System.out.printf("%sAté a próxima!%s\n", VERDE, NEUTRO);
                    break;
                default:
                    System.out.printf("%s<erro indeterminado>%s", VERMELHO, NEUTRO);
                    break;
            }
        } while (opcao != SAIR);
    }

    //métodos e variáveis utilitárias
    private static Scanner ler = new Scanner(System.in);
    private static final int //constantes lógicas
            SAIR = 0,ADMINISTRADOR = 1, ALUNO = 2, PROFESSOR = 3, QUESTAO = 4, PROVA = 5;
    private static final String //contantes de cores
            VERMELHO = "\033[31m", VERDE = "\033[32m", NEUTRO = "\033[m";

    private static int lerOpcao() {
        while (true) {
            try {
                int opcao = ler.nextInt();
                ler.nextLine();

                if (opcao >= MenuPrincipal.SAIR && opcao <= MenuPrincipal.PROVA) {
                    return opcao;
                } else {
                    //pode ser uma exceção, só fiz desse jeito porque não vejo um lugar onde pode ser reutilizado
                    System.out.printf("%sErro: Digite um valor entre %d e %d!%s\n",
                            VERMELHO, MenuPrincipal.SAIR, MenuPrincipal.PROFESSOR, NEUTRO);
                }
            } catch (InputMismatchException e) {
                System.out.printf("%sErro: O valor precisa ser inteiro!%s\n", VERMELHO, NEUTRO);
                ler.nextLine();
            }
        }
    }

}

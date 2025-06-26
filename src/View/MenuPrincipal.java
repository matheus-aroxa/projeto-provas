package View;

import services.UsuarioService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPrincipal {

    public static void start(UsuarioService usuarioService) {
        int opcao;
        CadastroUsuariosView cadastro;
        do {
            System.out.printf("\n%sBem vindo ao gerenciador de Provas!%s\n", VERDE, NEUTRO);
            System.out.println("\nDeseja Cadastrar qual classe?\n" +
                    "1 ⟶ Administrador\n" +
                    "2 ⟶ Aluno\n" +
                    "3 ⟶ Professor\n" +
                    "0 ⟶ Sair\n");

            opcao = lerOpcao(SAIR, PROFESSOR);

            switch (opcao) {
                case ADMINISTRADOR:
                    System.out.println("Cadastrando Administrador...");
                    cadastro = new CadastroUsuariosView();
                    cadastro.cadastroAdministrador(usuarioService);
                    break;
                case ALUNO:
                    System.out.println("Cadastrando Aluno...");
                    cadastro = new CadastroUsuariosView();
                    cadastro.cadastroAluno(usuarioService);
                    break;
                case PROFESSOR:
                    System.out.println("Cadastrando Professor...");
                    cadastro = new CadastroUsuariosView();
                    cadastro.cadastroProfessor(usuarioService);
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
            SAIR = 0,ADMINISTRADOR = 1, ALUNO = 2, PROFESSOR = 3;
    private static final String //contantes de cores
            VERMELHO = "\033[31m", VERDE = "\033[32m", NEUTRO = "\033[m";

    private static int lerOpcao(int inicio, int fim) {
        while (true) {
            try {
                int opcao = ler.nextInt();
                ler.nextLine();

                if (opcao >= inicio && opcao <= fim) {
                    return opcao;
                } else {
                    //pode ser uma exceção, só fiz desse jeito porque não vejo um lugar onde pode ser reutilizado
                    System.out.printf("%sErro: Digite um valor entre %d e %d!%s\n",
                            VERMELHO, inicio, fim, NEUTRO);
                }
            } catch (InputMismatchException e) {
                System.out.printf("%sErro: O valor precisa ser inteiro!%s\n", VERMELHO, NEUTRO);
                ler.nextLine();
            }
        }
    }

}

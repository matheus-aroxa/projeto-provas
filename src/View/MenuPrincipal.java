package View;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPrincipal {
    //variáveis da classe
    private static Scanner ler = new Scanner(System.in);

    //constantes
    private static final int
        SAIR = 0,ADMINISTRADOR = 1, ALUNO = 2, PROFESSOR = 3;

    private static final String
        VERMELHO = "\033[31m", VERDE = "\033[32m", NEUTRO = "\033[m";


    public static void inicio() {
        int opcao;
        do {
            System.out.printf("\n%sBem vindo ao gerenciador de Provas!%s\n", VERDE, NEUTRO);
            System.out.println("\nDeseja Utilizar qual repositório?\n" +
                    "1 ⟶ Administrador\n" +
                    "2 ⟶ Aluno\n" +
                    "3 ⟶ Professor\n" +
                    "0 ⟶ Sair\n");

            opcao = lerOpcao(SAIR, PROFESSOR);
            //ler.close();

            switch (opcao) {
                default:
                    System.out.printf("%s<erro indeterminado>%s", VERMELHO, NEUTRO);
                    break;
                case ADMINISTRADOR:
                    System.out.println("Cadastrando Administrador...");
                    CadastroView.cadastroAdministrador();
                    break;
                case ALUNO:
                    System.out.println("Cadastrando Aluno...");
                    CadastroView.cadastroAluno();
                    break;
                case PROFESSOR:
                    System.out.println("Cadastrando Professor...");
                    CadastroView.cadastroProfessor();
                    break;
                case SAIR:
                    System.out.println("Saindo...");
                    System.out.printf("%sAté a próxima!%s\n", VERDE, NEUTRO);
                    break;
            }
        } while (opcao != SAIR);
    }

    private static int lerOpcao(int inicio, int fim) {
        while (true) {
            try {
                int opcao = ler.nextInt();
                ler.nextLine();

                if (opcao >= inicio && opcao <= fim) {
                    return opcao;
                } else {
                    System.out.printf("%sErro: Digite um valor entre %d e %d!%s\n",
                            VERMELHO, inicio, fim, NEUTRO);
                }
            } catch (InputMismatchException e) {
                System.out.printf("%sErro: O valor precisa ser inteiro!%s\n", VERMELHO, NEUTRO);
                ler.nextLine();
            }
        }
    }

    public static void start(){
        inicio();
    }
}

package View;

import services.QuestaoService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CadastroQuestaoView {

    public static void cadatro(QuestaoService service){
        String enunciado = lerString("Digite o enunciado da questão:\n");
        //alterar este pedaço para criar as alternativas apartir daqui
        //service.criarQuestao(enunciado, null);
    }

    //métodos utilitários e variáveis utilitárias
    private static Scanner ler = new Scanner(System.in);
    private static final String VERMELHO = "\033[31m", VERDE = "\033[32m", NEUTRO = "\033[m";

    private static String lerString(String mensagem){
        String valor;
        do{
            System.out.println(mensagem);
            valor = ler.nextLine();
        }while (valor == null);
        return valor;
    }

    private static Long lerLong(String mensagem){
        Long valor = null;
        do{
            try{
                System.out.println(mensagem);
                valor = ler.nextLong();
            }catch (InputMismatchException e){
                System.out.printf("%sErro: O valor precisa ser Long!%s\n", VERMELHO, NEUTRO);
                ler.nextLine();
            }
        }while (valor == null);
        return valor;
    }

    private static Integer lerInt(String mensagem){
        Integer valor = null;
        do{
            try{
                System.out.println(mensagem);
                valor = ler.nextInt();
            }catch (InputMismatchException e){
                System.out.printf("%sErro: O valor precisa ser Long!%s\n", VERMELHO, NEUTRO);
                ler.nextLine();
            }
        }while (valor == null);
        return valor;
    }

}

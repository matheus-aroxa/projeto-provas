package View;

import models.Turma;
import models.provas.CartaoResposta;
import models.provas.Questao;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CadastroProvaView {

    public static void cadatro(){ //ProvaService service
        String titulo = lerString("Digite o título da prova: ");
        String descricao = lerString("Digite a Descrição da prova: \n");

        System.out.println("Digite a data e hora da aplicação da prova");
        LocalDateTime dataAplicacao = LocalDateTime.of(
            lerInt("Ano: "),lerInt("Mês"),lerInt("Dia: "),lerInt("Hora"),lerInt("Minuto"));

//        Period duracao = //period armazena apenas diferença de datas, não seria melhor Duration?
        System.out.println("A prova será remota[s/n]? ");
        boolean isRemoto = ler.nextLine().toLowerCase().indexOf(0) == 's';
//        Turma[] turmas;
//        Questao[] questoes;
//        CartaoResposta[] respostas;
        //service.criarProva(titulo, descricao, dataAplicacao, duracao, isRemoto, turmas, questoes, respostas);
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

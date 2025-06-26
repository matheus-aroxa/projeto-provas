package View;

import services.UsuarioService;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CadastroUsuariosView {

    private static Scanner ler = new Scanner(System.in);

    private static final String VERMELHO = "\033[31m", VERDE = "\033[32m", NEUTRO = "\033[m";

    private String nome, email, senha;
    private Integer idTurma;
    private Long cpf;
    private LocalDate data;
    {
        nome = lerString("Digite seu nome: ");
        cpf = lerLong("Digite o seu Cpf: ");
        ler.nextLine();
        System.out.println("Digite sua data de Nascimento:");
        data = LocalDate.of(lerInt("Ano: "),lerInt("Mês: "),lerInt("Dia: "));
        ler.nextLine();
        email = lerString("Digite seu e-mail: ");
        senha = lerString("Digite sua senha: ");
    }

    public void cadastroAdministrador(UsuarioService servico) {

        idTurma = lerInt("Digite o ID da turma: ");
        ler.nextLine();
        servico.criarAdministrador(nome, cpf, data, email, senha);
    }

    public void cadastroAluno(UsuarioService servico)
    {
        idTurma = lerInt("Digite o ID da turma: ");
        ler.nextLine();
        servico.criarAluno(nome, cpf, data, email, senha, idTurma);
    }

    public void cadastroProfessor(UsuarioService servico) {
        idTurma = lerInt("Digite o ID da turma: ");
        ler.nextLine();
        servico.criarProfessor(nome, cpf, data, email, senha, idTurma);
    }


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

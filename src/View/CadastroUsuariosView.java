package View;

import services.UsuarioService;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CadastroUsuariosView {

    private record Dados(    //struct para armazenar os dados em comum
        String nome, Long cpf, LocalDate dataNascimento, String email, String senha
    ) {}

    private static Dados cadastro() {   //bloco de inicialização para cadastrar os dados sem comum dos usuários
        String nome = lerString("Digite seu nome: ");
        Long cpf = lerLong("Digite o seu Cpf: ");
        ler.nextLine();
        System.out.println("Digite sua data de Nascimento:");
        LocalDate data = LocalDate.of(
            lerInt("Ano: "), lerInt("Mês: "), lerInt("Dia: "));
        ler.nextLine();
        String email = lerString("Digite seu e-mail: ");
        String senha = lerString("Digite sua senha: ");
        return new Dados(nome, cpf, data, email, senha);
    }

    public static void cadastroAdministrador(UsuarioService service) {
        Dados dados = cadastro();
        service.criarAdministrador(dados.nome(), dados.cpf(), dados.dataNascimento(), dados.email(), dados.senha());
    }

    public static void cadastroAluno(UsuarioService service) {
        Dados dados = cadastro();
        Integer idTurma = lerInt("Digite o ID da turma: ");
        ler.nextLine();
        service.criarAluno(dados.nome(), dados.cpf(), dados.dataNascimento(), dados.email(), dados.senha(), idTurma);
    }

    public static void cadastroProfessor(UsuarioService service) {
        Dados dados = cadastro();
        Integer idTurma = lerInt("Digite o ID da turma: ");
        ler.nextLine();
        service.criarProfessor(dados.nome(), dados.cpf(), dados.dataNascimento(), dados.email(), dados.senha(), idTurma);
    }


    //métodos e variáveis utilitárias
    private static Scanner ler = new Scanner(System.in);
    private static final String VERMELHO = "\033[31m", VERDE = "\033[32m", NEUTRO = "\033[m";

    private static String lerString(String mensagem) {
        String valor;
        do {
            System.out.println(mensagem);
            valor = ler.nextLine();
        } while (valor == null);
        return valor;
    }

    private static Long lerLong(String mensagem) {
        Long valor = null;
        do {
            try {
                System.out.println(mensagem);
                valor = ler.nextLong();
            } catch (InputMismatchException e) {
                System.out.printf("%sErro: O valor precisa ser Long!%s\n", VERMELHO, NEUTRO);
                ler.nextLine();
            }
        } while (valor == null);
        return valor;
    }

    private static Integer lerInt(String mensagem) {
        Integer valor = null;
        do {
            try {
                System.out.println(mensagem);
                valor = ler.nextInt();
            } catch (InputMismatchException e) {
                System.out.printf("%sErro: O valor precisa ser Long!%s\n", VERMELHO, NEUTRO);
                ler.nextLine();
            }
        } while (valor == null);
        return valor;
    }

}

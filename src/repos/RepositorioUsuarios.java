package repos;

import controller.CadastroProfessor;
import models.usuarios.Administrador;
import models.usuarios.Aluno;
import models.usuarios.Usuario;
import models.usuarios.professor.Professor;
import models.usuarios.professor.ProfessorSalarioFixo;
import models.usuarios.professor.ProfessorSalarioHora;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class RepositorioUsuarios {

    private Usuario[] usuarios;
    private static AtomicInteger contador = new AtomicInteger();
    private static RepositorioUsuarios instance;

    private RepositorioUsuarios(int tamanho) {
        this.usuarios = new Usuario[tamanho];
    }

    public static RepositorioUsuarios getInstance(int tam){
        if(instance == null){
            instance = new RepositorioUsuarios(tam);
        }
        return instance;
    }

    public void criarAdministrador(String nome, int cpf, LocalDate dataDeNascimento, String email, String senha) {
        usuarios[contador.get()] = new Administrador(contador.incrementAndGet(), nome, cpf, dataDeNascimento, email, senha);
    }

    public void criarAluno(String nome, int cpf, LocalDate dataDeNascimento, String email, String senha, int idTurma) {
        usuarios[contador.get()] = new Aluno(contador.incrementAndGet(), nome, cpf, dataDeNascimento, email, senha, idTurma);
    }

    public void criarProfessor(String nome, int cpf, LocalDate dataDeNascimento, String email, String senha, int idTurma,double salario) {
        usuarios[contador.get()] = CadastroProfessor.cadastro(instance,contador.incrementAndGet(), nome, cpf, dataDeNascimento, email, senha, idTurma, salario);
    }

    public void criarProfessor(String nome, int cpf, LocalDate dataDeNascimento, String email, String senha, int idTurma,double salario,int horas){
        usuarios[contador.get()] = CadastroProfessor.cadastro(instance,contador.incrementAndGet(), nome, cpf, dataDeNascimento, email, senha, idTurma, salario, horas);
    }

    public int procurarUsuario(int id){
        for(int i = 0; i < usuarios.length; i++){
            if(usuarios[i].getId() == id){
                return i;
            }
        }
        return -1;
    }

    public void removerUsuario(int id){
        int find = procurarUsuario(id); //verifica se o usuario existe e se existe retorna a posição dele
        if(find == -1) return; // se o usuario nao existe nao executa o restante do codigo

        usuarios[find] = null; // remove o usuario do array
        for(int i = find; i < usuarios.length - 1; i++){
            usuarios[i] = usuarios[i + 1]; // remove os buracos apos a remocao
        }
    }


    public Usuario[] getUsuarios() {  //apagar no codigo oficial
        return usuarios;
    }
}

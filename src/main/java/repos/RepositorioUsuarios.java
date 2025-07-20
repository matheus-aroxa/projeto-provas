package repos;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

import models.usuarios.Administrador;
import models.usuarios.Aluno;
import models.usuarios.Usuario;
import models.usuarios.professor.Professor;

public class RepositorioUsuarios {

    private Usuario[] usuarios;
    private static AtomicInteger contador = new AtomicInteger();
    private static RepositorioUsuarios instance;

    private RepositorioUsuarios(int tamanho) {
        this.usuarios = new Usuario[tamanho];
    }

    public static RepositorioUsuarios getInstance(int tam) {
        if (instance == null) {
            instance = new RepositorioUsuarios(tam);
        }
        return instance;
    }

    public AtomicInteger getContador() {
        return contador;
    }

    public Usuario[] getUsuarios() {  //apagar no codigo oficial
        return usuarios;
    }

    public void criarAluno(Aluno aluno) {
        usuarios[contador.get()] = new Aluno(contador.incrementAndGet(), aluno.getNome(), aluno.getCpf(), aluno.getDataDeNascimento(),
                aluno.getEmail(), aluno.getSenha(), aluno.getIdTurma());
    }

    public void criarAdministrador(String nome, long cpf, LocalDate dataDeNascimento, String email, String senha) {
        usuarios[contador.get()] = new Administrador(contador.incrementAndGet(), nome, cpf, dataDeNascimento, email, senha);
    }

    public void criarProfessor(String nome, long cpf, LocalDate dataDeNascimento, String email, String senha, int idTurma) {
        usuarios[contador.get()] = new Professor(contador.incrementAndGet(), nome, cpf, dataDeNascimento, email, senha, idTurma);
    }

    public void editarAluno(Aluno aluno) {
        int posicao = procurarUsuario(aluno.getId());

        if (posicao != -1) {
            Usuario usuarioExistente = usuarios[posicao];

            if (usuarioExistente instanceof Aluno) {
                Aluno alunoExistente = (Aluno) usuarioExistente;
                alunoExistente.setNome(aluno.getNome());
                alunoExistente.setCpf(aluno.getCpf());
                alunoExistente.setDataDeNascimento(aluno.getDataDeNascimento());
                alunoExistente.setEmail(aluno.getEmail());
                alunoExistente.setSenha(aluno.getSenha());
                alunoExistente.setIdTurma(aluno.getIdTurma());
            }
        }
    }

    public int procurarUsuario(int id) {
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null && usuarios[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void removerUsuario(int id) {
        int find = procurarUsuario(id); //verifica se o usuario existe e se existe retorna a posição dele
        if (find == -1) {
            return; // se o usuario nao existe nao executa o restante do codigo
        }
        for (int i = find; i < usuarios.length - 1; i++) {
            usuarios[i] = usuarios[i + 1]; // remove os buracos apos a remocao
        }
        usuarios[usuarios.length - 1] = null; // remove o usuario do array
    }
}

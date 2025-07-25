package repos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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


    public void criarProfessor(Professor professor) {
        usuarios[contador.get()] = new Professor(contador.incrementAndGet(), professor.getNome(), professor.getCpf(),
                professor.getDataDeNascimento(), professor.getEmail(), professor.getSenha(), professor.getIdTurma(),professor.getDisciplina());
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

    public void editarProfessor(Professor professor) {
        int posicao = procurarUsuario(professor.getId());

        if (posicao != -1) {
            Usuario usuarioExistente = usuarios[posicao];

            if (usuarioExistente instanceof Professor) {
                Professor professorExistente = (Professor) usuarioExistente;
                
                professorExistente.setNome(professor.getNome());
                professorExistente.setCpf(professor.getCpf());
                professorExistente.setDataDeNascimento(professor.getDataDeNascimento());
                professorExistente.setEmail(professor.getEmail());
                professorExistente.setSenha(professor.getSenha());
                professorExistente.setIdTurma(professor.getIdTurma());
                professorExistente.setDisciplina(professor.getDisciplina());
            }
        }
    }

    public Professor getProfessor(int id) {
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null && usuarios[i].getId() == id) {
                Professor professor = (Professor) usuarios[i];
                return professor;
            }
        }
        return null;
    }

    public int getProfessorByName(String nome) {
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null && usuarios[i].getNome().equals(nome)) {
                int professor = usuarios[i].getId();
               // Professor professor = (Professor) usuarios[i];
                return professor;
            }
        }
        return -1;
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
        int find = procurarUsuario(id);
        if (find == -1) {
            return;
        }
        for (int i = find; i < usuarios.length - 1; i++) {
            usuarios[i] = usuarios[i + 1];
        }
        usuarios[usuarios.length - 1] = null;
    }

    public List<Usuario> findAll() {
        List<Usuario> usuariosEncontrados = new ArrayList<>();

        for (Usuario usuario : this.usuarios) {
            if (usuario != null) {
                usuariosEncontrados.add(usuario);
            }
        }

        return usuariosEncontrados;
    }

    public Usuario findUsuarioByEmail(String email) {
        for (Usuario usuario : this.usuarios) {
            if (usuario != null && usuario.getEmail().equalsIgnoreCase(email)) {
                return usuario;
            }
        }
        return null;
    }
}

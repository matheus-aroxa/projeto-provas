package DAO;

import models.usuarios.Aluno;
import models.usuarios.Usuario;
import repos.RepositorioUsuarios; // Importe seu repositório

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAOImpl implements AlunoDAO {

    // Pega a instância única do seu repositório de usuários
    private RepositorioUsuarios repositorio = RepositorioUsuarios.getInstance(100); // Defina um tamanho padrão

    @Override
    public List<Aluno> findAll() {
        List<Aluno> listaDeAlunos = new ArrayList<>();
        Usuario[] todosOsUsuarios = repositorio.getUsuarios();

        // Itera sobre todos os usuários no repositório
        for (Usuario usuario : todosOsUsuarios) {
            // Se o usuário não for nulo e for uma instância da classe Aluno...
            if (usuario instanceof Aluno) {
                // ...adiciona ele na nossa lista de alunos.
                listaDeAlunos.add((Aluno) usuario);
            }
        }
        return listaDeAlunos;
    }

    @Override
    public Aluno criarAluno(int id, String nome, long cpf, LocalDate dataDeNascimento, String email, String senha, int idTurma) {
        // Este método no seu repositório não retorna o Aluno criado, então adaptamos.
        repositorio.criarAluno(nome, cpf, dataDeNascimento, email, senha, idTurma);
        // Para satisfazer a interface, poderíamos buscar o aluno recém-criado, mas por enquanto retornamos null.
        return null;
    }

    @Override
    public void removerAluno(int id) {
        // Chama o método correspondente do seu repositório
        repositorio.removerUsuario(id);
    }
}
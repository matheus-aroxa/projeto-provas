package DAO;

import java.util.ArrayList;
import java.util.List;

import models.usuarios.Aluno; // Importe seu repositório
import models.usuarios.Usuario;
import repos.RepositorioUsuarios;

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
    public Aluno criarAluno(Aluno aluno) {
        // Este método no seu repositório não retorna o Aluno criado, então adaptamos.
        repositorio.criarAluno(aluno);
        // Para satisfazer a interface, poderíamos buscar o aluno recém-criado, mas por enquanto retornamos null.
        return null;
    }

    @Override
    public void removerAluno(int id) {
        // Chama o método correspondente do seu repositório
        repositorio.removerUsuario(id);
    }
}
package DAO;

import java.util.ArrayList;
import java.util.List;

import models.usuarios.Aluno; // Importe seu repositório
import models.usuarios.Usuario;
import repos.RepositorioUsuarios;

public class AlunoDAOImpl implements ObjectDAO<Aluno> {
    private final RepositorioUsuarios repositorio = RepositorioUsuarios.getInstance(100);

    @Override
    public List<Aluno> findAll() {
        List<Aluno> listaDeAlunos = new ArrayList<>();
        Usuario[] todosOsUsuarios = repositorio.getUsuarios();

        for (Usuario usuario : todosOsUsuarios) {
            if (usuario instanceof Aluno) {
                listaDeAlunos.add((Aluno) usuario);
            }
        }
        return listaDeAlunos;
    }

    @Override
    public Aluno criar(Aluno aluno) {
        repositorio.criarAluno(aluno);
        return null;
    }

    @Override
    public void remover(int id) {
        repositorio.removerUsuario(id);
    }
}
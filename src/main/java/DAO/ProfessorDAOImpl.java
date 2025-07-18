package DAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import models.usuarios.Usuario;
import models.usuarios.professor.Professor;
import repos.RepositorioUsuarios;

public class ProfessorDAOImpl implements ProfessorDAO {

    private RepositorioUsuarios repositorio = RepositorioUsuarios.getInstance(100);

    @Override
    public List<Professor> findAll() {
        List<Professor> listaDeProfessores = new ArrayList<>();
        Usuario[] todosOsUsuarios = repositorio.getUsuarios();

        // Itera sobre todos os usuários no repositório
        for (Usuario usuario : todosOsUsuarios) {
            // Se o usuário não for nulo e for uma instância da classe Aluno...
            if (usuario instanceof Professor) {
                // ...adiciona ele na nossa lista de alunos.
                listaDeProfessores.add((Professor) usuario);
            }
        }
        return listaDeProfessores;
    }

    @Override
    public Professor criarProfessor(int id, String nome, long cpf, LocalDate dataDeNascimento, String email,
            String senha, int idTurma) {
        //repositorio.addProfessor(id, nome, cpf, dataDeNascimento, email, senha, idTurma); //falta criar métodos de professor no repositório 
        return null;
    }

    @Override
    public void removerProfessor(int id) {
        repositorio.removerUsuario(id);
    }

}

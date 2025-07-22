package DAO;

import java.util.ArrayList;
import java.util.List;

import models.usuarios.Usuario;
import models.usuarios.professor.Professor;
import repos.RepositorioUsuarios;
import services.UsuarioService;

public class ProfessorDAOImpl implements ProfessorDAO {

    private final RepositorioUsuarios repositorio = RepositorioUsuarios.getInstance(100);

    @Override
    public List<Professor> findAll() {
        List<Professor> listaDeProfessores = new ArrayList<>();
        Usuario[] todosOsUsuarios = repositorio.getUsuarios();

        for (Usuario usuario : todosOsUsuarios) {
            if (usuario instanceof Professor professor) {
                listaDeProfessores.add(professor);
            }
        }
        return listaDeProfessores;
    }

    @Override
    public Professor criarProfessor(Professor professor) {
        return null;
    }

    @Override
    public void removerProfessor(int id) {
        repositorio.removerUsuario(id);
    }

    public String getNomePorId(int id) {
        Professor professor = repositorio.getProfessor(id); // seu método de busca
        if(professor != null) {
                return professor.getNome();
        }
        return "Desconhecido";
        }

        public int getIdPorNome(String nome){
        int id = repositorio.getProfessorByName(nome);
        return id;
        }

}

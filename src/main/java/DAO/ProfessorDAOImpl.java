package DAO;

import java.util.ArrayList;
import java.util.List;

import models.usuarios.Usuario;
import models.usuarios.professor.Professor;
import repos.RepositorioUsuarios;
import services.UsuarioService;

public class ProfessorDAOImpl implements ObjectDAO<Professor> {

    private final RepositorioUsuarios repositorio = RepositorioUsuarios.getInstance(100);
    private UsuarioService usuarioService = new UsuarioService();

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
    public Professor criar(Professor professor) {
        return null;
    }

    @Override
    public void remover(int id) {
        repositorio.removerUsuario(id);
    }

}

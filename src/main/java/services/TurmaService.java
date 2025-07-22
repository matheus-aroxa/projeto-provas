package services;

import java.util.List;

import models.Turma;
import repos.RepositorioTurmas;

public class TurmaService {
    RepositorioTurmas repositorio = RepositorioTurmas.getInstance(10);

    public boolean adicionarAlunoNaTurma(int idTurma, int idAluno) {
        Turma turma = repositorio.buscarAlunoPorId(idTurma);
        if (turma != null) {
            turma.adicionarAluno(idAluno);
            return true;
        }
        return false;
    }

    public List<Turma> listarTodasAsTurmas() {
        return repositorio.listarTodas();
    }
}

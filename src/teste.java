import models.provas.Questao;
import models.usuarios.Aluno;
import models.usuarios.Usuario;
import models.usuarios.professor.Professor;
import repos.RepositorioQuestoes;
import repos.RepositorioUsuarios;
import services.UsuarioService;

import java.time.LocalDate;

public class teste {
    
	public static void main(String[] args) {
    
    UsuarioService usuarioService = new UsuarioService();
 
    usuarioService.criarAluno("mathias", 2545658L, LocalDate.of(12, 2, 5), "vixe@gmail.com", "paiademais", 6);
//    usuarioService.criarAluno(null, null, null, null, null, null); amem
    }
}

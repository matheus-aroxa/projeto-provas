import View.MenuPrincipal;
import services.QuestaoService;
import services.UsuarioService;

public class teste {
    
	public static void main(String[] args) {
        UsuarioService usuarioService = new UsuarioService();
        QuestaoService questaoService = new QuestaoService();
        MenuPrincipal.start();
    }
}

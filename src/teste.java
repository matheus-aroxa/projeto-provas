import View.MenuPrincipal;
import services.UsuarioService;

public class teste {
    
	public static void main(String[] args) {
        UsuarioService usuarioService = new UsuarioService();
        MenuPrincipal.inicio(usuarioService);
    }
}

package Fachada;

import services.ProvaService;
import services.QuestaoService;
import services.UsuarioService;

public class Fachada {

    private UsuarioService usuarioService;

    private ProvaService provaService;

    private QuestaoService questaoService;

    private static Fachada instance;

    private Fachada() {
        this.usuarioService = new UsuarioService();
        this.provaService = new ProvaService();
        this.questaoService = new QuestaoService();
    }

    
    public Fachada(UsuarioService usuarioService, ProvaService provaService, QuestaoService questaoService) {
        this.usuarioService = usuarioService;
        this.provaService = provaService;
        this.questaoService = questaoService;
    }
    
    public static Fachada getInstance() {
        if (instance == null) {
            instance = new Fachada();
        }
        return instance;
    }
    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public ProvaService getProvaService() {
        return provaService;
    }

    public void setProvaService(ProvaService provaService) {
        this.provaService = provaService;
    }

    public QuestaoService getQuestaoService() {
        return questaoService;
    }

    public void setQuestaoService(QuestaoService questaoService) {
        this.questaoService = questaoService;
    }
}

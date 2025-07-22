package Fachada;

import services.EmailService;
import services.ProvaService;
import services.QuestaoService;
import services.UsuarioService;

public class Fachada {
    private static Fachada instance;
    private UsuarioService usuarioService;

    private ProvaService provaService;

    private QuestaoService questaoService;

    private EmailService servicoEmail;

    public Fachada() {
        this.usuarioService = new UsuarioService();
        this.provaService = new ProvaService();
        this.questaoService = new QuestaoService();
        this.servicoEmail = new EmailService();
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

    public EmailService getServicoEmail() {
        return servicoEmail;
    }

    public void setServicoEmail(EmailService servicoEmail) {
        this.servicoEmail = servicoEmail;
    }
}

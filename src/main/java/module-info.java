module com.example.projetoprovas {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens view to javafx.fxml;
    opens view.cadastro to javafx.fxml; 
    opens models to javafx.base;
    opens models.usuarios to javafx.base; //pra permitir o javafx ter acesso das classes models"
    exports DAO;
    exports Exceptions;
    exports models;
    exports repos;
    exports services;
    exports view;
    exports view.cadastro;

}
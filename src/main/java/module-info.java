module com.example.projetoprovas {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    //opens com.example.projetoprovas to javafx.fxml;
    opens view to javafx.fxml;
    exports DAO;
    exports Exceptions;
    exports models;
    exports repos;
    exports services;
    exports view;
}
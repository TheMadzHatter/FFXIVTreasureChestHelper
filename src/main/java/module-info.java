module org.example.ffxivtreasurechesthelper {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.fasterxml.jackson.databind;

    opens org.example.ffxivtreasurechesthelper to javafx.fxml;
    exports org.example.ffxivtreasurechesthelper;
}
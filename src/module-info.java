module TextEngine {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires org.junit.jupiter.api;
    opens TextEngine to javafx.fxml;
    exports TextEngine;
}
package TextEngine;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    public static void main(String[] args){
        // Calling the method that will get the only instance of TextEngine "Singleton" and calling the method that starting console interface.
        // Starting the application in console mode.
        // TextEngine.getInstance().start();

        // Starting the application in graphical user interface.
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        Parent parent = FXMLLoader.load(getClass().getResource("View.fxml"));
        Scene scene = new Scene(parent,1024,768);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("TextEngine");
        stage.show();
    }
}

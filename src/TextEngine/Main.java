package TextEngine;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    /**
     *
     */
    private static Stage stage;

    /**
     *
     * @return
     */
    public static Stage getStage() {
        return stage;
    }


    public static void main(String[] args){
        // Starting the application in graphical user interface.
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        Parent parent = FXMLLoader.load(getClass().getResource("View.fxml"));
        Scene scene = new Scene(parent,800,600);
        scene.getStylesheets().add("style.css");
        stage.getIcons().add(Controller.GUI_VARIABLES.APP_ICON);
        stage.setScene(scene);
        stage.setTitle("TextEngine");
        stage.show();
    }
}

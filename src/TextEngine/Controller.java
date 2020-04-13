package TextEngine;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Callable;


public class Controller implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //
        Label sort = new Label("Sörtera");
        sort.setOnMouseClicked((e)->sortContents());
        sort.setStyle("-fx-padding:4;");
        this.sort.setStyle("-fx-padding:0;-fx-margin:0;");
        this.sort.setGraphic(sort);
        //
        Label search = new Label("Söka");
        search.setOnMouseClicked((e)->searchInContents());
        search.setStyle("-fx-padding:4;");
        this.search.setStyle("-fx-padding:0;-fx-margin:0;");
        this.search.setGraphic(search);
    }

    /**
     *
     */
    TextEngine textEngine = TextEngine.getInstance();

    /**
     *
     */
    Stage stage = Main.getStage();

    /**
     *
     */
    @FXML
    MenuItem open;

    /**
     *
     */
    @FXML
    MenuItem save;

    /**
     *
     */
    @FXML
    MenuItem sort;

    /**
     *
     */
    @FXML
    MenuItem search;

    /**
     *
     */
    @FXML
    Text content;

    /**
     *
     */
    @FXML
    private void openFile(){
        //
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Öppna en textfil");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Texter","*.txt"));
        //
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")+"//desktop"));

        //
        try {
            String filePath = fileChooser.showOpenDialog(stage).toString();
            Service<Void> inBackground = doInBackground(()->{
                String msg = "";
                msg = textEngine.addFile(TextFile.open(filePath));
                return msg;
            });
            //
            inBackground.start();
            //
            inBackground.setOnSucceeded(workerStateEvent -> {
                showMessage(inBackground.getMessage());
                updateShownText(textEngine.getContents());
            });
            //
        }catch (Exception e){}
    }

    /**
     *
     */
    @FXML
    private void saveContents(){
        System.out.println("saving");
    }

    /**
     *
     */
    public void sortContents() {
        try {
            Service<Void> inBackground = doInBackground(()->{
                String msg = "";
                msg = textEngine.sortFilesContents();
                return msg;
            });
            //
            inBackground.start();
            //
            inBackground.setOnSucceeded(workerStateEvent -> {
                showMessage(inBackground.getMessage());
                updateShownText(textEngine.getContents());
            });
        }catch (Exception e){}
    }

    /**
     *
     */
    public void searchInContents() {
        System.out.println("searching");
    }

    /**
     *
     */
    public void updateShownText(String text) {
        content.setText(text);
    }
    @FXML
    private static void showMessage(String msg){
        Alert dialogBox = new Alert(Alert.AlertType.NONE,msg,ButtonType.OK);
        dialogBox.show();
    }

    /**
     *
     */
    private Service<Void> doInBackground(Callable toDo){
        Service<Void> backgroundService = new Service<Void>() {
            @Override
            protected Task<Void> createTask() {
                return new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {
                        updateMessage((String) toDo.call());
                        return null;
                    }
                };
            }
        };
        return backgroundService;
    }
}

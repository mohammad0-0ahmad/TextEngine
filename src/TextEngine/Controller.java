package TextEngine;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Callable;


public class Controller implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //
        Label sort = new Label("Sortera");
        sort.setOnMouseClicked((e) -> sortContents());
        sort.getStyleClass().add("MenuItem");
        //
        this.sort.setStyle("-fx-padding:0;-fx-margin:0;");
        this.sort.setGraphic(sort);
        //
        Label search = new Label("Söka");
        search.setOnMouseClicked((e) -> searchInContents());
        search.getStyleClass().add("MenuItem");
        //
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
    Menu file;
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
    Label content;

    /**
     *
     */
    @FXML
    private void openFile() {
        //
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("\t\tÖppna en textfil");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Texter", "*.txt"));
        //
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home") + "//desktop"));
        Alert progressIndicator = showProgressMessage("Öppnar...");
        //
        try {
            String filePath = fileChooser.showOpenDialog(stage).toString();
            //
            progressIndicator.show();
            Service<Void> inBackground = doInBackground(() -> {
                String msg = "";
                msg = textEngine.addFile(TextFile.open(filePath));
                return msg;
            });
            //
            inBackground.start();
            //
            inBackground.setOnSucceeded(workerStateEvent -> {
                (progressIndicator.getDialogPane().getScene().getWindow()).hide();
                showMessage(inBackground.getMessage());
                updateShownText(textEngine.getContents());
            });
            //
        } catch (Exception e) {
        }
    }

    /**
     *
     */
    @FXML
    private void saveContents() {
        if ((textEngine.getAmountOpenedFiles() == 0)) {
            showMessage(TextEngine.USER_MESSAGE.NO_TEXT_FILE_IS_OPENED);
        } else {
            //
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle(TextEngine.USER_MESSAGE.ASKING_TO_ENTER_FILE_NAME_THAT_WILL_BE_SAVED);
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Texter", "*.txt"));
            //
            fileChooser.setInitialDirectory(new File(System.getProperty("user.home") + "//desktop"));
            try {
                Alert progressIndicator = showProgressMessage("Sparar...");
                //
                String filePath = fileChooser.showSaveDialog(stage).toString();
                progressIndicator.show();
                Service<Void> inBackground = doInBackground(() -> {
                    String msg = "";
                    msg = TextFile.save(textEngine.getContentsToBeSaved(), filePath);
                    return msg;
                });
                //
                inBackground.start();
                //
                inBackground.setOnSucceeded(workerStateEvent -> {
                    (progressIndicator.getDialogPane().getScene().getWindow()).hide();
                    showMessage(inBackground.getMessage());
                });
                //
            } catch (Exception ignored) {
            }
        }
    }

    /**
     *
     */
    public void sortContents() {
        Alert progressIndicator = showProgressMessage("Sorterar...");
        progressIndicator.show();
        try {
            Service<Void> inBackground = doInBackground(() -> {
                String msg = "";
                msg = textEngine.sortFilesContents();
                return msg;
            });
            //
            inBackground.start();
            //
            inBackground.setOnSucceeded(workerStateEvent -> {
                (progressIndicator.getDialogPane().getScene().getWindow()).hide();
                showMessage(inBackground.getMessage());
                if ((textEngine.getAmountOpenedFiles() > 0)) {
                    updateShownText(textEngine.getContents());
                }
            });
        } catch (Exception ignored) {
        }
    }

    /**
     *
     */
    public void searchInContents() {
        if ((textEngine.getAmountOpenedFiles() == 0)) {
            showMessage(TextEngine.USER_MESSAGE.NO_TEXT_FILE_IS_OPENED);
        } else {
            boolean userDecision;
            //
            if (!textEngine.areAllFilesSorted()) {
                userDecision = getUserDecision(TextEngine.USER_MESSAGE.RECOMMENDATION_TO_SORT_FILES_BEFORE_SEARCHING + "\n" + TextEngine.USER_MESSAGE.WARNING_ABOUT_SIGNS);
            } else {
                //
                userDecision = true;
            }
            if (userDecision) {
                try {
                    String wordToLookFor = getUserInput("Leta efter ett ord", TextEngine.USER_MESSAGE.SENSITIVE_CASE_SEARCH_NOTE);
                    Alert progressIndicator = showProgressMessage("Letar efter \""+ wordToLookFor +"\" ...");
                    progressIndicator.show();
                    //
                    Service<Void> inBackground = doInBackground(() -> {
                        String msg = "";
                        msg = "Resultatet av sökning på \" " + wordToLookFor + " \" ordet:\n" + textEngine.searchInFiles(wordToLookFor);
                        return msg;
                    });
                    //
                    inBackground.start();
                    //
                    inBackground.setOnSucceeded(workerStateEvent -> {
                        (progressIndicator.getDialogPane().getScene().getWindow()).hide();
                        showMessage(inBackground.getMessage());
                    });
                } catch (Exception ignored) {
                }
            }
        }
    }

    /**
     *
     */
    public void updateShownText(String text) {
        content.setText(text);
    }

    @FXML
    private static void showMessage(String msg) {
        Alert dialogBox = new Alert(Alert.AlertType.NONE, "", ButtonType.OK);
        // set the text. "enabling text warping"
        dialogBox.getDialogPane().setContent(new Label(msg));
        // Setting app icon on message dialog.
        ((Stage) dialogBox.getDialogPane().getScene().getWindow()).getIcons().add(GUI_VARIABLES.APP_ICON);
        dialogBox.show();
    }

    @FXML
    private static Alert showProgressMessage(String msg) {
        Alert dialogBox = new Alert(Alert.AlertType.NONE, "");
        // set the text. "enabling text warping"
        dialogBox.setHeaderText(msg);
        dialogBox.initOwner(Main.getStage());
        //
        ProgressIndicator progressIndicator = new ProgressIndicator();
        progressIndicator.setPrefHeight(300);
        progressIndicator.setPrefWidth(300);
        dialogBox.getDialogPane().setContent(progressIndicator);
        // Setting app icon on message dialog.
        ((Stage) dialogBox.getDialogPane().getScene().getWindow()).getIcons().add(GUI_VARIABLES.APP_ICON);
        ((Stage) dialogBox.getDialogPane().getScene().getWindow()).initStyle(StageStyle.UNDECORATED);
        dialogBox.getDialogPane().getChildren().remove(2);
        return dialogBox;
    }


    /**/
    private static boolean getUserDecision(String msg) {
        Alert dialogBox = new Alert(Alert.AlertType.CONFIRMATION, "");
        //
        dialogBox.getDialogPane().setContent(new Label(msg));
        // Setting app icon on message dialog.
        ((Stage) dialogBox.getDialogPane().getScene().getWindow()).getIcons().add(GUI_VARIABLES.APP_ICON);
        dialogBox.setGraphic(null);
        dialogBox.setHeaderText(null);
        if (dialogBox.showAndWait().get() == ButtonType.OK) {
            return true;
        }
        return false;
    }

    /**
     *
     */
    private static String getUserInput(String title, String text) {
        TextInputDialog input = new TextInputDialog();
        input.setTitle(title);
        input.setHeaderText(text);
        input.getDialogPane().setGraphic(null);
        // Setting app icon on message dialog.
        ((Stage) input.getDialogPane().getScene().getWindow()).getIcons().add(GUI_VARIABLES.APP_ICON);
        return input.showAndWait().get();
    }

    /**
     *
     */
    private Service<Void> doInBackground(Callable toDo) {
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

    public abstract static class GUI_VARIABLES {
        public static Image APP_ICON = new Image(GUI_VARIABLES.class.getResource("/imgs/icon.png").toExternalForm());

    }
}

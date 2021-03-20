package lk.sliit.itpmProject.controller;

import com.jfoenix.controls.JFXCheckBox;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class AddTagController {

    @FXML
    private Button btnSave;

    @FXML
    private Button btnClear;

    @FXML
    private Spinner<?> noOfWorkTxt;

    @FXML
    private JFXCheckBox thursdayCB;

    @FXML
    private JFXCheckBox wednesdayCB;

    @FXML
    private JFXCheckBox tuesdayCB;

    @FXML
    private JFXCheckBox mondayCB;

    @FXML
    private JFXCheckBox sundayCB;

    @FXML
    private JFXCheckBox saturdayCB;

    @FXML
    private JFXCheckBox fridayCB;

    @FXML
    private AnchorPane root1;
    @FXML
    private Spinner<?> minutesTxt;

    @FXML
    private Spinner<?> hoursTxt;

    @FXML
    private ImageView iconHome;

    @FXML
    private ImageView iconLecture;

    @FXML
    private ImageView iconStudent;

    @FXML
    private ImageView iconLocation;

    @FXML
    void navigate(MouseEvent event) throws IOException {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

            Parent root = null;

            FXMLLoader fxmlLoader = null;
            switch (icon.getId()) {
                case "iconHome":
                    root = FXMLLoader.load(this.getClass().getResource("../view/MainForm.fxml"));
                    break;
                case "iconStudent":
                    root = FXMLLoader.load(this.getClass().getResource("../view/AddStudent.fxml"));
                    break;
                case "iconLecture":
                    root = FXMLLoader.load(this.getClass().getResource("../view/AddLecturer.fxml"));
                    break;
                case "iconLocation":
                    fxmlLoader = new FXMLLoader(this.getClass().getResource("../view/AddRBLocation.fxml"));
                    root = fxmlLoader.load();
                    break;
            }

            if (root != null) {
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.root1.getScene().getWindow();

                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();

                TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
                tt.setFromX(-subScene.getWidth());
                tt.setToX(0);
                tt.play();

            }
        }
    }

    @FXML
    void playMouseEnterAnimation(MouseEvent event) {

    }

    @FXML
    void playMouseExitAnimatio(MouseEvent event) {

    }


}

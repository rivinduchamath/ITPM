package lk.sliit.itpmProject.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.MouseEvent;

import java.awt.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddStudentController implements Initializable {



    public javafx.scene.control.Button btnSave1;
    @FXML
    private AnchorPane root;

    @FXML
    private Button btnGenerateId;

    @FXML
    private Spinner<Integer> subGroupNumberSpinner;

    @FXML
    private Spinner<Integer> groupNumberSpinner;


    @FXML
    private ImageView iconHome;

    @FXML
    private ImageView iconLecture;

    @FXML
    private ImageView iconTimeTable;

    @FXML
    private ImageView iconMap;

    @FXML
    private JFXTextField academicYearTxt;

    @FXML
    private JFXComboBox<String> programmeCombo;

    @FXML
    private JFXTextField subGroupIdTxt;

    @FXML
    private JFXTextField groupIdTxt;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SpinnerValueFactory<Integer> spinnerValueFactory1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 30, 0);
        SpinnerValueFactory<Integer> spinnerValueFactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 2, 0);
        this.subGroupNumberSpinner.setValueFactory(spinnerValueFactory2);
        this.groupNumberSpinner.setValueFactory(spinnerValueFactory1);
        subGroupNumberSpinner.setEditable(false);
        groupNumberSpinner.setEditable(false);
        programmeCombo.setValue("IT");

        ObservableList list1 = programmeCombo.getItems();
        list1.add("IT");
        list1.add("CSSE");
        list1.add("CSE");
        list1.add("IM");
        btnSave1.setDisable(true);

    }
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
                case "iconMap":
                    root = FXMLLoader.load(this.getClass().getResource("../view/AddRBLocation.fxml"));
                    break;
                case "iconLecture":
                    root = FXMLLoader.load(this.getClass().getResource("../view/AddLecturer.fxml"));
                    break;
                case "iconTimeTable":
                    fxmlLoader = new FXMLLoader(this.getClass().getResource("../view/AddWorkingDaysAndHours.fxml"));
                    root = fxmlLoader.load();
                    break;
            }

            if (root != null) {
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.root.getScene().getWindow();

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


    @FXML
    void btnGenerateId_OnAction(ActionEvent event) {

    }

    @FXML
    void btnSave_OnAction(ActionEvent event) {


    }

    public void btnClear(ActionEvent event) {
    }
}

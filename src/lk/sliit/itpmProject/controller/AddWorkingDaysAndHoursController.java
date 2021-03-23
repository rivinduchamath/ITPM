package lk.sliit.itpmProject.controller;

import com.jfoenix.controls.JFXCheckBox;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.sliit.itpmProject.business.BOFactory;
import lk.sliit.itpmProject.business.BOTypes;
import lk.sliit.itpmProject.business.custom.AddWorkingDaysAndHoursBO;
import lk.sliit.itpmProject.dto.AddWorkingDaysAndHoursDTO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddWorkingDaysAndHoursController implements Initializable {
    @FXML
    private Button btnSave;

    @FXML
    private Button btnClear;

    @FXML
    private Spinner<Integer> noOfWorkSpinner;

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
    private Spinner<Integer> hoursSpinner;

    @FXML
    private Spinner<Integer> minutesSpinner;

    @FXML
    private ImageView iconHome;

    @FXML
    private ImageView iconLecture;

    @FXML
    private ImageView iconStudent;

    @FXML
    private ImageView iconLocation;


    private final AddWorkingDaysAndHoursBO workingDaysAndHoursBO = BOFactory.getInstance().getBO(BOTypes.AddWorkingDays);

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        SpinnerValueFactory<Integer> spinnerValueFactory1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 7, 5);
        SpinnerValueFactory<Integer> spinnerValueFactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 24, 8);
        SpinnerValueFactory<Integer> spinnerValueFactory3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 60, 30);
        this.noOfWorkSpinner.setValueFactory(spinnerValueFactory1);
        this.hoursSpinner.setValueFactory(spinnerValueFactory2);
        this.minutesSpinner.setValueFactory(spinnerValueFactory3);
        noOfWorkSpinner.setEditable(false);
        hoursSpinner.setEditable(false);
        minutesSpinner.setEditable(false);
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


    public void btnClear_OnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                "Are you sure whether you want to delete this item?",
                ButtonType.YES, ButtonType.NO);
        alert.showAndWait();
    }


    public void btnSave_OnAction(ActionEvent event) throws Exception {
        int i = 0;
        boolean sunday =false, monday=false, tuesday=false, wednesday=false, thursday=false, friday=false, saturday=false;

        if (mondayCB.selectedProperty().getValue()){ monday = true;
        i++;}
        if (tuesdayCB.selectedProperty().getValue()) {tuesday = true;
        i++;}
        if (wednesdayCB.selectedProperty().getValue()) {wednesday = true;
        i++;}
        if (thursdayCB.selectedProperty().getValue()) {thursday = true;
        i++;}
        if (fridayCB.selectedProperty().getValue()) {friday = true;
        i++;}
        if (saturdayCB.selectedProperty().getValue()) {saturday = true;
        i++;}
        if (sundayCB.selectedProperty().getValue()){ sunday = true;
        i++;}

        int noOfWorkingDays = this.noOfWorkSpinner.getValue();
        int hours = this.hoursSpinner.getValue();
        int minutes = this.minutesSpinner.getValue();

        if (i == 0) new Alert(Alert.AlertType.ERROR, "Please Select at Least One Day").show();
        else if (i != noOfWorkingDays) new Alert(Alert.AlertType.ERROR, "Selected Days Count Is Not Match With No Of Days").show();


        if (btnSave.getText().equals("Save")) {
            AddWorkingDaysAndHoursDTO andHoursDTO = new AddWorkingDaysAndHoursDTO(
                    1,
                    noOfWorkingDays,
                    sunday,
                    monday,
                    tuesday,
                    wednesday,
                    thursday,
                    friday,
                    saturday,
                    hours,
                    minutes
            );
            try {
                workingDaysAndHoursBO.saveWorkingDaysAndHours(andHoursDTO);
            }catch (Exception e){
                new Alert(Alert.AlertType.ERROR, "User Already Added").show();
            }

        }
    }
}



















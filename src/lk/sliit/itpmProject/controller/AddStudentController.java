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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.MouseEvent;
import lk.sliit.itpmProject.business.BOFactory;
import lk.sliit.itpmProject.business.BOTypes;
import lk.sliit.itpmProject.business.custom.AddStudentBO;
import lk.sliit.itpmProject.dto.AddStudentDTO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class AddStudentController implements Initializable {

    @FXML
    public Button btnAddSave;

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

    @FXML
    private Spinner<Integer> semesterSpinner;


    private final AddStudentBO addStudentBO = BOFactory.getInstance().getBO(BOTypes.AddStudent);


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SpinnerValueFactory<Integer> spinnerValueFactory1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 30, 0);
        SpinnerValueFactory<Integer> spinnerValueFactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 2, 0);
        SpinnerValueFactory<Integer> spinnerValueFactory3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 2, 1);
        this.subGroupNumberSpinner.setValueFactory(spinnerValueFactory2);
        this.groupNumberSpinner.setValueFactory(spinnerValueFactory1);
        this.semesterSpinner.setValueFactory(spinnerValueFactory3);

        subGroupNumberSpinner.setEditable(false);
        groupNumberSpinner.setEditable(false);
        semesterSpinner.setEditable(false);

        programmeCombo.setValue("IT");
        ObservableList list1 = programmeCombo.getItems();
        list1.add("IT");
        list1.add("CSNE");
        list1.add("CSE");
        list1.add("IM");
        btnAddSave.setDisable(true);
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
        int year = Integer.parseInt(academicYearTxt.getText());
        int semester = semesterSpinner.getValue();
        String programme = programmeCombo.getValue();
        int groupNo = groupNumberSpinner.getValue();
        int subGroupNo = subGroupNumberSpinner.getValue();

        groupIdTxt.setText("Y" + year + "S" + semester + "." + groupNo + "(" + programme + ")");
        subGroupIdTxt.setText("Y" + year + "S" + semester + "." + groupNo + "." + subGroupNo + " (" + programme + ")");
        btnAddSave.setDisable(false);
    }

    @FXML
    void btnSave_onAction(ActionEvent event) {
     /*   int maxCode = 0;
        try {
            String lastItemCode = addStudentBO.getLastItemCode();
            if (lastItemCode == null) {
                maxCode = 0;
            } else {
                maxCode = Integer.parseInt(lastItemCode.replace("I", ""));
            }
            maxCode = maxCode + 1;
            String code = "";
            if (maxCode < 10) {
                code = "I00" + maxCode;
            } else if (maxCode < 100) {
                code = "I0" + maxCode;
            } else {
                code = "I" + maxCode;
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.INFORMATION,"Something went wrong").show();
        }
       */

        int year = Integer.parseInt(academicYearTxt.getText());
        int semester = semesterSpinner.getValue();
        String programme = programmeCombo.getValue();
        int groupNo = groupNumberSpinner.getValue();
        int subGroupNo = subGroupNumberSpinner.getValue();
        String groupId = groupIdTxt.getText();
        String subGroupId = subGroupIdTxt.getText();

        AddStudentDTO addStudentDTO = new AddStudentDTO(
                1,
                year,
                semester,
                programme,
                groupNo,
                subGroupNo,
                groupId,
                subGroupId
        );
        try {
            addStudentBO.saveStudent(addStudentDTO);
            new Alert(Alert.AlertType.INFORMATION, "User Added Successfully").show();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("2222222222222222222222222");
        }
    }

    @FXML
    public void btnClear(ActionEvent event) {

    }
}
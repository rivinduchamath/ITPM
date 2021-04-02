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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.sliit.itpmProject.dto.AddLecturerDTO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddLecturerController implements Initializable {

    @FXML
    private AnchorPane root1;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnSave;

    @FXML
    private ImageView iconStudent;

    @FXML
    private ImageView iconLocation;

    @FXML
    private ImageView iconTimeTable;

    @FXML
    private JFXComboBox<?> buildingCombo;

    @FXML
    private JFXComboBox<String> centerCombo;

    @FXML
    private JFXComboBox<?> departmentCombo;

    @FXML
    private JFXComboBox<?> facultyCombo;

    @FXML
    private JFXComboBox<String> levelCombo;

    @FXML
    private JFXTextField rankTxt;

    @FXML
    private JFXTextField empIdTxt;

    @FXML
    private JFXTextField nameTxt;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        centerCombo.setValue("Malabe");
        ObservableList list1 = centerCombo.getItems();
        list1.add("Malabe");
        list1.add("Metro");
        list1.add("Matara");
        list1.add("Kandy");
        list1.add("Kurunagala");
        list1.add("Jaffna");

        levelCombo.setValue("Professor");
        ObservableList list2 = levelCombo.getItems();
        list2.add("1 Professor");
        list2.add("2 Assistant Professor");
        list2.add("3 Senior Lecturer(HG)");
        list2.add("4 Senior Lecturer");
        list2.add("5 Lecturer");
        list2.add("6 Assistant Lecturer");

        ObservableList List3 = facultyCombo.getItems();
        List3.add("Computing Faculty");
        List3.add("Bussiness Faculty");
        List3.add("Engineering Faculty");
        List3.add("Architecture Faculty");
        List3.add("Faculty of Humanities and Science");

        ObservableList List4 = departmentCombo.getItems();
        List4.add("IT");
        List4.add("SE");
        List4.add("ISE");
        List4.add("DS");
        List4.add("CS");
        List4.add("IM");
        List4.add("CSNE");
        List4.add("Civil");
        List4.add("Electronic Engineering");
        List4.add("Mechanical Engineering");
        List4.add("QS");

        ObservableList List5 = buildingCombo.getItems();
        List5.add("Block A");
        List5.add("Block B");
        List5.add("Block E");
        List5.add("Block F");
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
                case "iconLocation":
                    root = FXMLLoader.load(this.getClass().getResource("../view/AddRBLocation.fxml"));
                    break;
                case "iconTimeTable":
                    fxmlLoader = new FXMLLoader(this.getClass().getResource("../view/AddWorkingDaysAndHours.fxml"));
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

    public void btnSave_OnAction(ActionEvent event) {
        String id = empIdTxt.getText();
        String lName = nameTxt.getText();
        String department = (String) departmentCombo.getValue();
        String faculty = (String) facultyCombo.getValue();
        String center = centerCombo.getValue();
        String buildingNo = (String) buildingCombo.getValue();
        String level = levelCombo.getValue();
        String rank = rankTxt.getText();

        AddLecturerDTO addLecturerDTO = new AddLecturerDTO(
                "1",
                lName,
                department,
                faculty,
                center,
                buildingNo,
                level,
                rank
        );

        System.out.println("fffffffffffffffffffffffffffffffffffff");
    //    String d = String.valueOf(lectureNameTxt.getText());

    }

    public void btnClear_OnAction(ActionEvent event) {
    }


}

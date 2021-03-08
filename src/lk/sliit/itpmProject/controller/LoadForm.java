package lk.sliit.itpmProject.controller;

import com.sun.glass.ui.Screen;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class LoadForm {
    @FXML
    private AnchorPane root;
    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label progressLbl;


    public void initialize(URL url, ResourceBundle rb) {


        FadeTransition fadeIn = new FadeTransition(Duration.millis(2000), root);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }
}

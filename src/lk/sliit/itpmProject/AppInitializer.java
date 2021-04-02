package lk.sliit.itpmProject;

import javafx.scene.control.Alert;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import lk.sliit.itpmProject.db.DBConnection;

import java.io.IOException;
import java.net.URL;
import java.util.logging.*;

public class AppInitializer extends Application {

    public static void main(String[] args) { launch(args);
    }

    @Override
    public void start(Stage primaryStage)  {

        try {
            Logger rootLogger = Logger.getLogger("");
            FileHandler fileHandler = new FileHandler("error.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            rootLogger.addHandler(fileHandler);

            DBConnection.getInstance().getConnection();

            URL resource = this.getClass().getResource("/lk/sliit/itpmProject/view/MainForm.fxml");
            Parent root = FXMLLoader.load(resource);
            Scene mainScene = new Scene(root);
            primaryStage.setScene(mainScene);
            primaryStage.setTitle("TimeTableManagement SLIIT - 2021");
            primaryStage.centerOnScreen();
            primaryStage.centerOnScreen();
            primaryStage.show();
        }catch (IOException e){
            new Alert(Alert.AlertType.INFORMATION,"Something went wrong").show();
            Logger.getLogger("lk.sliit.itpmProject").log(Level.SEVERE,null,e);
        }
    }
}

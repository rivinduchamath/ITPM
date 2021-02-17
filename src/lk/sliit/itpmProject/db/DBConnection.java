package lk.sliit.itpmProject.db;

import javafx.scene.control.Alert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DBConnection {

    public static String username;
    public static String db;
    public static  String password;
    public static String host;
    public static String port;


    private static lk.sliit.itpmProject.db.DBConnection dbConnection;
    private Connection connection;

    private DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Properties properties = new Properties();
            File file = new File("resources/application.properties");
            FileInputStream fis = new FileInputStream(file);
            properties.load(fis);
            fis.close();

            String ip=properties.getProperty("stdManagement.ip");
            host="localhost";
            String port=properties.getProperty("stdManagement.port");
            this.port = "3306";

            String user= DEPCrypt.decode(properties.getProperty("stdManagement.user"),"123");
            username="root";
            String password=DEPCrypt.decode(properties.getProperty("stdManagement.password"),"123");
            this.password="1234";
            String db=properties.getProperty("stdManagement.db");
            this.db="www";
            connection = DriverManager.getConnection("jdbc:mysql://"+ip+":"+port+"/"+db+"?createDatabaseIfNotExist=true&allowMultiQueries=true", "root", "1234");
            PreparedStatement pstm = connection.prepareStatement("SHOW TABLES");
            ResultSet resultSet = pstm.executeQuery();
            if (!resultSet.next()){
                File dbScriptFile = new File("student.sql");
                if(!dbScriptFile.exists()){
                    new Alert(Alert.AlertType.INFORMATION,"Cannot Find backup File");
                    throw  new RuntimeException("Unable to find file");
                }
                StringBuilder sb = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(dbScriptFile)));
                bufferedReader.lines().forEach(s -> sb.append(s));
                bufferedReader.close();
                System.out.println(sb.toString());
                String sql = "";
                pstm = connection.prepareStatement(sb.toString());
                pstm.execute();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static lk.sliit.itpmProject.db.DBConnection getInstance() {
        return (dbConnection == null) ? (dbConnection = new lk.sliit.itpmProject.db.DBConnection()) : dbConnection;
    }

    public Connection getConnection() {
        return connection;
    }

}

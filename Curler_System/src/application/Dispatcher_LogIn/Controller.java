package Dispatcher_LogIn;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.*;

public class Controller {
    @FXML
    private TextField TextField1;
    @FXML
    private TextField TextField2;
    @FXML
    private Button button;
    @FXML
    void initialize() {
        button.setOnAction(event -> {
            String id = TextField1.getText().trim();
            String pass = TextField2.getText().trim();
            if(!id.equals("") && !pass.equals(""))
            {
                loginUser(id,pass);
            }
            else{
                System.out.println("ID and password is Empty");
            }
        });
    }
public void loginUser(String id, String pass){
       Database db = new Database();
       Dispatcher dispatcher = new Dispatcher();
       dispatcher.setID_worker(id);
       dispatcher.setPassword(pass);
       ResultSet rs = db.getUser(dispatcher);
       int counter = 0;
       try {
           while (rs.next()) {
               counter++;
           }
       }
       catch (SQLException e){
           e.printStackTrace();
       }
       if(counter>=1){
           System.out.println("Well Done!");
       }
       else{
           System.out.println("Bad((!");
       }
}
}

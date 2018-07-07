package application.dispatcher_office;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/* Class Controller for OfficeView.fxml, 
 * write logic for this ^ app.    
 *  */
public class OfficeController {
	@FXML
    private Button changeOffice_button;

    @FXML
    private Button callsRegistration_button;

    @FXML
    private Button curlers_button;
    
    @FXML
    void initialize() {
    	callsRegistration_button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
					callsRegistration_button.getScene().getWindow().hide();
					
					FXMLLoader loader = new FXMLLoader();
					loader.setLocation(getClass().getResource("/application.dispatcher_office/OfficeView.fxml"));
					
					try {
						loader.load();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					Parent parent = loader.getRoot();
					Stage stage = new Stage();
					stage.setScene(new Scene(parent));
					stage.showAndWait();
			}
    	});
    }
    
}

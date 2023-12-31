package scenechanginginwith4types;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ManagerDashboardController implements Initializable {
    
    Manager manager;
    @FXML
    private Label name;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        name.setText(manager.name);
    }
    
    public void initdata(String uname, Manager m) {
        this.manager = m;
        
    }
    
    @FXML
    private void logout(ActionEvent event) throws IOException {
        Parent mainSceneParent = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene1 = new Scene(mainSceneParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }
    
}

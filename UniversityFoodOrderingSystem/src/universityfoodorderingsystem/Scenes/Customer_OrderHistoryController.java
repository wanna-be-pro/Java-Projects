package universityfoodorderingsystem.Scenes;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import universityfoodorderingsystem.ModelClasses.Order;

public class Customer_OrderHistoryController implements Initializable {

    @FXML
    private TableView<Order> table;
    @FXML
    private TableColumn<Order, Integer> orderIdCol;
    @FXML
    private TableColumn<Order, Integer> productIdCol;
    @FXML
    private TableColumn<Order, Integer> quantityCol;
    @FXML
    private TableColumn<Order, String> ptouctNameCol;
    @FXML
    private TableColumn<Order, String> customerIdCol;
    @FXML
    private TableColumn<Order, Float> totalPriceCol;
    @FXML
    private TableColumn<Order, String> DeliveryType;

    String customerId;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        orderIdCol.setCellValueFactory(new PropertyValueFactory<>("orderid"));
        productIdCol.setCellValueFactory(new PropertyValueFactory<>("productId"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        ptouctNameCol.setCellValueFactory(new PropertyValueFactory<>("productName"));
        DeliveryType.setCellValueFactory(new PropertyValueFactory<>("deliveryType"));
        customerIdCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        totalPriceCol.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
    }

    public void initData(String customerId) {
        this.customerId = customerId;
        ObservableList<Order> Orders = FXCollections.observableArrayList();

        File f = null;
        Scanner sc;
        String str;
        String[] tokens;

        try {
            f = new File("Orders.txt");
            sc = new Scanner(f);
            if (f.exists()) {
                while (sc.hasNextLine()) {
                    str = sc.nextLine();
                    tokens = str.split(",");

                    if (tokens[3].split("=")[1].equals(this.customerId) && tokens[4].split("=")[1].equals("Complete")) {

                        Order o = new Order(
                                Integer.parseInt(tokens[6].split("=")[1]),
                                Integer.parseInt(tokens[0].split("=")[1]),
                                Integer.parseInt(tokens[1].split("=")[1]),
                                tokens[3].split("=")[1],
                                tokens[4].split("=")[1],
                                tokens[5].split("=")[1]
                        );
                        Orders.add(o);
                    }

                }
            } else {
            }
        } catch (IOException ex) {
            Logger.getLogger(Customer_ShowAllProductsController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
        table.setItems(Orders);
    }

}

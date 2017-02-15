/**
 * @author William Barden
 * Jan 27, 2017
 */
package gui;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import core.Hardware;
import core.Network;
import java.util.LinkedList;
import java.util.List;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class PromptDog extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    private Button hardwareButton;
    private Button networkButton;
    private BorderPane borderPane;
    private HBox hbox;
    private Scene mainScene;
    private VBox hardwareVbox;
    private VBox networkVbox;
    private List<Label[]> hardwareList;
    private List<Label[]> networkList;
    
    private Hardware hardware;
    private Network network;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        hardware = new Hardware();
        network = new Network();
        
        createGui();
        mainScene = new Scene(borderPane);
        mainScene.getStylesheets().add(this.getClass().getResource("default.css"
                    ).toExternalForm());
        
        // settup stage
        primaryStage.setTitle("PromptDog");
        primaryStage.setScene(mainScene);
        primaryStage.show();
        
        // set minimum sizes of gui members
        primaryStage.setMinWidth(primaryStage.getWidth());
        primaryStage.setMinHeight(primaryStage.getHeight());
        createNetworkDisplay();
    }
    
    private void createGui() {
        // create buttons
        // initialize buttons
        hardwareButton = new Button("Hardware");
        networkButton = new Button("Network");
        // set padding of buttons
        Insets padding = new Insets(5, 5, 5, 5);
        hardwareButton.setPadding(padding);
        networkButton.setPadding(padding);
        hardwareButton.getStyleClass().add("custom-button");
        networkButton.getStyleClass().add("custom-button");
        // set minimum widths
        hardwareButton.setMinWidth(210);
        networkButton.setMinWidth(210);
        
        // add event handlers to buttons
        hardwareButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
            borderPane.setCenter(hardwareVbox);
        });
        networkButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
            borderPane.setCenter(networkVbox);
        });
        
        // create hbox and add buttons
        hbox = new HBox(10);
        hbox.getChildren().addAll(hardwareButton, networkButton);
        hbox.setAlignment(Pos.CENTER);
        hbox.getStyleClass().add("hbox");
        
        // initialize table
        createHardwareDisplay();
        createNetworkDisplay();
        
        // create border pane and add hbox to top
        borderPane = new BorderPane();
        borderPane.setTop(hbox);
        borderPane.setCenter(hardwareVbox);
        borderPane.getStyleClass().add("border-pane");
    }
    
    private void createHardwareDisplay() {
        hardwareVbox = new VBox(5);
        hardwareList = new LinkedList<>();
        
        // Host Name
        Label[] labels = new Label[2];
        labels[0] = new Label("Host Name");
        labels[1] = new Label(hardware.getHostName());
        hardwareList.add(labels);
        
        // OS Name
        labels = new Label[2];
        labels[0] = new Label("OS Name");
        labels[1] = new Label(hardware.getOsName());
        hardwareList.add(labels);
        
        // OS Version
        labels = new Label[2];
        labels[0] = new Label("OS Version");
        labels[1] = new Label(hardware.getOsVersion());
        hardwareList.add(labels);
        
        // System Type
        labels = new Label[2];
        labels[0] = new Label("System Type");
        labels[1] = new Label(hardware.getSysType());
        hardwareList.add(labels);
        
        // BIOS Version
        labels = new Label[2];
        labels[0] = new Label("BIOS Version");
        labels[1] = new Label(hardware.getBiosVersion());
        hardwareList.add(labels);
        
        // Total Physical Memory
        labels = new Label[2];
        labels[0] = new Label("Total Physical Memory");
        labels[1] = new Label(hardware.getTotalPhysicalMem());
        hardwareList.add(labels);
        
        // Total Available Memory
        labels = new Label[2];
        labels[0] = new Label("Total Available Memory");
        labels[1] = new Label(hardware.getTotalAvailableMem());
        hardwareList.add(labels);
        
        // format labels and add to respective containers
        for (int i = 0; i < hardwareList.size(); i++) {
            HBox row = new HBox(5);
            Label left = hardwareList.get(i)[0];
            Label right = hardwareList.get(i)[1];
            left.setMinWidth(170);
            row.getStyleClass().add("row-hbox");
            left.getStyleClass().add("label");
            right.getStyleClass().add("label");
            row.getChildren().add(left);
            row.getChildren().add(right);
            hardwareVbox.getChildren().add(row);
        }
    }
    
    private void createNetworkDisplay() {
        networkVbox = new VBox(5);
        networkList = new LinkedList<>();
        
        // IP
        Label[] labels = new Label[2];
        labels[0] = new Label("IP Address");
        labels[1] = new Label(network.getIP());
        networkList.add(labels);
        
        // MAC 
        labels = new Label[2];
        labels[0] = new Label("MAC Address");
        labels[1] = new Label(network.getMAC());
        networkList.add(labels);
        
        // DNS Suffix
        labels = new Label[2];
        labels[0] = new Label("DNS Suffix");
        labels[1] = new Label(network.getDnsSuffix());
        networkList.add(labels);
        
        // DNS IP
        labels = new Label[2];
        labels[0] = new Label("DNS IP");
        labels[1] = new Label(network.getDnsIP());
        networkList.add(labels);
        
        // Subnet Mask
        labels = new Label[2];
        labels[0] = new Label("Subnet Mask");
        labels[1] = new Label(network.getSubnetMask());
        networkList.add(labels);
        
        // Default Gateway 
        labels = new Label[2];
        labels[0] = new Label("Default Gateway");
        labels[1] = new Label(network.getDefGateway());
        networkList.add(labels);
        
        // Ping to google.com
        labels = new Label[2];
        labels[0] = new Label("Ping google.com");
        labels[1] = new Label(network.pingGoogleTime());
        networkList.add(labels);
        
        for (int i = 0; i < networkList.size(); i++) {
            HBox row = new HBox(5);
            Label left = networkList.get(i)[0];
            Label right = networkList.get(i)[1];
            left.setMinWidth(170);
            row.getStyleClass().add("row-hbox");
            left.getStyleClass().add("label");
            right.getStyleClass().add("label");
            row.getChildren().add(left);
            row.getChildren().add(right);
            networkVbox.getChildren().add(row);
        }
    }
}
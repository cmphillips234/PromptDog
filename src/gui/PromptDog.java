/**
 * @author William Barden
 * Jan 27, 2017
 */
package gui;

import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class PromptDog extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    private Button hardwareButton;
    private Button networkButton;
    private BorderPane borderPane;
    private HBox hbox;
    private Scene mainScene;
    private TableView table;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        createGui();
        mainScene = new Scene(borderPane, 400, 400);
        mainScene.getStylesheets().add(this.getClass().getResource("default.css"
                    ).toExternalForm());
        
        primaryStage.setTitle("PromptDog");
        primaryStage.setScene(mainScene);
        primaryStage.setMinWidth(primaryStage.getWidth());
        primaryStage.setMinHeight(primaryStage.getHeight());
        
        setMinBtnSizes();
        primaryStage.show();
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
        
        // create hbox and add buttons
        hbox = new HBox(10);
        hbox.getChildren().addAll(hardwareButton, networkButton);
        hbox.setAlignment(Pos.CENTER);
        hbox.getStyleClass().add("hbox");
        
        // initialize table
        createTable();
        
        // create border pane and add hbox to top
        borderPane = new BorderPane();
        borderPane.setTop(hbox);
        borderPane.setCenter(table);
        borderPane.getStyleClass().add("border-pane");
    }
    
    private void createTable() {
        table = new TableView();
    }
    
    private void setMinBtnSizes() {
        Bounds bounds = hardwareButton.getBoundsInParent();
        hardwareButton.setMinHeight(bounds.getHeight());
        hardwareButton.setMinWidth(bounds.getWidth());
        networkButton.setMinHeight(bounds.getHeight());
        networkButton.setMinWidth(bounds.getWidth());
    }
}
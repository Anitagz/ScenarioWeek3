/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package circuitsim2;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Demonstrates a drag-and-drop feature.
 */
public class HelloDragAndDrop extends Application {

    @Override public void start(Stage stage) {
        stage.setTitle("Hello Drag And Drop");

        Group root = new Group();
        
        GridPane grid = new GridPane();
        Scene scene = new Scene(grid, 800, 500);
        
        
        //grid.setAlignment(Pos.CENTER);
        //grid.setHgap(10);
        //grid.setVgap(10);
        //grid.setGridLinesVisible(true);
        
        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        Menu menuEdit = new Menu("Edit");
        Menu menuHelp = new Menu("Help");
        menuBar.getMenus().addAll(menuFile, menuEdit, menuHelp);
        grid.add(menuBar, 0, 0, 2, 1);
        
        int symbolSize = 70;
        
        Image img1 = new Image(getClass().getResourceAsStream("ammeter.png"));
        ImageView ammeterSym = new ImageView(img1);
        ammeterSym.setFitHeight(symbolSize);
        ammeterSym.setFitWidth(symbolSize);
        
        Image img2 = new Image(getClass().getResourceAsStream("voltmeter.png"));
        ImageView voltmeterSym = new ImageView(img2);
        voltmeterSym.setFitHeight(symbolSize);
        voltmeterSym.setFitWidth(symbolSize);
        
        Image img3 = new Image(getClass().getResourceAsStream("battery.png"));
        ImageView batterySym = new ImageView(img3);
        batterySym.setFitHeight(symbolSize);
        batterySym.setFitWidth(symbolSize);
        
        Image img4 = new Image(getClass().getResourceAsStream("lamp.png"));
        ImageView lampSym = new ImageView(img4);
        lampSym.setFitHeight(symbolSize);
        lampSym.setFitWidth(symbolSize);
        
        Image img5 = new Image(getClass().getResourceAsStream("resistor.png"));
        ImageView resistorSym = new ImageView(img5);
        resistorSym.setFitHeight(symbolSize);
        resistorSym.setFitWidth(symbolSize);
        
        Image img6 = new Image(getClass().getResourceAsStream("openswitch.png"));
        ImageView openswitchSym = new ImageView(img6);
        openswitchSym.setFitHeight(symbolSize);
        openswitchSym.setFitWidth(symbolSize);
        
        setupGestureSource(batterySym,"battery");
        setupGestureSource(lampSym, "lamp");
        setupGestureSource(resistorSym, "resistor");
        setupGestureSource(ammeterSym, "ammeter");
        setupGestureSource(voltmeterSym, "voltmeter");
        
        
        GridPane componentsGrid = new GridPane();
        componentsGrid.add(batterySym,0,0);
        componentsGrid.add(lampSym,1,0);
        componentsGrid.add(resistorSym,0,1);
        componentsGrid.add(openswitchSym,1,1);
        componentsGrid.add(ammeterSym, 0, 2);
        componentsGrid.add(voltmeterSym,1,2);
        componentsGrid.setHgap(5);
        componentsGrid.setVgap(5);
        grid.add(componentsGrid,0,1);
        
        
        GridPane canvasGrid = new GridPane();
        grid.add(canvasGrid,1,1);
        canvasGrid.setGridLinesVisible(true);
        for(int j = 0; j < 10; j++){
            
        
            for(int i=0; i < 15; i++){
                //canvasGrid.add(gridBG,i,0);

                Pane stpane = new StackPane();
                stpane.setMinSize(40, 40);
                stpane.setMaxSize(40,40);
                stpane.setPrefSize(40, 40);
                setupGestureTarget(stpane);
                canvasGrid.add(stpane,i,j);
            }
        }
        

        
        stage.setScene(scene);
        stage.show();
    }

    void setupGestureSource(ImageView source, String component){
        
        source.setOnDragDetected(new EventHandler <MouseEvent>() {
            public void handle(MouseEvent event) {
                /* drag was detected, start drag-and-drop gesture*/
                System.out.println("onDragDetected");
                
                /* allow any transfer mode */
                Dragboard db = source.startDragAndDrop(TransferMode.ANY);
                
                /* put a string on dragboard */
                ClipboardContent content = new ClipboardContent();
                content.putString(component);
                db.setContent(content);
                
                event.consume();
            }
        });
        
        source.setOnDragDone(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                /* the drag-and-drop gesture ended */
                System.out.println("onDragDone");
                /* if the data was successfully moved, clear it */
                if (event.getTransferMode() == TransferMode.MOVE) {
                 //   source.setText("");
                }
                
                event.consume();
            }
        });
    }
    
    void setupGestureTarget(Pane target){
         target.setOnDragOver(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                /* data is dragged over the target */
                System.out.println("onDragOver");
                
                /* accept it only if it is  not dragged from the same node 
                 * and if it has a string data */
                if (event.getGestureSource() != target &&
                        event.getDragboard().hasString()) {
                    /* allow for both copying and moving, whatever user chooses */
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                
                
                    target.setStyle("-fx-background-color:blue;");
                
                event.consume();
            }
        });

        target.setOnDragEntered(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                /* the drag-and-drop gesture entered the target */
                System.out.println("onDragEntered");
                /* show to the user that it is an actual gesture target */
                if (event.getGestureSource() != target &&
                        event.getDragboard().hasString()) {
                    //target.setFill(Color.GREEN);
                    
                }
                
                
                    target.setStyle("-fx-background-color:blue;");
                
                event.consume();
            }
        });

        target.setOnDragExited(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                /* mouse moved away, remove the graphical cues */
                //target.setFill(Color.BLACK);
                
                target.setStyle("-fx-background-color:transparent;");
                event.consume();
            }
        });
        
        target.setOnDragDropped(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                /* data dropped */
                System.out.println("onDragDropped");
                /* if there is a string data on dragboard, read it and use it */
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasString()) {
                    //target.setText(db.getString());
                    success = true;
                }
                
                String component = db.getString();
                
                
                int gridSize = 40;
                ImageView iv1 = new ImageView();
                iv1.setFitHeight(gridSize);
                iv1.setFitWidth(gridSize);
                
               
                        
                if(component.compareTo("battery")==0){
                    Image img1 = new Image(getClass().getResourceAsStream("battery.png"));
                        iv1.setImage(img1);
                }
                else if(component.compareTo("ammeter")==0){
                    Image img1 = new Image(getClass().getResourceAsStream("ammeter.png"));
                        iv1.setImage(img1);
                }
                else if(component.compareTo("voltmeter")==0){
                    Image img1 = new Image(getClass().getResourceAsStream("voltmeter.png"));
                        iv1.setImage(img1);
                }
                else if(component.compareTo("resistor")==0){
                    Image img1 = new Image(getClass().getResourceAsStream("resistor.png"));
                        iv1.setImage(img1);
                }
                else if(component.compareTo("lamp")==0){
                    Image img1 = new Image(getClass().getResourceAsStream("lamp.png"));
                        iv1.setImage(img1);
                }
                else if(component.compareTo("openswitch")==0){
                    Image img1 = new Image(getClass().getResourceAsStream("openswitch.png"));
                        iv1.setImage(img1);
                }
                else if(component.compareTo("closedswitch")==0){
                    Image img1 = new Image(getClass().getResourceAsStream("closedswitch.png"));
                        iv1.setImage(img1);
                }
                
                
                
                target.getChildren().add(iv1);
                
                /* let the source know whether the string was successfully 
                 * transferred and used */
                event.setDropCompleted(success);
                
                event.consume();
            }
        });
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}
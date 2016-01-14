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
        Scene scene = new Scene(grid, 1000, 500);
        
        
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
        
        int symbolSize = 50;
        
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
        
        Image img7 = new Image(getClass().getResourceAsStream("wireF.png"));
        ImageView wireFSym = new ImageView(img7);
        wireFSym.setFitHeight(symbolSize);
        wireFSym.setFitWidth(symbolSize);
        
        Image img8 = new Image(getClass().getResourceAsStream("wireHorizontal.png"));
        ImageView wireHorizontalSym = new ImageView(img8);
        wireHorizontalSym.setFitHeight(symbolSize);
        wireHorizontalSym.setFitWidth(symbolSize);
        
        Image img9 = new Image(getClass().getResourceAsStream("wireJ.png"));
        ImageView wireJSym = new ImageView(img9);
        wireJSym.setFitHeight(symbolSize);
        wireJSym.setFitWidth(symbolSize);
        
        Image img10 = new Image(getClass().getResourceAsStream("wireL.png"));
        ImageView wireLSym = new ImageView(img10);
        wireLSym.setFitHeight(symbolSize);
        wireLSym.setFitWidth(symbolSize);
        
        Image img11 = new Image(getClass().getResourceAsStream("wireLeftDown.png"));
        ImageView wireLeftDownSym = new ImageView(img11);
        wireLeftDownSym.setFitHeight(symbolSize);
        wireLeftDownSym.setFitWidth(symbolSize);
        
        Image img13 = new Image(getClass().getResourceAsStream("wireTdown.png"));
        ImageView wireTdownSym = new ImageView(img13);
        wireTdownSym.setFitHeight(symbolSize);
        wireTdownSym.setFitWidth(symbolSize);
        
        Image img14 = new Image(getClass().getResourceAsStream("wireTright.png"));
        ImageView wireTrightSym = new ImageView(img14);
        wireTrightSym.setFitHeight(symbolSize);
        wireTrightSym.setFitWidth(symbolSize);
        
        Image img15 = new Image(getClass().getResourceAsStream("wireTup.png"));
        ImageView wireTupSym = new ImageView(img15);
        wireTupSym.setFitHeight(symbolSize);
        wireTupSym.setFitWidth(symbolSize);
        
        Image img16 = new Image(getClass().getResourceAsStream("wireVertical.png"));
        ImageView wireVerticalSym = new ImageView(img16);
        wireVerticalSym.setFitHeight(symbolSize);
        wireVerticalSym.setFitWidth(symbolSize);
        
        Image img17 = new Image(getClass().getResourceAsStream("wireTleft.png"));
        ImageView wireTleftSym = new ImageView(img17);
        wireTleftSym.setFitHeight(symbolSize);
        wireTleftSym.setFitWidth(symbolSize);
        
        setupGestureSource(batterySym,"battery");
        setupGestureSource(lampSym, "lamp");
        setupGestureSource(resistorSym, "resistor");
        setupGestureSource(ammeterSym, "ammeter");
        setupGestureSource(voltmeterSym, "voltmeter");
        setupGestureSource(openswitchSym, "openswitch");
        setupGestureSource(wireFSym, "wireF");
        setupGestureSource(wireHorizontalSym, "wireHorizontal");
        setupGestureSource(wireJSym, "wireJ");
        setupGestureSource(wireLSym, "wireL");
        setupGestureSource(wireLeftDownSym, "wireLeftDown");
        setupGestureSource(wireTdownSym, "wireTdown");
        setupGestureSource(wireTleftSym, "wireTleft");
        setupGestureSource(wireTrightSym, "wireTright");
        setupGestureSource(wireTupSym, "wireTup");
        setupGestureSource(wireVerticalSym, "wireVertical");
               
        
        
        GridPane componentsGrid = new GridPane();
        componentsGrid.add(batterySym,0,0);
        componentsGrid.add(lampSym,1,0);
        componentsGrid.add(resistorSym,0,1);
        componentsGrid.add(openswitchSym,1,1);
        componentsGrid.add(ammeterSym, 0, 2);
        componentsGrid.add(voltmeterSym,1,2);
        componentsGrid.add(wireVerticalSym,0,3);
        componentsGrid.add(wireHorizontalSym,1,3);
        componentsGrid.add(wireJSym,0,4);
        componentsGrid.add(wireLSym,1,4);
        componentsGrid.add(wireLeftDownSym,0,5);
        componentsGrid.add(wireFSym,1,5);
        componentsGrid.add(wireTdownSym,0,6);
        componentsGrid.add(wireTleftSym,1,6);
        componentsGrid.add(wireTrightSym,0,7);
        componentsGrid.add(wireTupSym,1,7);
        componentsGrid.setHgap(5);
        componentsGrid.setVgap(5);
        grid.add(componentsGrid,0,1);
        
        
        GridPane canvasGrid = new GridPane();
        grid.add(canvasGrid,1,1);
        canvasGrid.setGridLinesVisible(true);
        int gridSize = 50;
        for(int j = 0; j < 9; j++){
            
        
            for(int i=0; i < 13; i++){
                //canvasGrid.add(gridBG,i,0);

                Pane stpane = new StackPane();
                stpane.setMinSize(gridSize, gridSize);
                stpane.setMaxSize(gridSize, gridSize);
                stpane.setPrefSize(gridSize, gridSize);
                //stpane.setStyle("-fx-background-color:white");
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
    
    void setupMouseClickSource(ImageView source){
        source.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("mouse click detected! "+event.getSource());
                if (event.getButton() == MouseButton.SECONDARY) {
                    System.out.println("Right button clicked");
                }
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
                
                
                int gridSize = 50;
                ImageView iv1 = new ImageView();
                iv1.setFitHeight(gridSize);
                iv1.setFitWidth(gridSize);
                
               
                        
                if(component.compareTo("battery")==0){
                    Image img1 = new Image(getClass().getResourceAsStream("battery.png"));
                        iv1.setImage(img1);
                        setupGestureSource(iv1, component);
                        setupMouseClickSource(iv1);
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
                else if(component.compareTo("wireF")==0){
                    Image img1 = new Image(getClass().getResourceAsStream("wireF.png"));
                        iv1.setImage(img1);
                }
                else if(component.compareTo("wireHorizontal")==0){
                    Image img1 = new Image(getClass().getResourceAsStream("wireHorizontal.png"));
                        iv1.setImage(img1);
                }
                else if(component.compareTo("wireJ")==0){
                    Image img1 = new Image(getClass().getResourceAsStream("wireJ.png"));
                        iv1.setImage(img1);
                }
                else if(component.compareTo("wireL")==0){
                    Image img1 = new Image(getClass().getResourceAsStream("wireL.png"));
                        iv1.setImage(img1);
                }
                else if(component.compareTo("wireLeftDown")==0){
                    Image img1 = new Image(getClass().getResourceAsStream("wireLeftDown.png"));
                        iv1.setImage(img1);
                }
                else if(component.compareTo("wireTdown")==0){
                    Image img1 = new Image(getClass().getResourceAsStream("wireTdown.png"));
                        iv1.setImage(img1);
                }
                else if(component.compareTo("wireTleft")==0){
                    Image img1 = new Image(getClass().getResourceAsStream("wireTleft.png"));
                        iv1.setImage(img1);
                }
                else if(component.compareTo("wireTup")==0){
                    Image img1 = new Image(getClass().getResourceAsStream("wireTup.png"));
                        iv1.setImage(img1);
                }
                else if(component.compareTo("wireVertical")==0){
                    Image img1 = new Image(getClass().getResourceAsStream("wireVertical.png"));
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
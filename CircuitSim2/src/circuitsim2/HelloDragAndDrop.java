/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package circuitsim2;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
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
        
        Image img1 = new Image(getClass().getResourceAsStream("ammeter.png"));
        ImageView ammeterSym = new ImageView(img1);
        ammeterSym.setFitHeight(40);
        ammeterSym.setFitWidth(40);
        
        Image img2 = new Image(getClass().getResourceAsStream("voltmeter.png"));
        ImageView voltmeterSym = new ImageView(img2);
        voltmeterSym.setFitHeight(40);
        voltmeterSym.setFitWidth(40);
        
        Image img3 = new Image(getClass().getResourceAsStream("battery.png"));
        ImageView batterySym = new ImageView(img3);
        batterySym.setFitHeight(40);
        batterySym.setFitWidth(40);
        
        Image img4 = new Image(getClass().getResourceAsStream("lamp.png"));
        ImageView lampSym = new ImageView(img4);
        lampSym.setFitHeight(40);
        lampSym.setFitWidth(40);
        
        Image img5 = new Image(getClass().getResourceAsStream("resistor.png"));
        ImageView resistorSym = new ImageView(img5);
        resistorSym.setFitHeight(40);
        resistorSym.setFitWidth(40);
        
        Image img6 = new Image(getClass().getResourceAsStream("openswitch.png"));
        ImageView openswitchSym = new ImageView(img6);
        openswitchSym.setFitHeight(40);
        openswitchSym.setFitWidth(40);
        
        GridPane componentsGrid = new GridPane();
        componentsGrid.add(batterySym,0,0);
        componentsGrid.add(lampSym,0,1);
        //componentsGrid.add(resistorSym,1,0);
        //componentsGrid.add(openswitchSym,1,1);
        //componentsGrid.add(ammeterSym, 2, 0);
        //componentsGrid.add(voltmeterSym,2,1);
        
        
        
        
       // VBox vbox = new VBox(0);
        //vbox.setAlignment(Pos.CENTER);
        
       /* vbox.getChildren().addAll(
                ammeterSym,
                voltmeterSym
                
        );*/
        
        //grid.add(componentsGrid,0,1);
        
        
        
        GridPane canvasGrid = new GridPane();
        grid.add(canvasGrid,1,1);
        canvasGrid.setGridLinesVisible(true);
        for(int j = 0; j < 10; j++){
            
        
            for(int i=0; i < 15; i++){
                //canvasGrid.add(gridBG,i,0);

                StackPane stpane = new StackPane();
                stpane.setMinSize(40, 40);
                stpane.setMaxSize(40,40);
                stpane.setPrefSize(40, 40);
                canvasGrid.add(stpane,i,j);
            }
        }
        

        final Text source = new Text(50, 100, "DRAG ME");
        source.setScaleX(2.0);
        source.setScaleY(2.0);

        final Text target = new Text(250, 100, "DROP HERE");
        target.setScaleX(2.0);
        target.setScaleY(2.0);

        source.setOnDragDetected(new EventHandler <MouseEvent>() {
            public void handle(MouseEvent event) {
                /* drag was detected, start drag-and-drop gesture*/
                System.out.println("onDragDetected");
                
                /* allow any transfer mode */
                Dragboard db = source.startDragAndDrop(TransferMode.ANY);
                
                /* put a string on dragboard */
                ClipboardContent content = new ClipboardContent();
                content.putString(source.getText());
                db.setContent(content);
                
                event.consume();
            }
        });

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
                    target.setFill(Color.GREEN);
                }
                
                event.consume();
            }
        });

        target.setOnDragExited(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                /* mouse moved away, remove the graphical cues */
                target.setFill(Color.BLACK);
                
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
                    target.setText(db.getString());
                    success = true;
                }
                /* let the source know whether the string was successfully 
                 * transferred and used */
                event.setDropCompleted(success);
                
                event.consume();
            }
        });

        source.setOnDragDone(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                /* the drag-and-drop gesture ended */
                System.out.println("onDragDone");
                /* if the data was successfully moved, clear it */
                if (event.getTransferMode() == TransferMode.MOVE) {
                    source.setText("");
                }
                
                event.consume();
            }
        });

        //grid.getChildren().add(source);
        //grid.getChildren().add(target);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
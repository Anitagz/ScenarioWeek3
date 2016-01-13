/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circuitsimulator;

import java.awt.event.ActionEvent;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.StackPane;


/**
 *
 * @author Anita
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    private StackPane stpane;
    private ImageView fid;

     @FXML
    private void handleButtonAction(ActionEvent event) {
     // Button was clicked, do something...
    }
    
    @Override
    public void initialize(java.net.URL location, ResourceBundle resources) {
        
        stpane.setOnDragDetected(new EventHandler() {
            public void handle(MouseEvent t) {
                
                Image image = new Image(getClass().getResourceAsStream("/com/lynden/planning/ui/container2.png"));
                ImageView dragImageView = new ImageView(image);
                dragImageView.setFitHeight(100);
                dragImageView.setFitWidth(100);
            
                //AnchorPane anchorPane = (AnchorPane) myTableView.getScene().getRoot();

                if (!stpane.getChildren().contains(dragImageView)) {
                    stpane.getChildren().add(dragImageView);
                }

                dragImageView.setOpacity(0.5);
                dragImageView.toFront();
                dragImageView.setMouseTransparent(true);
                dragImageView.setVisible(true);
                dragImageView.relocate(
                        (int) (t.getSceneX() - dragImageView.getBoundsInLocal().getWidth() / 2),
                        (int) (t.getSceneY() - dragImageView.getBoundsInLocal().getHeight() / 2));

                Dragboard db = fid.startDragAndDrop(TransferMode.ANY);
                ClipboardContent content = new ClipboardContent();

                /*
                InboundBean inboundBean = (InboundBean) myTableView.getSelectionModel().getSelectedItem();
                content.putString(inboundBean.getVfcNumber());
                db.setContent(content);
                */
                
                content.putString("hello");
                db.setContent(content);
                
                t.consume();
            }

            @Override
            public void handle(Event event) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }
    
}

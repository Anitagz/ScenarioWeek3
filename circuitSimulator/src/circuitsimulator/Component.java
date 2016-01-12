/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circuitsimulator;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;


/**
 *
 * @author stupidjc
 */
public class Component {
    private Image symbol;
    private End endA;
    private End endB;
   
    public Image getSymbol(){
        return symbol;
    }
    
    public End getEndA(){
        return endA;
    }
    
    public End getEndB(){
        return endB;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circuitsim2;

import java.io.Serializable;

/**
 *
 * @author Anita
 */
public class Circuit implements Serializable{
    
    private static final long serialVersionUID = 1L;
    Component[][] grid = new Component[13][9];
    int[][] start = new int[2][1];
    
    public void setComponent(Component c,int i, int j){
        grid[i][j] = c;
    }
    
    public Component getComponent(int i, int j){
        //(E)return grid[i][j];
        return grid[i][j];
    }
    
    public void run(){
        //System.out.println("It works!");
         for(int j = 0; j < 9; j++){
            for(int i=0; i < 13; i++){
                if(grid[i][j] instanceof Battery){
                    start[0][0] = i;
                    start[1][0] = j;
                    startCheck(i+1, j, "left");
                }
            }
        }
    }
    
    public void startCheck(int i, int j, String side){
        
        if(i==start[0][0] && j==start[1][0]){
            System.out.println("It works! :D");
        }
        
        else if(side.compareTo("left")==0){
            //Wires
            if(grid[i][j] instanceof Wire){
                Wire b = (Wire) grid[i][j];
                System.out.println("from left " + b.getType());
                if(b.getType().compareTo("wireHorizontal")==0){
                    startCheck(i+1, j, "left");
                }
                else if(b.getType().compareTo("wireJ")==0){
                    startCheck(i, j-1, "down");
                }
                else if(b.getType().compareTo("wireLeftDown")==0){
                    startCheck(i, j+1, "top");
                }
                else
                {
                    System.out.println("Not a valid circuit!" + i + j + " " + getLineNumber());
                }
            }
            else{
            //Components
            if(grid[i][j] instanceof Ammeter){
                startCheck(i+1, j, "left");
            }
            if(grid[i][j] instanceof Lamp){
                startCheck(i+1, j, "left");
            }
            if(grid[i][j] instanceof Battery){
                startCheck(i+1, j, "left");
            }
            if(grid[i][j] instanceof Switch){
                startCheck(i+1, j, "left");
            }
            if(grid[i][j] instanceof Resistor){
                startCheck(i+1, j, "left");
            }
            else{
                System.out.println("Not a valid circuit!" + i + j + " " + getLineNumber());
            }
            }
        }
        
        else if(side.compareTo("right")==0){
            //Wires
            if(grid[i][j] instanceof Wire){
                Wire b = (Wire) grid[i][j];
                System.out.println("from right " + b.getType());
                if(b.getType().compareTo("wireHorizontal")==0){
                    startCheck(i-1, j, "right");
                }
                else if(b.getType().compareTo("wireF")==0){
                    startCheck(i, j+1, "top");
                }
                else if(b.getType().compareTo("wireL")==0){
                    startCheck(i, j-1, "bottom");
                }
                else
                {
                    System.out.println("Not a valid circuit!" + i + j + " " + getLineNumber());
                }
            }
            //Components
            else{
            if(grid[i][j] instanceof Ammeter){
                startCheck(i-1, j, "right");
            }
            else if(grid[i][j] instanceof Lamp){
                startCheck(i-1, j, "right");
            }
            else if(grid[i][j] instanceof Battery){
                startCheck(i-1, j, "right");
            }
            else if(grid[i][j] instanceof Switch){
                startCheck(i-1, j, "right");
            }
            else if(grid[i][j] instanceof Resistor){
                startCheck(i-1, j, "left");
            }
            else{
                System.out.println("Not a valid circuit!"+i+j + " " + getLineNumber());
            }
            }
        }
        
        else if(side.compareTo("top")==0){
            //Wires
            if(grid[i][j] instanceof Wire){
                Wire b = (Wire) grid[i][j];
                if(b.getType().compareTo("wireVertical")==0){
                    startCheck(i, j+1, "top");
                }
                else if(b.getType().compareTo("wireJ")==0){
                    startCheck(i-1, j, "right");
                }
                else if(b.getType().compareTo("wireL")==0){
                    startCheck(i+1, j, "left");
                }
                else
                {
                    System.out.println("Not a valid circuit!"+i+j + " " + getLineNumber());
                }
            }
            else{
                System.out.println("Not a valid circuit!"+i+j + " " + getLineNumber());
            }
        }
        
        else if(side.compareTo("bottom")==0){
            //Wires
            if(grid[i][j] instanceof Wire){
                Wire b = (Wire) grid[i][j];
                if(b.getType().compareTo("wireVertical")==0){
                    startCheck(i, j-1, "bottom");
                }
                else if(b.getType().compareTo("wireF")==0){
                    startCheck(i+1, j, "left");
                }
                else if(b.getType().compareTo("wireLeftDown")==0){
                    startCheck(i-1, j, "right");
                }
                else
                {
                    System.out.println("Not a valid circuit!"+i+j + " " + getLineNumber());
                }
            }
            else{
                System.out.println("Not a valid circuit!"+i+j + " " + getLineNumber());
            }
        }

    }
    
    public static int getLineNumber() {
        return Thread.currentThread().getStackTrace()[2].getLineNumber();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circuitsim2;

/**
 *
 * @author Anita
 */
public class Circuit {
    Component[][] grid = new Component[13][9];
    
    public void setComponent(Component c,int i, int j){
        grid[i][j] = c;
    }
    
    public Component getComponent(int i, int j){
        //(E)return grid[i][j];
        return grid[i][j];
    }
    
    public void run(){
        System.out.println("It works!");
         for(int j = 0; j < 9; j++){
            for(int i=0; i < 13; i++){
                if(grid[i][j] instanceof Battery){
                    startCheck(i+1, j, "left");
                }
            }
        }
    }
    
    public void startCheck(int i, int j, String side){
        
        if(side.compareTo("left")==0){
            //Wires
            if(grid[i][j] instanceof Wire){
                Wire b = (Wire) grid[i][j];
                if(b.getType().compareTo("WireHorizontal")==0){
                    startCheck(i+1, j, "left");
                }
                else if(b.getType().compareTo("WireJ")==0){
                    startCheck(i, j+1, "down");
                }
                else if(b.getType().compareTo("WireLeftDown")==0){
                    startCheck(i, j-1, "top");
                }
                else if(b.getType().compareTo("WireHorizontal")==0){
                    startCheck(i+1, j, "left");
                }
                else
                {
                    System.out.println("Not a valid circuit!");
                }
            }
            if(grid[i][j] instanceof Ammeter){
                startCheck(i+1, j, "left");
            }
            if(grid[i][j] instanceof Lamp){
                startCheck(i+1, j, "left");
            }
                
            
        }
        

            
        
    
    }
}

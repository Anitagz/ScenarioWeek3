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
    Component[][] grid = new Component[9][13];
    
    public void setComponent(Component c,int i, int j){
        grid[i][j] = c;
    }
    
    public Component getComponent(int i, int j){
        //(E)return grid[i][j];
        return grid[i][j];
    }
    
}

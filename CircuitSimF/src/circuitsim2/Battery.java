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
public class Battery extends Component {
    
    private double voltage;
  
    public Battery(String n){
        super(n);
        voltage = 9;
    }
    
    public void setVoltage(double v){
        this.voltage = v;
    }
    
    public double getVoltage(){
        return voltage;
    }   
}

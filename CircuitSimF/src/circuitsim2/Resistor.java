/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circuitsim2;

/**
 *
 * @author User
 */
public class Resistor extends Component{
    
    private double resistance;
    
    public Resistor(String name, double resistance){
        super(name);
        this.resistance = resistance;
    }
    
    public void setResistance(double r) {
        this.resistance = r;
}
    
 public double getResistance() {
        return resistance;
}
 
}
    


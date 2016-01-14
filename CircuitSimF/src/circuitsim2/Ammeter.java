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
public class Ammeter extends Component{
    
    //Lamp lamp = new Lamp();
    //Battery battery = new Battery();
    //Resistor resistor = new Resistor();
    //Switch swtch = new Switch();
    
    
    private double current;
    
    public Ammeter(String name, double current){
        super(name);
        this.current = current;
    }
    /*
    public double getCurrent()
    {
        if(swtch.getStatus()==false && lamp.getStatus()==true)
        {
           current=battery.getVoltage()/(resistor.getResistance()+lamp.getResistance());
           return current;
           {       
        if(swtch.getStatus()==false && lamp.getStatus()==false)
        {
            current=battery.getVoltage()/resistor.getResistance();
            return current;
        }
        if(swtch.getStatus()==true)
        {
            current = 0;
            return current;
        }
    }
*/
            

}
    



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
public class ammeter extends Component{
    
    Lamp lamp = new Lamp();
    Battery battery = new Battery();
    Resistor resistor = new Resistor();
    Switchh swtch = new Switchh();
    
    private double current;
    
    public double getCurrent()
    {
        if(swtch.getStatus()==false && lamp.getStatus()==true)
        {
           current=battery.getEmf()/(resistor.getResistance()+lamp.getResistance());
           return current;
           {       
        if(swtch.getStatus()==false && lamp.getStatus()==false)
        {
            current=battery.getEmf()/resistor.getResistance();
            return current;
        }
        if(swtch.getStatus()==true)
        {
            current = 0;
            return current;
        }
    }
            

}
    



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
public class Voltmeter extends Component{
    
    
    //Lamp lamp = new Lamp();
    //Resistor resistor = new Resistor();
    //Switchh swtch = new Switchh();
    //Ammeter ammeter = new Ammeter();
    
  
 
    private double lampvoltage;
    private double resistorvoltage;
    
    public Voltmeter(String name){
        super(name);
    }
    
    
     /*       
    public double calculateLampVoltage()
    {
        
        if(swtch.getStatus()==true)
        {
            lampvoltage=0;
            return lampvoltage;
        }
        if(swtch.getStatus()==false && lamp.getStatus()==true)
        {
          lampvoltage=ammeter.getCurrent()*(lamp.getResistance()/(lamp.getResistance()+resistor.getResistance()));
          return lampvoltage;
        }
        if(swtch.getStatus()==false && lamp.getStatus()==false)
        {
          lampvoltage=0;
          return lampvoltage;
        }
        
        
    }
    
     public double calculateResistorvoltage()
    {
        if(swtch.getStatus()==true)
        {
            resistorvoltage=0;
            return resistorvoltage;
        }
        if(swtch.getStatus()==false && lamp.getStatus()==true)
        {
          resistorvoltage=ammeter.getCurrent()*(resistor.getResistance()/(lamp.getResistance()+resistor.getResistance()));
          return resistorvoltage;
        }
        if(swtch.getStatus()==false && lamp.getStatus()==false)
        {
         resistorvoltage=ammeter.getCurrent()*resistor.getResistance();
         return resistorvoltage;
        }
    }
    */
    
}

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
public class lamp extends Component{
    
    private boolean on;
    private double resistance;
    
public int getStatus(){
    return on;
    
}  

public void setStatus(boolean status){
    this.on=status;
}


public void setResistance(double r) {
        this.resistance = r;
    }

    public double getResistance(){
        return resistance;
  } 
}

    



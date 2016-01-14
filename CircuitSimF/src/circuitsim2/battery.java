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
public class battery extend Component{
    
    private double emf;
    
    
    public void setEmf(double volts)
    {
        this.emf=volts;
    }
    
    public double getEmf()
    {
        return emf;
    }

    
}

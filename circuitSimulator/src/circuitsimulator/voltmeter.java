/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circuitsimulator;

/**
 *
 * @author User
 */
public class voltmeter {
    
    double voltage;
    double current;
    double resistance;
    
    private double getCurrent()
    {
        return current;
    }
    
    private double getResistance()
    {
        return resistance;
    }
    
    private double calculatevoltage()
    {
        voltage=getCurrent()*getResistance();
        return voltage;
    }
}

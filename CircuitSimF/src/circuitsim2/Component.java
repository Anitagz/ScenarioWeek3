/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circuitsim2;

import java.io.Serializable;

/**
 *
 * @author Anita
 */

public class Component implements Serializable{
    private String name;
    
    
    public Component(String n){
        this.name = n;
    }

    public String getName(){
        return name;
    }
}


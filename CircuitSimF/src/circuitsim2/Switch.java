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
public class Switch extends Component{
    
    boolean open;
    
    public Switch(String name){
        super(name);
    }
    
    public void setStatus(boolean o)
    {
        this.open=o;
    }
    
    public boolean getStatus()
    {
        return open;
    }
}

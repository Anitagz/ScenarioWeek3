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
public class switchh extends Component{
    
    boolean open;
    
    public void setStatus(boolean o)
    {
        this.open=o;
    }
    
    public boolean getStatus()
    {
        return open;
    }
}

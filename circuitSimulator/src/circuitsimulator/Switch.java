/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circuitsimulator;

/**
 *
 * @author Anita
 */
public class Switch extends Component{
    //Where true = open, false = closed
    Boolean open;
    
    public void setStatus(Boolean tof){
        this.open = tof;
    }
    
    public Boolean getStatus(){
        return open;
    }
}

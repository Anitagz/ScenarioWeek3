/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circuitsim2;

/**
 *
 * @author Anita
 */

public class Wire extends Component{
    
    private String type;
    
    public Wire(String name, String type){
        super(name);
        this.type = type;
    }

    public void setType(String s) {
            this.type = s;
        }

        public String getType(){
            return type;
      } 
}

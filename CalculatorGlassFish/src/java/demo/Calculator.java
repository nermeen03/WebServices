/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author nerme
 */
@Path("/calc")
public class Calculator {
    
    @GET
    public String func(@QueryParam("num1") int num1,@QueryParam("op") String op,@QueryParam("num2") int num2){
        Integer result = 0;
        if(op.equals("sum")){ 
            result = num1+num2;           
        }
        else if(op.equals("sub")){
            result = num1-num2;
        }
        else if(op.equals("mult")){
            result = num1*num2;
        }
        else if(op.equals("div")){
            result = num1/num2;
        }
        return result.toString();
    }
    
   
}

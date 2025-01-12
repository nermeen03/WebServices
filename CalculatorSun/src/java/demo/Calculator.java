/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author nerme
 */
@Path("/calc")
public class Calculator {
    @GET
    public String sayHelloWithQuery(){
        return "sayHelloWithQuery from TestController ";
    }
    @GET
    @Path("/{num1}/add/{num2}")
    public Integer addition(@PathParam("num1") Integer num1,@PathParam("num2") Integer num2){
        return num1+num2;
    }
    
    @GET
    @Path("/{num1}/sub/{num2}")
    public Integer subtraction(@PathParam("num1") Integer num1,@PathParam("num2") Integer num2){
        return num1-num2;
    }
    
    @GET
    @Path("/{num1}/mult/{num2}")
    public Integer multiplication(@PathParam("num1") Integer num1,@PathParam("num2") Integer num2){
        return num1*num2;
    }
    
    @GET
    @Path("/{num1}/div/{num2}")
    public Integer division(@PathParam("num1") Integer num1,@PathParam("num2") Integer num2){
        return num1/num2;
    }
    
}

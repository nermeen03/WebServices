/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 *
 * @author nerme
 */
@Path("/emp")
public class EmployeeController {
    static ArrayList<Employee> employees = new ArrayList<>();
    
    @POST
    public String addEmployee(
        @FormParam("id") String id,
        @FormParam("name") String name,
        @FormParam("salary") String salary) {
        Employee emp = new Employee(id, name, salary);
        employees.add(emp);
        return "Done";
    }
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public ArrayList<Employee> getEmployee(){
        return employees;
    }
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Employee getEmployee(@PathParam("id") String id){
        Employee result = null;
        for (Employee emp:employees){
            if(emp.getId().equals(id)){
                result=emp;
            }
        }
        return result;
    }
    @PUT
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public String updateEmployee(@PathParam("id") String id,@QueryParam("name") String name,@QueryParam("salary") String salary){
        for (Employee emp:employees){
            if(emp.getId().equals(id)){
                emp.setName(name);
                emp.setSalary(salary);
                return "Done";
            }
        }
        return "not found";
    }
    @DELETE
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public String deleteEmployee(@PathParam("id") String id){
        for (Employee emp:employees){
            if(emp.getId().equals(id)){
                employees.remove(emp);
                return "Done";
            }
        }
        return "not found";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swclient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author nerme
 */
public class SwClient {
    public static void main(String[] args) {
        GsonBuilder build = new GsonBuilder();
        build.setPrettyPrinting();
        Gson gson = build.create();
        Client client = Client.create();
        String getUrl = "http://localhost:8084/Employee/rest/emp/1"; 
        WebResource webResource = client.resource (getUrl);
        WebResource.Builder builder = webResource.accept(MediaType.APPLICATION_JSON);
        ClientResponse response = builder.get(ClientResponse.class);
        if (response.getStatus () != 200) {
            throw new RuntimeException("HTTP Error: "+response.getStatus());
        }
        String rawResponse = response.getEntity(String.class);
        Employee employee =gson.fromJson(rawResponse, Employee.class);
        System.out.println("Response from the Server: "); 
        System.out.println(employee);
    }
    
}

 class Employee {
    private String id;
    private String name;
    private String salary;

    public Employee() {
    }

    public Employee(String id, String name, String salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
    }
}

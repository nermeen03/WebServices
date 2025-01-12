/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asnswclient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.*;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.async.TypeListener;
import com.sun.jersey.client.non.blocking.NonBlockingClient;
import com.sun.jersey.client.non.blocking.config.DefaultNonBlockingClientConfig;
import com.sun.jersey.client.non.blocking.config.NonBlockingClientConfig;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nerme
 */
public class AsnSwClient {

    public static void main(String[] args) {
        GsonBuilder build = new GsonBuilder();
        build.setPrettyPrinting();
        Gson gson = build.create();
        ClientConfig cc = new DefaultNonBlockingClientConfig();
        cc.getProperties().put(NonBlockingClientConfig.PROPERTY_THREADPOOL_SIZE, 10);
        Client c = NonBlockingClient.create(cc);
        String getUrl = "http://localhost:8084/Employee/rest/emp/1";
        AsyncWebResource.Builder awr2 = c.asyncResource(getUrl).accept(MediaType.APPLICATION_JSON);
        
        awr2.get(new TypeListener<ClientResponse>(ClientResponse.class) {
            @Override
            public void onComplete(Future<ClientResponse> f) throws InterruptedException {
                try {
                    ClientResponse response = f.get();
                    String rawResponse = response.getEntity(String.class);
                    Employee employee = gson.fromJson(rawResponse, Employee.class);
                    System.out.println("Response from the Server: "); 
                    System.out.println(employee);
                } catch (ExecutionException ex) {
                    Logger.getLogger(AsnSwClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
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

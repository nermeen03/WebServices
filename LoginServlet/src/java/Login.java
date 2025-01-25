
import java.io.IOException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nerme
 */
public class Login extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        String username = req.getParameter("name"); 
        String pass = req.getParameter("password");
        resp.getWriter().println("username is "+username+" , password is "+pass);
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        String username = req.getParameter("name"); 
        String pass = req.getParameter("password");
        resp.getWriter().println("username is "+username+" , password is "+pass);
    }
    
}

package Login;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class loginServlet extends HttpServlet
  {
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
       PrintWriter out=res.getWriter();
         String username=req.getParameter("username");
         String password=req.getParameter("password");
        
         try{ 
             	Class.forName("org.gjt.mm.mysql.Driver");
             	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/login","root","");
             	Statement stmt=conn.createStatement();
             	ResultSet rs=stmt.executeQuery("select * from user");
         int x=0;
        while(rs.next()) 
          {
           if(username.equals(rs.getString(1)) && password.equals(rs.getString(2)))
             {
                out.println(" Login successfully ");
                x=1;
                break;
             }            
          }
        if(x==0)
         out.println(" Login Fail");
       }
       catch(Exception e)
         {
         }       
    }
 }

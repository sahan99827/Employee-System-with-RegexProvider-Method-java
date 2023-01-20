import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;
public class StatusEmployeeDao{
public  static StatusEmployee getById(int id){

    StatusEmployee statusEmployee =  new StatusEmployee();
    try {
     
       String qry = "select * from statusEmployee where id = " +id ;
       ResultSet rslt = CommonDao.get(qry);      


            rslt.next();
            statusEmployee.setId(rslt.getInt("id"));
            statusEmployee.setName(rslt.getObject("name").toString());
        
       

    } 
   
    catch (SQLException e1) {
        System.out.println("Can't Connect as : " + e1.getMessage());
         
    }
    return statusEmployee;
}

public  static List<StatusEmployee> getAll(){

    List<StatusEmployee> statusEmployees =  new ArrayList();

    try {
     
       String qry = "select * from statusEmployee";
       ResultSet rslt = CommonDao.get(qry);      

           while( rslt.next()) {
            StatusEmployee statusEmployee = new StatusEmployee();

            statusEmployee.setId(rslt.getInt("id"));
            statusEmployee.setName(rslt.getObject("name").toString());
            

            statusEmployees.add(statusEmployee);
           }
       

    } 
   
    catch (SQLException e1) {
        System.out.println("Can't Connect as : " + e1.getMessage());
         
    }
    return statusEmployees;
}



}
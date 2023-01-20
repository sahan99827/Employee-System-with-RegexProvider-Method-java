import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

public class DesignationDao{
public  static Designation getById(int id){

    Designation designation =  new Designation();
    try {
       

       String qry = "select * from designation where id = " +id ;
        ResultSet rslt = CommonDao.get(qry);      

        rslt.next();
        designation.setId(rslt.getInt("id"));
        designation.setName(rslt.getObject("name").toString());
        
       

    } 
   
    catch (SQLException e1) {
        System.out.println("Can't Connect as : " + e1.getMessage());
         
    }
    return designation;
}
public  static List<Designation> getAll(){

    List<Designation> designations =  new ArrayList();

    try {
     
       String qry = "select * from designation";
       ResultSet rslt = CommonDao.get(qry);      

           while( rslt.next()) {
            Designation designation = new Designation();

            designation.setId(rslt.getInt("id"));
            designation.setName(rslt.getObject("name").toString());
            

            designations.add(designation);
           }
       

    } 
   
    catch (SQLException e1) {
        System.out.println("Can't Connect as : " + e1.getMessage());
         
    }
    return designations;
}


}
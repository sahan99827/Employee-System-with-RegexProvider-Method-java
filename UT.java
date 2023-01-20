import java.util.List;
import java.time.LocalDate;
import java.util.Hashtable;
public class UT{

public static void main(String[] args) {
      //s1v1
      /*
        Gender g1 = GenderDao.getById(1);
        Gender g2 = GenderDao.getById(2);

        System.out.println(g1.getName());
        System.out.println(g2.getName());

        Designation d1 = DesignationDao.getById(1);
        Designation d2 = DesignationDao.getById(2);

        System.out.println(d1.getName());
        System.out.println(d2.getName());

        
        StatusEmployee s1 = StatusEmployeeDao.getById(1);
        StatusEmployee s2 = StatusEmployeeDao.getById(2);

        System.out.println(s1.getName());
        System.out.println(s2.getName());

        List<Employee> emplist =EmployeeDao.getAll();
        
        LocalDate today = LocalDate.now();
        int cy = today.getYear();

        for(Employee emp: emplist){
            int by =emp.getDob().getYear();

            System.out.println(emp.getName()+"("+(cy- by)+")"+"\t"+emp.getNic() +"\t" +emp.getDesignation().getId()+"("+emp.getDesignation().getName()+")" );

         }

         List<Employee> emplist2 =EmployeeController.get();

         for(Employee emp: emplist2){
            
            System.out.println(emp.getName()+"\t"+emp.getNic() +"\t" +emp.getDesignation().getId()+"("+emp.getDesignation().getName()+")" );
           
            //s1v2
            //1b1
            List<Gender> genlist =GenderDao.getAll();
                       
            for(Gender gen: genlist){
                
                System.out.println(gen.getId()+ "-" + gen.getName());
             }
                         
             //1b2
             System.out.println("...........................................................................");
             List<Gender> genlist2 =GenderController.get();
                       
             for(Gender gen: genlist2){
                 
                 System.out.println(gen.getId()+ "-" + gen.getName());
              }


              //1b4
              List<Employee> emplist3 =EmployeeDao.getAllByName("s");
              System.out.println( emplist3.size());
              for(Employee emp: emplist3){
                   
                System.out.println(emp.getName());
    
             }
             List<Employee> emplist4 =EmployeeDao.getAllByName("se");
             System.out.println( emplist4.size());
             for(Employee emp: emplist4 ){
                  
               System.out.println(emp.getName());
   
            }
            List<Employee> emplist5 =EmployeeDao.getAll();
             System.out.println( emplist5.size());
             for(Employee emp: emplist5 ){
                  
               System.out.println(emp.getName());
   
            }
             
            //1b5

              Gender g1 = GenderDao.getById(1);
              Gender g2 = GenderDao.getById(2);
              
              List<Employee> empgen1 =EmployeeDao.getAllByGender(g1);
              System.out.println( empgen1.size());
              for(Employee emp:empgen1){
                   
                System.out.println(emp.getName());
    
             }
             List<Employee> empgen2 =EmployeeDao.getAllByGender(g2);
             System.out.println( empgen2.size());
             for(Employee emp:empgen2){
                  
               System.out.println(emp.getName());
   
            }
            
             
            //1b6

            Gender g1 = GenderDao.getById(1);
            Gender g2 = GenderDao.getById(2);
            
            List<Employee> empgen1 =EmployeeDao.getAllByNameAndGender("s",g1);
            System.out.println( empgen1.size());
            for(Employee emp:empgen1){
                 
              System.out.println(emp.getName());
  
           }

           List<Employee> empgen2 =EmployeeDao.getAllByNameAndGender("",g1);
           System.out.println( empgen2.size());
           for(Employee emp:empgen2){
                
             System.out.println(emp.getName());
 
          }

    
          // null -> getAll
    List<Employee> emps1 = EmployeeController.get(null);

        for(Employee emp:emps1){
                
             System.out.print(emp.getName() +'-');
 
          }
          System.out.println("\n...........................................................................");
          // getAllByName
          Hashtable<String,Object> ht = new Hashtable();
          ht.put("name","s");

          List<Employee> emps2 = EmployeeController.get(ht);
          for(Employee emp:emps2){
                
            System.out.print(emp.getName() +'-');

         }
         System.out.println("\n...........................................................................");
         //getAllGender
         Gender g1 = GenderDao.getById(1);
         Hashtable<String,Object> ht2 = new Hashtable();
         ht2.put("gender", g1);

         List<Employee> emps3 = EmployeeController.get(ht2);
         for(Employee emp:emps3){
               
           System.out.print(emp.getName() +'-');

        }
        System.out.println("\n...........................................................................");
        //getAllNameAndGender
        Hashtable<String,Object> ht3 = new Hashtable();
         ht3.put("gender", g1);
         ht3.put("name","s");

         List<Employee> emps4 = EmployeeController.get(ht3);
         for(Employee emp:emps4){
               
           System.out.print(emp.getName() +'-');

        }
        System.out.println("\n...........................................................................");
   
   //s1v3
      List<Designation> deslist =DesignationDao.getAll();
                       
      for(Designation des: deslist){
          
          System.out.println(des.getId()+ "-" + des.getName());
       }
      
      
        System.out.println("...........................................................................");
          List<Designation> list2 =DesignationController.get();
                       
             for(Designation en: list2){
                 
               System.out.println(en.getId()+ "-" + en.getName());
              }

         
        List<StatusEmployee> selist = StatusEmployeeDao.getAll();
                       
        for(StatusEmployee es: selist){
            
            System.out.println(es.getId()+ "-" + es.getName());
         }
         System.out.println("...........................................................................");
         List<StatusEmployee> selist2 =StatusEmployeeController.get();
                      
            for(StatusEmployee es: selist2){
                
              System.out.println(es.getId()+ "-" + es.getName());
             }
      */

      String rgname= RegexProvider.get();
      System.out.println(rgname);
      }
}

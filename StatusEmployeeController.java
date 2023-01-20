import java.util.List;

public class StatusEmployeeController{

public static List<StatusEmployee> get(){

    List<StatusEmployee> statusEmployees =StatusEmployeeDao.getAll();

    return statusEmployees;

}
}
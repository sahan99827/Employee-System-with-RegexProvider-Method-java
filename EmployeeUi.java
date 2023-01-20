import javax.swing.JFrame;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.util.Vector;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.Hashtable;
import java.time.LocalDate;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import com.toedter.calendar.JDateChooser;
import java.util.Date;
import com.toedter.calendar.JCalendar;

public class EmployeeUi extends JFrame {
  // Goble Varible
  JTable tblEmployee;
  JComboBox<Object> cmbSearchGender;
  JTextField textSearchName;
  Vector titles;

  JTextField txtName;
  JTextField txtNic;
  JTextField txtMobile;
  JTextField txtEmail;
  JTextField txtDate;

  //ComboBox
  JComboBox<Object> cmbGender;
  JComboBox<Object> cmblDesignation;
  JComboBox<Object> cmbStatusEmpolyee;

  //Button
  JButton btnAdd;
  JButton btnClear;
  JButton btnUpdate;
  JButton btnDelet;
  
  //Color
  Color valid;
  Color invalid;
  Color initial;
  Color update;



  Employee oldEmployee;
  Employee employee;

  List<Employee> emplist;
  List<Gender> genlist;
  List<Designation> deslist;
  List<StatusEmployee> selist;

  JDateChooser datDob;
  //Regex Valadition in RegexPovider
  Hashtable<String,String> rgName;




  // String errors;

  // Constracter
  EmployeeUi() {

    valid = new Color(200, 255, 200);
    invalid = Color.pink;
    initial = Color.white;
    update = Color.yellow;
   
    setTitle("Employee Details(Harvest Super)");
    setLocation(300, 200);
    setSize(660, 700);
    //setBackground(constracter);

    Color C = Color.CYAN; 
   
    Container con = getContentPane();
    FlowLayout lay1 = new FlowLayout();
    con.setLayout(lay1);
    con.setBackground(C);

    // Leble
    JLabel lblNmae = new JLabel("Name  : ");
    JLabel lblDob = new JLabel("DOB  : ");
    JLabel lblGender = new JLabel("      Gender  : ");
    JLabel lblNic = new JLabel("NIC  : ");
    JLabel lblMobile = new JLabel("Mobile NO : ");
    JLabel lblEmail = new JLabel("Email  : ");
    JLabel lblDesignation = new JLabel("Designation  : ");
    JLabel lblStatus = new JLabel("     StatusEmployee  : ");

    // Text Filed
    txtName = new JTextField(52);
    txtNic = new JTextField(52);
    txtMobile = new JTextField(50);
    txtEmail = new JTextField(50);

    // ComboBox
    cmbGender = new JComboBox();
    cmblDesignation = new JComboBox();
    cmbStatusEmpolyee = new JComboBox();
    // cmbDobYear =new JComboBox();
    // cmbDobMonth =new JComboBox();
    // cmbDobDay =new JComboBox();

    // Button
    btnAdd = new JButton("Add");
    btnClear = new JButton("Clear");
    btnUpdate = new JButton("Update");
    btnDelet = new JButton("Delet");

    datDob = new JDateChooser();
    JLabel lblEmpty = new JLabel(
        "                                                                                                                                                                                                             ");

    con.add(lblNmae);
    con.add(txtName);
    con.add(lblDob);
    con.add(datDob);
    // con.add(cmbDobYear); con.add(cmbDobMonth); con.add(cmbDobDay);
    con.add(lblGender);
    con.add(cmbGender);
    con.add(lblEmpty);
    con.add(lblNic);
    con.add(txtNic);
    con.add(lblMobile);
    con.add(txtMobile);
    con.add(lblEmail);
    con.add(txtEmail);
    con.add(lblDesignation);
    con.add(cmblDesignation);
    con.add(lblStatus);
    con.add(cmbStatusEmpolyee);

    JLabel lblfristEnd = new JLabel(
        "\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
    con.add(lblfristEnd);

    con.add(btnDelet);
    con.add(btnUpdate);
    con.add(btnClear);
    con.add(btnAdd);

    JLabel lblFormEnd = new JLabel(
        "\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
    JLabel lblFormEnd2 = new JLabel(
        "\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
    con.add(lblFormEnd);
    con.add(lblFormEnd2);

    JLabel lblSearchNmae = new JLabel("Name  : ");
    textSearchName = new JTextField(20);
    JLabel lblSearchGender = new JLabel("Gender  : ");
    cmbSearchGender = new JComboBox();
    JButton btnSearchClear = new JButton("Clear Search");
    JButton btnSearch = new JButton("Search");

    con.add(lblSearchNmae);
    con.add(textSearchName);
    con.add(lblSearchGender);
    con.add(cmbSearchGender);

    JLabel lblfristEnd4 = new JLabel(
        "\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
    con.add(lblfristEnd4);

    con.add(btnSearchClear);
    con.add(btnSearch);

    JLabel lblSeconEnd = new JLabel(
        "\n.......................................................................................................................................................................................................................................................................................................................................................................\n");
    con.add(lblSeconEnd);
    JLabel lblSeconEnd2 = new JLabel(
        "\n.......................................................................................................................................................................................................................................................................................................................................................................\n");
    con.add(lblSeconEnd2);

    // Table
    titles = new Vector();
    titles.add("Name");
    titles.add("Dob");
    titles.add("NIC");
    titles.add("Gender");
    titles.add("Desgination");

    Vector data = new Vector();

    DefaultTableModel dataModel = new DefaultTableModel(data, titles);
    tblEmployee = new JTable();

    Color  C1 =new  Color(252, 243, 207);
    tblEmployee.setModel(dataModel);
    tblEmployee.setBackground(C1);

    JScrollPane jspTable = new JScrollPane();
    jspTable.setPreferredSize(new Dimension(550, 200));
    jspTable.setViewportView(tblEmployee);
    

    con.add(jspTable);

    btnSearch.addActionListener(e -> { btnSearchAp(e); });
    btnSearchClear.addActionListener( e -> { btnSearchClearAp(e);  });

    //ComboBox Registation
    cmblDesignation.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        cmblDesignationAp(e);
      }
    });
    cmbGender.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        cmbGenderAp(e);
      }
    });
    cmbStatusEmpolyee.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        cmbStatusEmpolyeeAp(e);
      }
    });
  
    txtName.addKeyListener(new KeyAdapter() {
      public void keyReleased(KeyEvent e) {
        txtNameKR(e);
      }
    });
    txtNic.addKeyListener(new KeyAdapter() {
      public void keyReleased(KeyEvent e) {
        txtNicKR(e);
      }
    });
    txtMobile.addKeyListener(new KeyAdapter() {
      public void keyReleased(KeyEvent e) {
        txtMobileKR(e);
      }
    });
    txtEmail.addKeyListener(new KeyAdapter() {
      public void keyReleased(KeyEvent e) {
        txtEmailKR(e);
      }
    });

    btnAdd.addActionListener(e ->{btnAddAp(e); });

    btnClear.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnclearAp(e);
      }
    });
    btnUpdate.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpdateAp(e);
      }
    });
    btnDelet.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnDeletAp(e);
      }
    });

    datDob.addPropertyChangeListener(new PropertyChangeListener() {
      public void propertyChange(PropertyChangeEvent e) {
        datDobAp(e);
      }
    });

    tblEmployee.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent e) {
        tblEmployeeVC(e);
      }
    });

    intitialize();

  }

  // Method
  
  public void intitialize() {

    rgName = RegexProvider.get();
    


    loadform();
    loadView();

  }

  public void loadform() {

    employee = new Employee();
    // Gender
    genlist = GenderController.get();
    Vector<Object> genders = new Vector();
    genders.add("Select a Gender");

    for (Gender gen : genlist) {
      genders.add(gen);

    }

    DefaultComboBoxModel<Object> genModel = new DefaultComboBoxModel(genders);
    cmbGender.setModel(genModel);

    // Designation
    deslist = DesignationController.get();
    Vector<Object> designations = new Vector();
    designations.add("Select a Designation");

    for (Designation des : deslist) {
      designations.add(des);

    }

    DefaultComboBoxModel<Object> desModel = new DefaultComboBoxModel(designations);
    cmblDesignation.setModel(desModel);

    // StatusEmployee
    selist = StatusEmployeeController.get();
    Vector<Object> statusEmployees = new Vector();
    statusEmployees.add("Select StatusEmployee");

    for (StatusEmployee se : selist) {
      statusEmployees.add(se);

    }
    DefaultComboBoxModel<Object> seModel = new DefaultComboBoxModel(statusEmployees);
    cmbStatusEmpolyee.setModel(seModel);

    txtName.setText("");
    txtNic.setText("");
    txtEmail.setText("@gmail.com");
    txtMobile.setText("07");

    txtDate = (JTextField) datDob.getDateEditor().getUiComponent();
    txtDate.setText("");

    oldEmployee= null;
    enabledButtons(true, false, false);
    setStyle(initial);

  }

  public void enabledButtons(boolean add, boolean upd, boolean delt) {
    btnAdd.setEnabled(add);
    btnUpdate.setEnabled(upd);
    btnDelet.setEnabled(delt);

  }

  public void setStyle(Color clr) {

    txtName.setBackground(clr);
    txtMobile.setBackground(clr);
    txtNic.setBackground(clr);
    txtEmail.setBackground(clr);

    cmblDesignation.setBackground(clr);
    cmbStatusEmpolyee.setBackground(clr);
    cmbGender.setBackground(clr);

    

    txtDate = (JTextField) datDob.getDateEditor().getUiComponent();
    txtDate.setBackground(clr);
    // cmbDobDay.setBackground(clr);
    // cmbDobMonth.setBackground(clr);
    // cmbDobYear.setBackground(clr);

  }

  public void fillForm() {

    enabledButtons(false, true, true);
    setStyle(valid);
  }

  public void loadView() {
    emplist = EmployeeController.get(null);
    fillTable(emplist);

    List<Gender> genlist = GenderController.get();
    Vector<Object> genders = new Vector();
    genders.add("Select a Gender");

    for (Gender gen : genlist) {
      genders.add(gen);

    }

    DefaultComboBoxModel<Object> genModel = new DefaultComboBoxModel(genders);
    cmbSearchGender.setModel(genModel);

  }

  public void fillTable(List<Employee> employees) {

    Vector data = new Vector();
    for (Employee emp : employees) {
      Vector r = new Vector();
      r.add(emp.getName());
      r.add(emp.getDob().toString());
      r.add(emp.getNic());
      r.add(emp.getGender().getName());
      r.add(emp.getDesignation().getName());

      data.add(r);
    }
    DefaultTableModel dataModel = new DefaultTableModel(data, titles);
    tblEmployee.setModel(dataModel);
  }

  public void btnSearchAp(ActionEvent e) {

    String name = textSearchName.getText();

    Object stitem = cmbSearchGender.getSelectedItem();
    Gender gender = null;

    if (!stitem.equals("Select a Gender"))
      gender = (Gender) stitem;

    Hashtable<String, Object> ht = new Hashtable();
    ht.put("name", name);
    if (gender != null)
      ht.put("gender", gender);

    emplist = EmployeeController.get(ht);
    fillTable(emplist);
  }

  public void btnSearchClearAp(ActionEvent e) {

    int opt = JOptionPane.showConfirmDialog(null, "Are you sure to clear the clear");

    if (opt != 1) {

      textSearchName.setText("");
      cmbSearchGender.setSelectedIndex(0);

      emplist = EmployeeController.get(null);
      fillTable(emplist);
    }
  }

  // binding and validation

  public void cmblDesignationAp(ActionEvent e) {

    int desindex = cmblDesignation.getSelectedIndex();
    if (desindex != 0) {
      cmblDesignation.setBackground(valid);
      employee.setDesignation((Designation) cmblDesignation.getSelectedItem());
     if( oldEmployee != null){ 
          if (!employee.getDesignation().equals(oldEmployee.getDesignation())) 
                cmblDesignation.setBackground(update);
            }
            //cmblDesignation.setBackground(valid);        
    } else {
      cmblDesignation.setBackground(invalid);
      employee.setDesignation(null);
    }
  }
  
  public void cmbGenderAp(ActionEvent e) {

    int gendindex = cmbGender.getSelectedIndex();
    if (gendindex != 0) {
      cmbGender.setBackground(valid);
      employee.setGender((Gender) cmbGender.getSelectedItem());
      if( oldEmployee != null){ 
        if (!employee.getGender().equals(oldEmployee.getGender())) 
              cmbGender.setBackground(update);
        }
       //cmbGender.setBackground(valid);
        
    } else {
      cmbGender.setBackground(invalid);
      employee.setGender(null);
    }
  }

  public void cmbStatusEmpolyeeAp(ActionEvent e) {
    int Seindex = cmbStatusEmpolyee.getSelectedIndex();
    if (Seindex != 0) {
      cmbStatusEmpolyee.setBackground(valid);
      employee.setStatusEmployee((StatusEmployee) cmbStatusEmpolyee.getSelectedItem());
      if( oldEmployee != null) {   
                 if (!employee.getStatusEmployee().equals(oldEmployee.getStatusEmployee())) 
                  cmbStatusEmpolyee.setBackground(update);
           }
          //cmbStatusEmpolyee.setBackground(valid);
  } else {
      cmbStatusEmpolyee.setBackground(invalid);
      employee.setStatusEmployee(null);
    }
  }

  public void txtNameKR(KeyEvent e) {
    
      String name = txtName.getText();
    
      if (name.matches(rgName.get("name"))) {  //"^[A-Z][a-z]*$"
            employee.setName(name);
            txtName.setBackground(valid);
        if( oldEmployee != null){ 
            if (!employee.getName().equals(oldEmployee.getName()))
                txtName.setBackground(update);
          }
      }else {
      txtName.setBackground(invalid);
      employee.setName(null);
    }
  }
  
  public void txtNicKR(KeyEvent e) {

    String nic = txtNic.getText();
    if (nic.matches(rgName.get("nic"))) {
        employee.setNic(nic);
        txtNic.setBackground(valid);
      if( oldEmployee != null){ 
        if (!employee.getNic().equals(oldEmployee.getNic())) 
        txtNic.setBackground(update);
      }
      //txtNic.setBackground(valid);
      
  }else {
      txtNic.setBackground(invalid);
      employee.setNic(null);
    }
  }

  public void txtMobileKR(KeyEvent e) {

    String mobile = txtMobile.getText();
    if (mobile.matches(rgName.get("mobile"))) {
      employee.setMobile(mobile);
      txtMobile.setBackground(valid);
      if( oldEmployee != null){ 
        if (!employee.getMobile().equals(oldEmployee.getMobile())) 
            txtMobile.setBackground(update);
      }
      //txtMobile.setBackground(valid);
    
    } else {
      txtMobile.setBackground(invalid);
      employee.setMobile(null);
    }
  }

  public void txtEmailKR(KeyEvent e) {

    String email = txtEmail.getText();
  
    if (email.matches(rgName.get("email"))) {
      employee.setEmail(email);
      txtEmail.setBackground(valid);
      if( oldEmployee != null){ 
      if (!employee.getEmail().equals(oldEmployee.getEmail())) 
        txtEmail.setBackground(update);
      }
      //txtEmail.setBackground(valid);
      
    } else {
      txtEmail.setBackground(invalid);
      employee.setEmail(null);
    }
  } 

    public void datDobAp(PropertyChangeEvent e) {
    Date dt = datDob.getDate();
    if (dt != null) {
      LocalDate dob = LocalDate.of(dt.getYear() + 1900, dt.getMonth() + 1, dt.getDate());
      LocalDate today = LocalDate.now();
      int age = today.getYear() - dob.getYear();

      txtDate = (JTextField) datDob.getDateEditor().getUiComponent();
      if (age >= 20) {
        employee.setDob(dob);
        txtDate.setBackground(valid);
        if( oldEmployee != null){ 
            if (age >= 20 && !employee.getDob().equals(oldEmployee.getDob()))
                txtDate.setBackground(update);
          }
        //txtDate.setBackground(valid);
          
      } else {
        employee.setDob(null);
        txtDate.setBackground(invalid);
      }

    }

  }

    // form Haderling

  public String getErrors() {
    String errors = "";

    if (employee.getName() == null)
      errors = errors + "\n invalid Name";
    if (employee.getNic() == null)
      errors = errors + "\n invalid NIC";
    if (employee.getMobile() == null)
      errors = errors + "\n invalid Moblie";
    if (employee.getEmail() == null)
      errors = errors + "\n invalid Email";
    if (employee.getGender() == null)
      errors = errors + "\n Gender Not selected";
    if (employee.getDesignation() == null)
      errors = errors + "\n Designation Not selected";
    if (employee.getStatusEmployee() == null)
      errors = errors + "\n StatusEmployee Not selected";
    if (employee.getDob() == null)
      errors = errors + "\n Calnder Not selected";

    return errors;
  }

  public void btnAddAp(ActionEvent e) {

    String error = getErrors();

    if (error.isEmpty()) {

      String cnfMsg = "Are you sure to save following Employee?\n\n";
      cnfMsg = cnfMsg + "\nName :" + employee.getName();
      cnfMsg = cnfMsg + "\nNic :" + employee.getNic();
      cnfMsg = cnfMsg + "\nDOB :" + employee.getDob().toString();
      cnfMsg = cnfMsg + "\nGender :" + employee.getGender().getName();
      cnfMsg = cnfMsg + "\nMobile :" + employee.getMobile();
      cnfMsg = cnfMsg + "\nEmail :" + employee.getEmail();
      cnfMsg = cnfMsg + "\nDesignation :" + employee.getDesignation().getName();
      cnfMsg = cnfMsg + "\nStatusEmployee :" + employee.getStatusEmployee().getName();

      int cof = JOptionPane.showConfirmDialog(null, cnfMsg);

      if (cof == 0) {
        String st = EmployeeController.post(employee);
        if (st.equals("1")) {
          loadView();
          loadform();
          JOptionPane.showMessageDialog(null, "Successfully saved");
        } else {
          JOptionPane.showMessageDialog(null, "Faild to save as \n\n" + st);
        }

      }
    } else {
      JOptionPane.showMessageDialog(null, "You have Errors:" + error);

    }

  }

  public void tblEmployeeVC(ListSelectionEvent e) {
    int row = tblEmployee.getSelectedRow();
    if (row > -1) {
      Employee em = emplist.get(row);
      fillForm(em);
    }
  }

  public void fillForm(Employee emp) {
    oldEmployee = emp;

    employee = new Employee();
    employee.setName(emp.getName());
    employee.setNic(emp.getNic());
    employee.setMobile(emp.getMobile());
    employee.setEmail(emp.getEmail());
    employee.setGender(emp.getGender());
    employee.setDesignation(emp.getDesignation());
    employee.setStatusEmployee(emp.getStatusEmployee());
    employee.setDob(emp.getDob());

    txtName.setText(emp.getName());
    txtNic.setText(emp.getNic());
    txtMobile.setText(emp.getMobile());
    txtEmail.setText(emp.getEmail());

    for (Gender gen : genlist) {
      if (gen.equals(emp.getGender())) {
        cmbGender.setSelectedItem(gen);
        break;
      }

    }
    for (Designation en : deslist) {
      if (en.getId() == emp.getDesignation().getId()) {
        cmblDesignation.setSelectedItem(en);
        break;
      }

    }

    for (StatusEmployee se : selist) {
      if (se.getId() == employee.getStatusEmployee().getId()) {
        cmbStatusEmpolyee.setSelectedItem(se);
        break;
      }

    }
    datDob.setDate(new java.util.Date(emp.getDob().toEpochDay()));
    int year = emp.getDob().getYear();
    int month = emp.getDob().getMonthValue();
    int day = emp.getDob().getDayOfMonth();

    java.util.Date datdob = new java.util.Date(year - 1900, month - 1, day);
    datDob.setDate(datdob);
    // System.out.println(year +"-"+ month +"-"+day);

    datDob.updateUI();
    enabledButtons(false, true, true);
    setStyle(valid);
  }

  public void btnclearAp(ActionEvent e) {
    int con = JOptionPane.showConfirmDialog(null, "Are sure to clear the form");

    if (con == 0)
      loadform();
      //oldEmployee= null;
  }

  public String getUpdates() {

    String updates = "";
    
    // Name
   
      if (!employee.getName().equals(oldEmployee.getName())) {
           updates = updates + "\n Name Updated" + "-" + employee.getName();
      }
    

    // NIC
    
        if (!employee.getNic().equals(oldEmployee.getNic())) {
            updates = updates + "\n NIC Updated" + "-" + employee.getNic();
      }
    
    // Email
   
      if (!employee.getEmail().equals(oldEmployee.getEmail())) {
            updates = updates + "\n Email Updated" + "-" + employee.getEmail();
      }
    

    // Mobile
        if (!employee.getMobile().equals(oldEmployee.getMobile())) {
            updates = updates + "\n Mobile Updated" + "-" + employee.getMobile();
      }
    

    // Gender
         if (!employee.getGender().equals(oldEmployee.getGender())) {
               updates = updates + "\n Gender Updated" + "-" + employee.getGender();
      }
    

    // Designation
   
      if (!employee.getDesignation().equals(oldEmployee.getDesignation())) {
               updates = updates + "\nDesignation Updated" + "-" + employee.getDesignation();
      }
    

    // StatusEmployee
    
      if (!employee.getStatusEmployee().equals(oldEmployee.getStatusEmployee())) {
              updates = updates + "\n StasusEmployee Updated" + "-" + employee.getStatusEmployee();

      }
    
    // Dob
    Date dt = datDob.getDate();
    if (dt != null) {
      LocalDate dob = LocalDate.of(dt.getYear() + 1900, dt.getMonth() + 1, dt.getDate());
      LocalDate today = LocalDate.now();
      int age = today.getYear() - dob.getYear();
      txtDate = (JTextField) datDob.getDateEditor().getUiComponent();
      if (age >= 20 && !employee.getDob().equals(oldEmployee.getDob()))
        updates = updates + "\n Bith Day Updated" + "-" + employee.getDob();
    }
    return updates;
  }

  public void btnUpdateAp(ActionEvent e) {


    employee.setId(oldEmployee.getId());
    String error = getErrors();
    

    if (error.isEmpty()) {

      String updates = getUpdates();

      if (!updates.isEmpty()) {
        int resp = JOptionPane.showConfirmDialog(null, "you have following Updates\n\n" + updates);

        if (resp == 0) {

          String status = EmployeeController.put(employee);

          if (status.equals("1")) {
            int lsrow = tblEmployee.getSelectedRow();
            // loadform();
            loadView();
            tblEmployee.setRowSelectionInterval(lsrow, lsrow);
            loadform();
           //tblEmployee.clearSelection();
            //oldEmployee =null;
            JOptionPane.showMessageDialog(null, "Successfully Updated");

          } else {
            JOptionPane.showMessageDialog(null, "Faild to Updated as\n\n" + updates);
          }

        }
      } else {
        JOptionPane.showMessageDialog(null, "Nothing to be Update");
      }

    } else {
      JOptionPane.showMessageDialog(null, "you have following data Error\n\n" + error);
    }

  }

  public void btnDeletAp(ActionEvent e) {
    int resp = JOptionPane.showConfirmDialog(null,
        "Are You Sure to Delete following Employee\n\n" + oldEmployee.getName());

    if (resp == 0) {
      String status = EmployeeController.Delete(oldEmployee);

      if (status.equals("1")) {

        loadform();
        loadView();
       //oldEmployee = null;

        JOptionPane.showMessageDialog(null, "Successfully Deleted");

      } else {
        JOptionPane.showMessageDialog(null, "Faild to Deleted as\n\n" + status);
      }

    }
  }
}

package employee.comapny;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

public class updateemployee extends JFrame implements ActionListener {

    JTextField tfname,taddress,tphoneno,temail,tsalary,tdesignation,teducation;
    
  
    JLabel tempid,jtname,tadhar;
  JButton add,back;
  String number;

    updateemployee(String number){
    this.number = number;
   
       
   getContentPane().setBackground(new ColorUIResource(163, 255, 188));



   JLabel  name = new JLabel("NAME");
   name.setBounds(50,150,150,30);
   name.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
   add(name);

   jtname = new JLabel();
   jtname.setBounds(200,150,150,30);
   jtname.setBackground(new Color(177,252,197));
   add(jtname);

   JLabel  fname = new JLabel("FATHER NAME");
   fname.setBounds(400,150,150,30);
   fname.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
   add(fname);

   tfname = new JTextField();
   tfname.setBounds(600,150,150,30);
   tfname.setBackground(new Color(177,252,197));
   add(tfname);

   JLabel  dob = new JLabel("date of birth");
   dob.setBounds(50,200,150,30);
   dob.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
   add(dob);
   JLabel tdob = new JLabel();
   tdob.setBounds(200,200,150,30);
   tdob.setBackground(new Color(177,252,197));
   add(tdob);

   JLabel  address = new JLabel("Address");
   address.setBounds(400,200,150,30);
   address.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
   add(address);

   taddress = new JTextField();
   taddress.setBounds(600,200,150,30);
   taddress.setBackground(new Color(177,252,197));
   add(taddress);

   JLabel  adhar = new JLabel("AADHAR");
   adhar.setBounds(50,250,150,30);
   adhar.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
   add(adhar);
   tadhar = new JLabel();
   tadhar.setBounds(200,250,150,30);
   tadhar.setBackground(new Color(177,252,197));
   add(tadhar);

   JLabel  phoneno = new JLabel("Phone no");
   phoneno.setBounds(400,250,150,30);
   phoneno.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
   add(phoneno);
   tphoneno = new JTextField();
   tphoneno.setBounds(600,250,150,30);
   tphoneno.setBackground(new Color(177,252,197));
   add(tphoneno);

   JLabel  designation = new JLabel("designation");
   designation.setBounds(50,300,150,30);
   designation.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
   add(designation);
   tdesignation = new JTextField();
   tdesignation.setBounds(200,300,150,30);
   tdesignation.setBackground(new Color(177,252,197));
   add(tdesignation);

   JLabel  salary = new JLabel("salary");
   salary.setBounds(400,300,150,30);
   salary.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
   add(salary);
   tsalary = new JTextField();
   tsalary.setBounds(600,300,150,30);
   tsalary.setBackground(new Color(177,252,197));
   add(tsalary);

   JLabel  email = new JLabel("Email");
   email.setBounds(50,350,150,30);
   email.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
   add(email);
   temail = new JTextField();
   temail.setBounds(200,350,150,30);
   temail.setBackground(new Color(177,252,197));
   add(temail);

   JLabel  education = new JLabel("Education");
   education.setBounds(400,350,150,30);
   education.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
   add(education);
     
  

   teducation = new JTextField();
   teducation.setBounds(600,350,200,30);
   teducation.setBackground(new Color(177,252,197));
   add(teducation);

   JLabel  empid = new JLabel("Empid");
   empid.setBounds(50,400,150,30);
   empid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
   add(empid);

   JLabel tempid = new JLabel();
   tempid.setBounds(200,400,150,30);
   tempid.setBackground(new Color(177,252,197));
   tempid.setForeground(Color.BLACK);
   add(tempid);

   add = new JButton("update");
   add.setBounds(450, 550, 150, 40);
   add.setBackground(Color.black);
   add.setForeground(Color.white);
   add.setFont(new Font("sansrif", Font.BOLD, 10));
   add.addActionListener(this);
   add(add);

   back = new JButton("Back");
   back.setBounds(250, 550, 150, 40);
   back.setBackground(Color.black);
   back.setForeground(Color.white);
   back.setFont(new Font("sansrif", Font.BOLD, 10));
   back.addActionListener(this);
   add(back);

   try {
    conn c = new conn();
    String query = "select * from employeedetail where empid = '"+number+"'";
  
    ResultSet r = c.statement.executeQuery(query);
    while(r.next()){
        jtname.setText(r.getString("name"));
        tfname.setText(r.getString("fname"));
        taddress.setText(r.getString("address"));
        tphoneno.setText(r.getString("phoneno"));
        tadhar.setText(r.getString("adhar"));
        temail.setText(r.getString("email"));
        tempid.setText(r.getString("empid"));
        tsalary.setText(r.getString("slary"));
        tdesignation.setText(r.getString("designation"));
        tdob.setText(r.getString("dob"));
        teducation.setText(r.getString("education"));
    }
    
   } catch (Exception e) {
    // TODO: handle exception
    e.printStackTrace();
   }

     setSize(900, 700);
     setLocation(300,50);
     setLayout(null);
     setVisible(true);   

    }

    public static void main(String[] args) {
        new updateemployee("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
       
        if(e.getSource()==add)
        {

            String name = jtname.getText();
            String fname = tfname.getText();
            String address = taddress.getText();
            String phoneno = tphoneno.getText();
            String email = temail.getText();
            String salry = tsalary.getText();
            String designation = tdesignation.getText();
          
            String education = teducation.getText();

              try 
              {
            String query = "UPDATE employeedetail   set fname = ?, address  = ?, phoneno = ?, email = ?, slary  = ?, designation  = ?, education = ? WHERE empid = '"+number+"'";
            
            // Create a connection object (assuming conn is a class with connection setup)
            conn c = new conn();
            PreparedStatement stmt = c.connection.prepareStatement(query);
            
            // Set values in the prepared statement
            stmt.setString(1, fname);
            stmt.setString(2, address);
            stmt.setString(3, phoneno);
            stmt.setString(4, email);
            stmt.setString(5, salry);
            stmt.setString(6, designation);
            stmt.setString(7, education);
            
            // Execute the updat
            
             stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "employee detail added successfully");
            setVisible(false);
            new viewclass();
        }
        catch(Exception E){
            E.printStackTrace();        
        }
    }
        else{
            setVisible(false);
        }
    }
}

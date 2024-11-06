package employee.comapny;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

import com.toedter.calendar.JDateChooser;

public class addemployee extends JFrame  implements ActionListener{
    
    JTextField tname,tfname,taddress,tphoneno,tadhar,temail,tsalary,tdesignation;
    JDateChooser tdob;
    JComboBox teducation;
    JLabel tempid;
  JButton add,back;
  Random ran = new Random();
  int number  = ran.nextInt(999999);
    addemployee(){
       
   getContentPane().setBackground(new ColorUIResource(163, 255, 188));

   JLabel heading = new JLabel("Add employee details");
   heading.setBounds(320,30,500,50);
   heading.setFont(new FontUIResource("serif",Font.BOLD,25));
   add(heading);

   JLabel  name = new JLabel("NAME");
   name.setBounds(50,150,150,30);
   name.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
   add(name);

   tname = new JTextField();
   tname.setBounds(200,150,150,30);
   tname.setBackground(new Color(177,252,197));
   add(tname);

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
   tdob = new JDateChooser();
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
   tadhar = new JTextField();
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
     
   String list[]={"B.tech","Bca","mca","m.tech","mba","mbbs"};

   teducation = new JComboBox<>(list);
   teducation.setBounds(600,350,200,30);
   teducation.setBackground(new Color(177,252,197));
   add(teducation);

   JLabel  empid = new JLabel("Empid");
   empid.setBounds(50,400,150,30);
   empid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
   add(empid);

   tempid = new JLabel(""+number);
   tempid.setBounds(200,400,150,30);
   tempid.setBackground(new Color(177,252,197));
   tempid.setForeground(Color.BLACK);
   add(tempid);

   add = new JButton("Add");
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

     setSize(900, 700);
     setLocation(300,50);
     setLayout(null);
     setVisible(true);   

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== add){
            String name = tname.getText();
            String fname = tfname.getText();
            String address = taddress.getText();
            String phoneno = tphoneno.getText();
            String aadhar = tadhar.getText();
            String email = temail.getText();
            String empid = tempid.getText();
            String salry = tsalary.getText();
            String designation = tdesignation.getText();
            String dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String education = (String)teducation.getSelectedItem();

        conn c = new conn();
        String query =  "insert into employeedetail values(?,?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement pstm = c.connection.prepareStatement(query)) {
            pstm.setString(1, name);
            // Set other parameters as needed
            pstm.setString(2, fname);
            pstm.setString(3, address);
            pstm.setString(4, phoneno);
            pstm.setString(5, aadhar);
            pstm.setString(6, email);
            pstm.setString(7, empid);
            pstm.setString(8, salry);
            pstm.setString(9, designation);
            pstm.setString(10, dob);
            pstm.setString(11, education);
        
            // Execute the query
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "employee detail added successfully");
            setVisible(false);
            new showclass();
        }
             catch (Exception E) {
            E.printStackTrace();
        }
    }
    else{
        setVisible(false);
        new showclass();
    }
    }
    public static void main(String[] args) {
        new addemployee();
    }
}

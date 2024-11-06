package employee.comapny;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class removeemployee extends JFrame implements ActionListener {

    Choice choiceemp;
    JButton remove,back;
    removeemployee(){

     JLabel heading = new JLabel("choose the empid here");
     heading.setBounds(50,50,200,30);
     heading.setFont(new Font("Tahoma", Font.BOLD, 15));
     add(heading);

 choiceemp = new Choice();
 choiceemp.setBounds(250,50,150,30);
 add(choiceemp);

 try {
    conn c = new conn();
    ResultSet r = c.statement.executeQuery("select * from employeedetail");
     while (r.next()) {
        choiceemp.add(r.getString("empid")); 
     }
 } catch (Exception e) {
    // TODO: handle exception
    e.printStackTrace();
 }

 JLabel name  = new JLabel("name");
 name.setBounds(50,100,200,30);
 name.setFont(new Font("Tahoma", Font.BOLD, 15));
 add(name);

 JLabel tname = new JLabel();
 tname.setBounds(250,100,150,30);
 add(tname);

 JLabel phoneno  = new JLabel("phoneno");
 phoneno.setBounds(50,150,200,30);
 phoneno.setFont(new Font("Tahoma", Font.BOLD, 15));
 add(phoneno);

 JLabel tphoneno = new JLabel();
 tphoneno.setBounds(250,150,150,30);
 add(tphoneno);

 JLabel email  = new JLabel("email");
 email.setBounds(50,200,200,30);
 email.setFont(new Font("Tahoma", Font.BOLD, 15));
 add(email);

 JLabel temail = new JLabel();
 temail.setBounds(250,200,350,30);
 add(temail);

 try {
    conn c = new conn();
    ResultSet r = c.statement.executeQuery("select * from employeedetail where empid = '"+choiceemp.getSelectedItem()+"'");
    while (r.next()) {
        tname.setText(r.getString("name"));
        tphoneno.setText(r.getString("phoneno"));
        temail.setText(r.getString("email"));
    }
 } catch (Exception e) {
    // TODO: handle exception
    e.printStackTrace();
 }

 choiceemp.addItemListener(new ItemListener() {

    @Override
    public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub
        try {
            conn c = new conn();
            ResultSet r = c.statement.executeQuery("select * from employeedetail where empid = '"+choiceemp.getSelectedItem()+"'");
            while (r.next()) {
                tname.setText(r.getString("name"));
                tphoneno.setText(r.getString("phoneno"));
                temail.setText(r.getString("email"));
            }
         } catch (Exception E) {
            // TODO: handle exception
            E.printStackTrace();
         }
    }
    
 });


remove = new JButton("remove");
remove.setBounds(80,300,100,30);
remove.setForeground(Color.white);
remove.setBackground(Color.BLACK);
add(remove);
remove.addActionListener(this);

back = new JButton("back");
back.setBounds(250,300,100,30);
back.setForeground(Color.white);
back.setBackground(Color.BLACK);
add(back);
back.addActionListener(this);

ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/delete.png")) ;
     Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
     ImageIcon i3 = new ImageIcon(i2);
     JLabel i4 = new JLabel(i3);
     i4.setBounds(700,80,200,200);
     add(i4);

     ImageIcon i11= new ImageIcon(ClassLoader.getSystemResource("icon/rback.png")) ;
     Image i22 = i11.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
     ImageIcon i33 = new ImageIcon(i22);
     JLabel i44 = new JLabel(i33);
     i44.setBounds(0,0,1120,630);
     add(i44);

     setSize(1000,400);
     setLayout(null);
     setLocation(300,150);
     setVisible(true);


     

     
    }
    public static void main(String[] args) {
        new removeemployee();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        if(e.getSource()==remove){
            try {
                conn c = new conn();
                String query = "delete from  employeedetail where empid ='"+choiceemp.getSelectedItem()+"' ";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "deleted successfully");
                setVisible(false);
                new showclass();

            } catch (Exception E) {
                // TODO: handle exception
                E.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new showclass();
        }
    
    }
}

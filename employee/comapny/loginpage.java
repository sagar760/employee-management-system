package employee.comapny;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class loginpage extends JFrame implements ActionListener {
      
    JTextField textfield;
    JPasswordField passwordfield;
    JButton login,back;
  

      loginpage(){


        JLabel username = new JLabel("username");
        username.setBounds(40,20,100,30);
        add(username);
        textfield = new JTextField();
        textfield.setBounds(120,20,150,30);
        add(textfield);

        JLabel upassword = new JLabel("password");
        upassword.setBounds(40,80,100,30);
        add(upassword);
        passwordfield = new JPasswordField();
        passwordfield.setBounds(120,80,150,30);
        add(passwordfield);

        login = new JButton("LOGIN");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
         
        back = new JButton("BACK");
        back.setBounds(150,180,150,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i22 = i11.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel img1 = new JLabel(i33);
        img1.setBounds(350,10,600,400);
        add(img1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/LoginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img3 = new JLabel(i3);
        img3.setBounds(0,0,600,300);
        add(img3);
    
        setSize(600 ,300);
       setLocation(400, 50);
       setLayout(getLayout());
        setVisible(true);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
          // TODO Auto-generated method stub
          if(e.getSource()==login){
            try {
              String username = textfield.getText();
              String password = passwordfield.getText();

              conn conn = new conn();
              String query = "SELECT * FROM LOGIN WHERE username ='"+username+"' and password='"+password+"'";
              ResultSet result  = conn.statement.executeQuery(query);
              if(result.next()){
                setVisible(false);
                new showclass();
              }
              else{
                JOptionPane.showMessageDialog(null, "invalid username or password");
              }
            } catch (Exception E) {
              E.printStackTrace();
            }

          }
          else if(e.getSource()==back){
            System.exit(90);
          }

          
      }
    public static void main(String[] args) {
        new loginpage();
    }
}

package employee.comapny;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class showclass extends JFrame {

    JButton exit ;
   public showclass(){

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/home.jpg"));
    Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel img = new JLabel(i3);
    img.setBounds(0,0,1120,630);
    add(img);

    JLabel heading = new JLabel("employee mangement sysstem");
    heading.setBounds(340,155,400,40);
    heading.setFont(new Font("Raleway", Font.BOLD, 25));
    img.add(heading);

    JButton add = new JButton("Add employee");
    add.setBounds(355,270,150,40);
    add.setForeground(Color.white);
    add.setBackground(Color.black);
    add.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            new addemployee();
           
        }
        
    });
    img.add(add);

    JButton remove = new JButton("remove employee");
    remove.setBounds(600,270,150,40);
    remove.setForeground(Color.white);
    remove.setBackground(Color.black);
    remove.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            setVisible(false);
           new removeemployee();
           
        }
        
    });
    img.add(remove);

    JButton view = new JButton("view employee");
    view.setBounds(450,370,150,40);
    view.setForeground(Color.white);
    view.setBackground(Color.black);
    view.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            new viewclass();
           
        }
        
    });
    img.add(view);

  exit = new JButton("EXIT");
  exit.setBounds(450,450,150,40);
  exit.setForeground(Color.white);
  exit.setBackground(Color.black);
  img.add(exit);
  exit.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        System.exit(50);
    }
    
  });


       setSize(1120,630);
       setLayout(null);
       setLocation(250, 100);
       setVisible(true);
    }
    public static void main(String[] args) {
        new showclass();
    }
}

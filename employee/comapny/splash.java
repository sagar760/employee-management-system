package employee.comapny;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class splash extends JFrame {
    splash(){
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/front.gif"));
     Image i2 = i1.getImage().getScaledInstance(1071, 680, Image.SCALE_DEFAULT);
     ImageIcon i3 = new ImageIcon(i2);
     JLabel i4 = new JLabel(i3);
     i4.setBounds(0,0,1071,680);
     add(i4);

       setSize(1071, 680);
       setLayout(null);
       setLocation(200, 50);
       setVisible(true);
       try{
        Thread.sleep(5000);
        setVisible(false);
        new loginpage();

       }
       catch(Exception e){
        e.printStackTrace();
        
       }

    }
    public static void main(String[] args) {
        new splash();
    }
}

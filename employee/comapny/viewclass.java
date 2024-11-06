package employee.comapny;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.mysql.cj.protocol.Resultset;

import net.proteanit.sql.DbUtils;

public class viewclass  extends JFrame  implements ActionListener{
    Choice choicemp;
    JTable table;
    JButton search,print,update,back;

    viewclass(){

      getContentPane().setBackground(new Color(255,131,122));

     JLabel hedaing = new JLabel(" select employee id here");
     hedaing.setBounds(20, 20, 150, 30);
     hedaing.setFont(new Font("sansserif", Font.BOLD, 13));
     add(hedaing);

   choicemp  = new Choice();
   choicemp.setBounds(180,20,150,20);
   add(choicemp);
try {
    conn c = new conn();
   ResultSet resultset = c.statement.executeQuery("select * from employeedetail");
   while(resultset.next()){
    choicemp.add(resultset.getString("empid"));
   }

} catch (Exception e) {
    // TODO: handle exception
    e.printStackTrace();
}

table = new JTable();
try {
    conn c = new conn();
    ResultSet r = c.statement.executeQuery("select * from employeedetail");
    table.setModel(DbUtils.resultSetToTableModel(r));
} catch (Exception e) {
    // TODO: handle exception
    e.printStackTrace();
}
JScrollPane scroll = new JScrollPane(table);
scroll.setBounds(0,100,900,600);
add(scroll);

search = new JButton("search");
search.setBounds(20,70,80,20);
add(search);
search.addActionListener(this);

print = new JButton("print");
print.setBounds(120,70,80,20);
add(print);
print.addActionListener(this);

update = new JButton("update");
update.setBounds(220,70,80,20);
add(update);
update.addActionListener(this);

back = new JButton("back");
back.setBounds(320,70,80,20);
add(back);
back.addActionListener(this);

       setSize(900,700);
       setLocation(300, 100);
       setLayout(null);
       setVisible(true);
    }

    public static void main(String[] args) {
        new viewclass();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==search){
            String query = "select * from employeedetail where empid ='"+choicemp.getSelectedItem()+"' ";
            try {
                conn c = new conn();
                ResultSet r = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(r));
            } catch (Exception E) {
                // TODO: handle exception
                E.printStackTrace();
            }
        }
        else if (e.getSource() == print) {
            try {
                table.print();
            } catch (Exception E) {
                // TODO: handle exception
                E.printStackTrace();
            }
        }
        else if (e.getSource() == update) {
            new updateemployee(choicemp.getSelectedItem());
            
        }
        else{
            setVisible(false);
            new showclass();
        }
        
        
       
    }
}

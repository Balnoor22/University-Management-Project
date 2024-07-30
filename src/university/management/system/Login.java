package university.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
{   
    JButton login,cancel;
    JTextField tf1;
    JPasswordField tf2;
    Login()
    {
     getContentPane().setBackground(Color.white);
     setLayout(null);
     
     JLabel lb1=new JLabel("Username");
     lb1.setBounds(40, 20, 100, 20);
     add(lb1);
     
     tf1=new JTextField();
     tf1.setBounds(150,20,150,20);
     add(tf1);
     
     JLabel lb2=new JLabel("Password");
     lb2.setBounds(40, 70, 100, 20);
     add(lb2);
     
     tf2=new JPasswordField();
     tf2.setBounds(150,70,150,20);
     add(tf2);
     
     login=new JButton("Login");
     login.setBounds(40,140,120,30);
     //bt1.setBackground(Color.gray);
     login.setFont(new Font("Tachoma",Font.BOLD,14));
     login.addActionListener(this);   //calls actionPerformed fxn
     add(login);
      
     cancel=new JButton("Cancel");
     cancel.setBounds(180,140,120,30);
     //bt1.setBackground(Color.gray);
     cancel.setFont(new Font("Tachoma",Font.BOLD,14));
     cancel.addActionListener(this);
     add(cancel);
     
     ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2=i1.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT );
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(380,15,150,150);
        add(image);
        
     setLocation(500,250);
     setSize(600,300);
     setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==login)
        {
            String username=tf1.getText();
            String password=tf2.getText();
            
            String query="select * from login where username='"+username+"'and password='"+password+"'";
            
            //Now Execute sql Query
            
        try{
                Conn c=new Conn();
               ResultSet rs= c.s.executeQuery(query);
               
               if(rs.next())
               {
                   setVisible(false);
                   new Project();
               }
               else
               {
                   JOptionPane.showMessageDialog(null,"Invalid Username or Password" );
                   setVisible(false);
               }
               c.s.close();
            }
            catch(Exception e)
            {e.printStackTrace();}
        
        }
        else if(ae.getSource()==cancel)
        {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) 
    {
         new Login();
    }
 
}

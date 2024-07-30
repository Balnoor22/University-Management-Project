package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class StudentFeeForm extends JFrame implements ActionListener
{   
    Choice crollno;
    JComboBox cbcourse,cbbranch,cbsemester;
    JLabel labeltotal;
    JButton update,pay,back;
    
    StudentFeeForm()
    {
        setSize(900,500);
        setLocation(300,100);
        setLayout(null);
        
         getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT );
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);
        
         JLabel lblrollno = new JLabel("Select Roll No.");
        lblrollno.setBounds(40, 60, 150, 20);
         lblrollno.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblrollno);

        crollno = new Choice();
        crollno.setBounds(200, 60, 150, 20);
        add(crollno);

        //gets roll no fom databse and adds to dropdown
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");

            while (rs.next()) {
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //NAME
         JLabel name=new JLabel("Name");
        name.setBounds(40,100,150,20);
        name.setFont(new Font("Tahoma",Font.BOLD,16));
        add(name);
        
        JLabel labelname=new JLabel();
        labelname.setBounds(200,100,150,20);
        labelname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelname);
        
        //FATHER NAME
        JLabel fname=new JLabel("Father's Name");
        fname.setBounds(40,140,150,20);
        fname.setFont(new Font("Tahoma",Font.BOLD,16));
        add(fname);
        
        JLabel Fname=new JLabel();
        Fname.setBounds(200,140,150,20);
        Fname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(Fname);
        
         try
        {
            Conn c=new Conn();
            String query="Select * from student where rollno='"+crollno.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                labelname.setText(rs.getString("name"));
                Fname.setText(rs.getString("father"));
                
            }
        }
        catch (Exception e)
            {
                e.printStackTrace();
            }
        
          crollno.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent ie)
            {
                try
                {
                Conn c=new Conn();
                String query="Select * from student where rollno='"+crollno.getSelectedItem()+"'";
                ResultSet rs=c.s.executeQuery(query);
                    while(rs.next())
                    {
                    labelname.setText(rs.getString("name"));
                    Fname.setText(rs.getString("father"));
                
                    }
                }
                catch (Exception e)
                     {
                         e.printStackTrace();
                     }
                }
        
        }); 
         
          //COURSE
         JLabel lbcourse=new JLabel("Course");
        lbcourse.setBounds(40,180,150,20);
        lbcourse.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lbcourse);
        
        String course[]={"BTech","BCA","Bsc","BBA","Msc","MBA","MCA","MCom","MA","BA"};
        cbcourse=new JComboBox(course);
        cbcourse.setBounds(200,180,150,20);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);
        
        //BRANCH
         JLabel lbbranch=new JLabel("Branch");
        lbbranch.setBounds(40,220,150,20);
        lbbranch.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lbbranch);
        
        String branch[]={"Computer Science","Electronics","Mechanical","Civil","IT"};
        cbbranch=new JComboBox(branch);
        cbbranch.setBounds(200,220,150,20);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);
        
          
         JLabel lblsemester = new JLabel("Semester");
        lblsemester.setBounds(40, 260, 150, 20);
        lblsemester.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblsemester);
        
        String semester[]={"Semester1","Semester2","Semester3","Semester4","Semester5","Semester6","Semester7","Semester8"};
        cbsemester =new JComboBox(semester);
        cbsemester.setBounds(200,260,150,20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);
        
         JLabel lbltotal=new JLabel("Payable Amount");
        lbltotal.setBounds(40,300,150,20);
        lbltotal.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lbltotal);
        
         labeltotal=new JLabel();
        labeltotal.setBounds(200,300,150,20);
        labeltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labeltotal);
        
          //
        update=new JButton("Update");
        update.setBounds(30,380,100,25);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        //update.setFont(new Font("Tachoma",Font.BOLD,14));
        update.addActionListener(this);   //calls actionPerformed fxn
        add(update);
        
         //
        pay=new JButton("Pay Fee");
        pay.setBounds(150,380,100,25);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.setFont(new Font("Tachoma",Font.BOLD,14));
        pay.addActionListener(this);   //calls actionPerformed fxn
        add(pay);
        
          //BACK
        back=new JButton("Back");
        back.setBounds(270,380,100,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tachoma",Font.BOLD,14));
        back.addActionListener(this);   //calls actionPerformed fxn
        add(back);
          
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==update)
        {
            String course=(String) cbcourse.getSelectedItem();
            String semester=(String) cbsemester.getSelectedItem();
            
            
            try
            {    
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery("select * from fee where course='"+course+"'");
                while(rs.next())
                {
                    labeltotal.setText(rs.getString(semester));
                }
            }
            catch (Exception e)
                     {
                     e.printStackTrace();
                     }
        }
        else if(ae.getSource()==pay)
        {
            String rollno=crollno.getSelectedItem();
            String course=(String) cbcourse.getSelectedItem();
            String semester=(String) cbsemester.getSelectedItem();
            String branch=(String) cbbranch.getSelectedItem();
            String total=labeltotal.getText();
            
            try
            {    
                Conn c=new Conn();
                
                String query="insert into collegefee values('"+rollno+"' , '"+course+"' , '"+branch+"' , '"+semester+"' , '"+total+"') ";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"University Fee Paid Successfully..");
                setVisible(false);
            }
            catch (Exception e)
                     {
                     e.printStackTrace();
                     }
        }
        
        else
        {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new StudentFeeForm();
    }

   
}

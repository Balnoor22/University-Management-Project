package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class AddTeacher extends JFrame implements ActionListener
{
    JTextField tfname,Fname,tfaddress,tfphone,tfemail,tfx,tfxii,tfaadhar;
    JLabel labelempId;
    JDateChooser jdate;
    JComboBox cbcourse,cbbranch;
    JButton submit,cancel;
    
    Random ran=new Random();
    long first4=Math.abs((ran.nextLong() % 9000L) + 1000);      //gives no.between -1 to 1 + 1000
    AddTeacher()
    {
        setSize(900,700);
        setLocation(350,50);
        
        setLayout(null);
        
        JLabel heading=new JLabel("New Teacher Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);
        
        //NAME
         JLabel name=new JLabel("Name");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);
        
        tfname=new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);
        
        //FATHER NAME
        JLabel fname=new JLabel("Father's Name");
        fname.setBounds(400,150,200,30);
        fname.setFont(new Font("serif",Font.BOLD,20));
        add(fname);
        
        Fname=new JTextField();
        Fname.setBounds(600,150,150,30);
        add(Fname);
        
        //ROLLNO
        JLabel roll=new JLabel("Employee Id");
        roll.setBounds(50,200,200,30);
        roll.setFont(new Font("serif",Font.BOLD,20));
        add(roll);
        
        labelempId=new JLabel("101"+first4);
        labelempId.setBounds(200,200,200,30);
        labelempId.setFont(new Font("serif",Font.BOLD,20));
        add(labelempId);
        
        //DOB
        JLabel dob=new JLabel("Date Of Birth");
        dob.setBounds(400,200,200,30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);
        
        jdate=new JDateChooser();
        jdate.setBounds(600,200,150,30);
        add(jdate);
        
        //ADDRESS
        JLabel lbadd=new JLabel("Address");
        lbadd.setBounds(50,250,200,30);
        lbadd.setFont(new Font("serif",Font.BOLD,20));
        add(lbadd);
        
        tfaddress=new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);
        
        //PHONE NO.
        JLabel lbp=new JLabel("Phone No.");
        lbp.setBounds(400,250,200,30);
        lbp.setFont(new Font("serif",Font.BOLD,20));
        add(lbp);
        
        tfphone=new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);
        setVisible(true);
        
        //EMAIL ID
        JLabel eid=new JLabel("Email Id");
        eid.setBounds(50,300,200,30);
        eid.setFont(new Font("serif",Font.BOLD,20));
        add(eid);
        
        tfemail=new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);
        
        //10th class
        JLabel lbx=new JLabel("Class X (%)");
        lbx.setBounds(400,300,200,30);
        lbx.setFont(new Font("serif",Font.BOLD,20));
        add(lbx);
        
        tfx=new JTextField();
        tfx.setBounds(600,300,150,30);
        add(tfx);
        
        
        //CLASS 12
         JLabel lbxii=new JLabel("Class XII (%)");
        lbxii.setBounds(50,350,200,30);
        lbxii.setFont(new Font("serif",Font.BOLD,20));
        add(lbxii);
        
        tfxii=new JTextField();
        tfxii.setBounds(200,350,150,30);
        add( tfxii);
        
        //ADHAAR
        JLabel lba=new JLabel("Aadhar Number");
        lba.setBounds(400,350,200,30);
        lba.setFont(new Font("serif",Font.BOLD,20));
        add(lba);
        
        tfaadhar=new JTextField();
        tfaadhar.setBounds(600,350,150,30);
        add(tfaadhar);
        
        //COURSE
         JLabel lbcourse=new JLabel("Qualification");
        lbcourse.setBounds(50,400,200,30);
        lbcourse.setFont(new Font("serif",Font.BOLD,20));
        add(lbcourse);
        
        String course[]={"B.Tech","BCA","Bsc","BBA","Msc","MBA","MCA","MCom","MA","BA"};
        cbcourse=new JComboBox(course);
        cbcourse.setBounds(200,400,150,30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);
        
        //BRANCH
         JLabel lbbranch=new JLabel("Department");
        lbbranch.setBounds(400,400,200,30);
        lbbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lbbranch);
        
        String branch[]={"Computer Science","Electronics","Mechanical","Civil","IT"};
        cbbranch=new JComboBox(branch);
        cbbranch.setBounds(600,400,150,30);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);
        
        //SUBMIT
        submit=new JButton("Submit");
        submit.setBounds(250,550,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tachoma",Font.BOLD,14));
        submit.addActionListener(this);   //calls actionPerformed fxn
        add(submit);
        
        //CANCEL
        cancel=new JButton("Cancel");
        cancel.setBounds(450,550,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tachoma",Font.BOLD,14));
        cancel.addActionListener(this);   //calls actionPerformed fxn
        add(cancel);
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
            String name=tfname.getText();
            String father=Fname.getText();
            String empId=labelempId.getText();
            String dob= ((JTextField) jdate.getDateEditor().getUiComponent()).getText();
            String address=tfaddress.getText();
            String phone=tfphone.getText();
            String email=tfemail.getText();
            String x=tfx.getText();
            String xii=tfxii.getText();
            String aadhar=tfaadhar.getText();
            String course=( (String) cbcourse.getSelectedItem());       //return object so convert to string
            String branch=( (String) cbbranch.getSelectedItem());       //return object so convert to string
            
            try
            {
                String query="insert into teacher values('"+name+"','"+father+"','"+empId+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+x+"','"+xii+"','"+aadhar+"','"+course+"','"+branch+"')";
                
                Conn con=new Conn();
                con.s.executeUpdate(query);     //used for DML
                
                JOptionPane.showMessageDialog(null,"Teacher Details Inserted Successfully.." );
                setVisible(false);
            }
            catch(Exception e)
            {
            e.printStackTrace();
            }
            
            
            
        }
        else
        {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) 
    {
        new AddTeacher();
    }
}

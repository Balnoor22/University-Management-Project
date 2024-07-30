package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateStudent extends JFrame implements ActionListener
{
    JTextField tfcourse,tfaddress,tfphone,tfemail,tfbranch;
    JLabel jrollno;
    JButton submit,cancel;
    Choice crollno;
    
    UpdateStudent()
    {
        setSize(900,650);
        setLocation(350,50);
        
        setLayout(null);
        
        JLabel heading=new JLabel("Update Student Details");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("Tahoma",Font.ITALIC,35));
        add(heading);
        
         JLabel lblrollno = new JLabel("Select Roll Number");
        lblrollno.setBounds(50, 100, 200, 20);
         lblrollno.setFont(new Font("serif",Font.PLAIN,20));
        add(lblrollno);

        crollno = new Choice();
        crollno.setBounds(250, 100, 200, 20);
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
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);
        
        JLabel labelname=new JLabel();
        labelname.setBounds(200,150,150,30);
        labelname.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelname);
        
        //FATHER NAME
        JLabel fname=new JLabel("Father's Name");
        fname.setBounds(400,150,200,30);
        fname.setFont(new Font("serif",Font.BOLD,20));
        add(fname);
        
        JLabel Fname=new JLabel();
        Fname.setBounds(600,150,150,30);
        Fname.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(Fname);
        
        //ROLLNO
        JLabel roll=new JLabel("Roll Number");
        roll.setBounds(50,200,200,30);
        roll.setFont(new Font("serif",Font.BOLD,20));
        add(roll);
        
        jrollno=new JLabel();
        jrollno.setBounds(200,200,200,30);
        jrollno.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(jrollno);
        
        //DOB
        JLabel dob=new JLabel("Date Of Birth");
        dob.setBounds(400,200,200,30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);
        
        JLabel labeldob=new JLabel();
        labeldob.setBounds(600,200,150,30);
        labeldob.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labeldob);
        
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
        
        JLabel labelx=new JLabel();
        labelx.setBounds(600,300,150,30);
        labelx.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelx);
        
        
        //CLASS 12
         JLabel lbxii=new JLabel("Class XII (%)");
        lbxii.setBounds(50,350,200,30);
        lbxii.setFont(new Font("serif",Font.BOLD,20));
        add(lbxii);
        
        JLabel labelxii=new JLabel();
        labelxii.setBounds(200,350,150,30);
        labelxii.setFont(new Font("Tahoma",Font.PLAIN,18));
        add( labelxii);
        
        //ADHAAR
        JLabel lba=new JLabel("Aadhar Number");
        lba.setBounds(400,350,200,30);
        lba.setFont(new Font("serif",Font.BOLD,20));
        add(lba);
        
        JLabel labelaadhar=new JLabel();
        labelaadhar.setBounds(600,350,150,30);
        labelaadhar.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelaadhar);
        
        //COURSE
         JLabel lbcourse=new JLabel("Course");
        lbcourse.setBounds(50,400,200,30);
        lbcourse.setFont(new Font("serif",Font.BOLD,20));
        add(lbcourse);
        
        tfcourse=new JTextField();
        tfcourse.setBounds(200,400,150,30);
        add(tfcourse);
        
        //BRANCH
         JLabel lbbranch=new JLabel("Branch");
        lbbranch.setBounds(400,400,200,30);
        lbbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lbbranch);
        
        
        tfbranch=new JTextField();
        tfbranch.setBounds(600,400,150,30);
        add(tfbranch);
        
        try
        {
            Conn c=new Conn();
            String query="Select * from student where rollno='"+crollno.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                labelname.setText(rs.getString("name"));
                Fname.setText(rs.getString("father"));
                labeldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                labelx.setText(rs.getString("x"));
                labelxii.setText(rs.getString("xii"));
                labelaadhar.setText(rs.getString("aadhar"));
                jrollno.setText(rs.getString("rollno"));
                tfcourse.setText(rs.getString("course"));
                tfbranch.setText(rs.getString("branch"));
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
                labeldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                labelx.setText(rs.getString("x"));
                labelxii.setText(rs.getString("xii"));
                labelaadhar.setText(rs.getString("aadhar"));
                jrollno.setText(rs.getString("rollno"));
                tfcourse.setText(rs.getString("course"));
                tfbranch.setText(rs.getString("branch"));
                }
                }
                    catch (Exception e)
                     {
                     e.printStackTrace();
                     }
                }
        
        });
        
        //SUBMIT
        submit=new JButton("Update");
        submit.setBounds(250,500,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tachoma",Font.BOLD,14));
        submit.addActionListener(this);   //calls actionPerformed fxn
        add(submit);
        
        //CANCEL
        cancel=new JButton("Cancel");
        cancel.setBounds(450,500,120,30);
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
            
            String rollno=jrollno.getText();
            String address=tfaddress.getText();
            String phone=tfphone.getText();
            String email=tfemail.getText();
            String course=( (String) tfcourse.getText());       //return object so convert to string
            String branch=( (String) tfbranch.getText());       //return object so convert to string
            
            try
            {
                String query="update student set address='"+address+"',phone='"+phone+"',email='"+email+"',course='"+course+"',branch='"+branch+"' where rollno='"+rollno+"'";
                
                Conn con=new Conn();
                con.s.executeUpdate(query);     //used for DML
                
                JOptionPane.showMessageDialog(null,"Student Details Updated Successfully.." );
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
        new UpdateStudent();
    }
}

package university.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener
{
    Project()
    {
        setSize(1545,800);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2=i1.getImage().getScaledInstance(1500, 700,Image.SCALE_DEFAULT );
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);
        
        JMenuBar mb=new JMenuBar();
        
        //New Information 
        JMenu newInformation=new JMenu("New Information");
        newInformation.setForeground(Color.BLUE);
        mb.add(newInformation);
        
        JMenuItem facultyInfo=new JMenuItem("New Faculty Information");
        //facultyInfo.setForeground(Color.white);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);
        
        JMenuItem studentInfo=new JMenuItem("New Student Information");
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo); 
        
        //Details
        JMenu details=new JMenu("View Details");
        details.setForeground(Color.RED);
        mb.add(details);
        
        JMenuItem facultyDetails=new JMenuItem("View Faculty Details");
        //facultyInfo.setForeground(Color.white);
        facultyDetails.addActionListener(this);
        details.add(facultyDetails);
        
        JMenuItem studentDetails=new JMenuItem("View Student Details");
        studentDetails.addActionListener(this);
        details.add(studentDetails);  
        
        //LEAVE
         JMenu leave=new JMenu("Apply Leave");
        leave.setForeground(Color.BLUE);
        mb.add(leave);
        
        JMenuItem facultyLeave=new JMenuItem("Faculty Leave");
        facultyLeave.addActionListener(this);
        leave.add(facultyLeave);
        
        JMenuItem studentLeave=new JMenuItem("Student Leave");
        studentLeave.addActionListener(this);
        leave.add(studentLeave);  
        
        //LEAVE DETAILS
         JMenu leaveDetails=new JMenu("Leave Details");
        leaveDetails.setForeground(Color.RED);
        mb.add(leaveDetails);
        
        JMenuItem facultyLeaveDetails=new JMenuItem("Faculty Leave Details");
        facultyLeaveDetails.addActionListener(this);
        leaveDetails.add(facultyLeaveDetails);
        
        JMenuItem studentLeaveDetails=new JMenuItem("Student Leave Details");
        studentLeaveDetails.addActionListener(this);
        leaveDetails.add(studentLeaveDetails);
        
        //EXAMS
        JMenu exams=new JMenu("Examination");
        exams.setForeground(Color.BLUE);
        mb.add(exams);
        
        JMenuItem examMarks=new JMenuItem("Examination Results");
        examMarks.addActionListener(this);
        exams.add(examMarks);
        
        JMenuItem entermarks=new JMenuItem("Enter Marks");
        entermarks.addActionListener(this);
        exams.add(entermarks);  
        
        //UPDATE DETAILS
        JMenu updateInfo=new JMenu("Update Details");
        updateInfo.setForeground(Color.RED);
        mb.add(updateInfo);
        
        JMenuItem uFaculty=new JMenuItem("Update Faculty Details");
        uFaculty.addActionListener(this);
        updateInfo.add(uFaculty);
        
        JMenuItem uStudent=new JMenuItem("Update Student Details");
        uStudent.addActionListener(this);
        updateInfo.add(uStudent);
        
        //FEES
        JMenu fee=new JMenu("Fee Details");
        fee.setForeground(Color.BLUE);
        mb.add(fee);
        
        JMenuItem feestructure=new JMenuItem("Fee Structure");
        feestructure.addActionListener(this);
        fee.add(feestructure);
        
        JMenuItem feeform=new JMenuItem("Student Fee Form");
        feeform.addActionListener(this);
        fee.add(feeform);
        
        //UTILITY
         JMenu utility=new JMenu("Utility");
        utility.setForeground(Color.RED);
        mb.add(utility);
        
        JMenuItem notepad=new JMenuItem("Notepad");
        notepad.addActionListener(this);
        utility.add(notepad);
        
        JMenuItem calc=new JMenuItem("Calculator");
        calc.addActionListener(this);
        utility.add(calc);  
        
        //ABOUT  
        JMenu about=new JMenu("About");
        about.setForeground(Color.BLUE);
        mb.add(about);
        
        JMenuItem ab=new JMenuItem("About");
        ab.addActionListener(this);
        about.add(ab);
        
        //EXIT
          JMenu exit=new JMenu("Exit");
        utility.setForeground(Color.RED);
        mb.add(exit);
        
        JMenuItem ex=new JMenuItem("Exit");
        ex.addActionListener(this);
        exit.add(ex);
        
        setJMenuBar(mb);    //set in frame
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        String msg=ae.getActionCommand();   //gives the string eg- exit
        
        if(msg.equals("Exit"))
        {
            setVisible(false);
        }
        else if(msg.equals("Calculator"))
        {
            try
            {
                Runtime.getRuntime().exec("calc.exe");
            }
            catch(Exception e){}
        }
        
        else if(msg.equals("Notepad"))
        {
            try
            {
                Runtime.getRuntime().exec("notepad.exe");
            }
            catch(Exception e){}
            
        }
    
         else if(msg.equals("New Faculty Information"))
            {    
                new AddTeacher();
            }
        
         else if(msg.equals("New Student Information"))
         {
             new AddStudent();
         }
        
        else if(msg.equals("View Faculty Details"))
        {
            new TeacherDetails();
        }
        else if(msg.equals("View Student Details"))
        {
            new StudentDetails();
        }
        
        else if(msg.equals("Faculty Leave"))
        {
            new TeacherLeave();
        }
        else if(msg.equals("Student Leave"))
        {
            new StudentLeave();
        }
        
        else if(msg.equals("Faculty Leave Details"))
        {
            new TeacherLeaveDetails();
        }
        else if(msg.equals("Student Leave Details"))
        {
            new StudentLeaveDetails();
        }
        
        else if(msg.equals( "Update Faculty Details"))
        {
            new UpdateTeacher();
        }
        else if(msg.equals( "Update Student Details"))
        {
            new UpdateStudent();
        }
        
        else if(msg.equals( "Enter Marks"))
        {
            new EnterMarks();
        }
        
          else if(msg.equals( "Examination Results"))
        {
            new ExaminationDetails();
        }
        
         else if(msg.equals( "Fee Structure"))
        {
            new FeeStructure();
        }
        
         else if(msg.equals( "About"))
        {
            new About();
        }
        
         else if(msg.equals( "Student Fee Form"))
        {
            new StudentFeeForm();
        }
        
        
        
      
    }
    
    public static void main(String[] args) 
    {
       new Project();
    }
}

package UniversityManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    Main(){

        ImageIcon i1 = new ImageIcon("src/resources/icons/third.jpg");
        Image i2 = i1.getImage().getScaledInstance(1540, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        add(img);

        JMenuBar mb = new JMenuBar();

        //new Information

        JMenu newInfo = new JMenu("New Information");
        newInfo.setForeground(Color.BLACK);
        mb.add(newInfo);

        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInfo.add(facultyInfo);

        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.WHITE);
        studentInfo.addActionListener(this);
        newInfo.add(studentInfo);

        //Details
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.BLACK);
        details.addActionListener(this);
        mb.add(details);

        JMenuItem facultydetails = new JMenuItem("View Faculty Details");
        facultydetails.setBackground(Color.WHITE);
        facultydetails.addActionListener(this);
        details.add(facultydetails);

        JMenuItem studentdetails = new JMenuItem("View Student Details");
        studentdetails.setBackground(Color.WHITE);
        studentdetails.addActionListener(this);
        details.add(studentdetails);

        //Leaves
        JMenu leaves = new JMenu("Apply Leaves");
        leaves.setForeground(Color.BLACK);
        leaves.addActionListener(this);
        mb.add(leaves);

        JMenuItem facultyleaves = new JMenuItem("Faculty Leaves");
        facultyleaves.setBackground(Color.WHITE);
        facultyleaves.addActionListener(this);
        leaves.add(facultyleaves);

        JMenuItem studentleaves = new JMenuItem("Student Leaves");
        studentleaves.setBackground(Color.WHITE);
        studentleaves.addActionListener(this);
        leaves.add(studentleaves);

        //Leave Details
        JMenu leavedetails = new JMenu("Leave Details");
        leavedetails.setForeground(Color.BLACK);
        leavedetails.addActionListener(this);
        mb.add(leavedetails);

        JMenuItem facultyleavedetails = new JMenuItem("Faculty Leave Details");
        facultyleavedetails.setBackground(Color.WHITE);
        facultyleavedetails.addActionListener(this);
        leavedetails.add(facultyleavedetails);

        JMenuItem studentleavedetails = new JMenuItem("Student Leave Details");
        studentleavedetails.setBackground(Color.WHITE);
        studentleavedetails.addActionListener(this);
        leavedetails.add(studentleavedetails);

        //Examinations
        JMenu exam = new JMenu("Examinations");
        exam.setForeground(Color.BLACK);
        exam.addActionListener(this);
        mb.add(exam);

        JMenuItem examdetails = new JMenuItem("Exam Results");
        examdetails.setBackground(Color.WHITE);
        examdetails.addActionListener(this);
        exam.add(examdetails);

        JMenuItem entermarks = new JMenuItem("Enter Marks");
        entermarks.setBackground(Color.WHITE);
        entermarks.addActionListener(this);
        exam.add(entermarks);

        //Updateinfo
        JMenu updates = new JMenu("Update Details");
        updates.setForeground(Color.BLACK);
        updates.addActionListener(this);
        mb.add(updates);

        JMenuItem updateFacultyinfo = new JMenuItem("Update Faculty Details");
        updateFacultyinfo.setBackground(Color.WHITE);
        updateFacultyinfo.addActionListener(this);
        updates.add(updateFacultyinfo);

        JMenuItem updateStudentinfo = new JMenuItem("Update Student Details");
        updateStudentinfo.setBackground(Color.WHITE);
        updateStudentinfo.addActionListener(this);
        updates.add(updateStudentinfo);
        setJMenuBar(mb);

        //fee Details
        JMenu fees = new JMenu("Accounts");
        fees.setForeground(Color.BLACK);
        fees.addActionListener(this);
        mb.add(fees);

        JMenuItem feestructure = new JMenuItem("Fees Structure");
        feestructure.setBackground(Color.WHITE);
        feestructure.addActionListener(this);
        fees.add(feestructure);

        JMenuItem feeform = new JMenuItem("Fee Form");
        feeform.setBackground(Color.WHITE);
        feeform.addActionListener(this);
        fees.add(feeform);

        //Utility
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.BLACK);
        utility.addActionListener(this);
        mb.add(utility);

        JMenuItem Calculator = new JMenuItem("Calculator");
        Calculator.setBackground(Color.WHITE);
        Calculator.addActionListener(this);
        utility.add(Calculator);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);

        //about
        JMenu about = new JMenu("About");
        about.setForeground(Color.BLACK);
        //about.addActionListener(this);
        mb.add(about);

        JMenuItem About = new JMenuItem("About Us");
        About.setForeground(Color.BLACK);
        About.addActionListener(this);
        about.add(About);

        //Exit
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.BLACK);
        mb.add(exit);

        JMenuItem Exit = new JMenuItem("Exit");
        Exit.setForeground(Color.BLACK);
        Exit.addActionListener(this);
        exit.add(Exit);

        setSize(1540, 850);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Exit")){
            System.exit(15);
        }else if (s.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch (Exception E){
                E.printStackTrace();
            }
        }else if (s.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (s.equals("New Faculty Information")) {
            new AddFaculty();
        } else if (s.equals("New Student Information")){
            new AddStudent();
        }else if (s.equals("View Faculty Details")){
            new TeacherDetails();
        }else if (s.equals("View Student Details")){
            new StudentDetails();
        }else if (s.equals("Faculty Leaves")){
            new TeacherLeave();
        }else if (s.equals("Student Leaves")){
            new StudentLeave();
        }else if (s.equals("Faculty Leave Details")){
            new TeacherLeaveDetails();
        }else if (s.equals("Student Leave Details")){
            new StudentLeaveDetails();
        }else if (s.equals("Update Faculty Details")){
            new UpdateTeacher();
        }else if (s.equals("Update Student Details")){
            new UpdateStudent();
        }else if (s.equals("Enter Marks")){
            new EnterMarks();
        }else if (s.equals("Exam Results")){
            new ExamDetails();
        }else if (s.equals("Fees Structure")){
            new FeeStructure();
        }else if (s.equals("Fee Form")){
            new StudentFeeForm();
        }else if (s.equals("About Us")){
            new About();
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}



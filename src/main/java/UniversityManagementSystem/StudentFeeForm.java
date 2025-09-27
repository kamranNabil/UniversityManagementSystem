package UniversityManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
//import java.sql.SQLException;

public class StudentFeeForm extends JFrame implements ActionListener {


    Choice rollno;
    JComboBox CourseBox, departmentBox, semesterBox;
    JLabel totalamnt;
    JButton pay,update, back;
    StudentFeeForm(){

        getContentPane().setBackground(new Color(210, 252, 251));

        ImageIcon i1 = new ImageIcon("src/resources/icons/fee.png");
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(400, 50, 500, 300);
        add(img);

        JLabel rollnumber = new JLabel("Select Roll Number");
        rollnumber.setBounds(40, 60, 150, 20);
        rollnumber.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(rollnumber);

        rollno = new Choice();
        rollno.setBounds(200, 60, 150, 20);
        add(rollno);

        try{
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("select * from student");
            while (rs.next()){
                rollno.add(rs.getString("roll"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel name = new JLabel("Name:");
        name.setBounds(40, 100, 150, 20);
        add(name);

        JLabel textname = new JLabel();
        textname.setBounds(200, 100, 150, 20);
        add(textname);

        JLabel fname = new JLabel("Father's Name:");
        fname.setBounds(40, 140, 150, 20);
        add(fname);

        JLabel textfname = new JLabel();
        textfname.setBounds(200, 140, 150, 20);
        add(textfname);

        try{
            Conn c = new Conn();
            String q = "Select * from student where roll = '"+rollno.getSelectedItem()+"'";
            ResultSet resultSet = c.statement.executeQuery(q);
            while(resultSet.next()){
                textname.setText(resultSet.getString("name"));
                textfname.setText(resultSet.getString("fname"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        rollno.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    Conn c = new Conn();
                    String q = "Select * from student where roll = '"+rollno.getSelectedItem()+"'";
                    ResultSet resultSet = c.statement.executeQuery(q);
                    while(resultSet.next()){
                        textname.setText(resultSet.getString("name"));
                        textfname.setText(resultSet.getString("fname"));
                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JLabel course = new JLabel("Course:");
        course.setBounds(40, 180, 150, 20);
        //course.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(course);

        String  Course[] = {"BTech", "MTech", "BBA" , "MBA", "BCA", "MCA", "BSc", "MSc", "BCom", "MCom", "BA", "MA"};
        CourseBox = new JComboBox(Course);
        CourseBox.setBounds(200, 180, 150, 20);
        CourseBox.setBackground(Color.WHITE);
        add(CourseBox);

        JLabel branch = new JLabel("Branch:");
        branch.setBounds(40, 220, 150, 20);
        //branch.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(branch);

        String department[] = {"Computer Science", "Electronics and Electricals", "Mechanical", "Civil", "Information and Technology"};
        departmentBox = new JComboBox(department);
        departmentBox.setBounds(200, 220, 150, 20);
        departmentBox.setBackground(Color.WHITE);
        add(departmentBox);

        JLabel sem = new JLabel("Semester");
        sem.setBounds(40, 260, 150, 20);
        add(sem);

        String semester[] = {"semester1", "semester2", "semester3", "semester4", "semester5", "semester6", "semester7", "semester8"};
        semesterBox = new JComboBox(semester);
        semesterBox.setBounds(200, 260, 150, 20);
        add(semesterBox);

        JLabel amnt = new JLabel("Total amount:");
        amnt.setBounds(40, 300, 150, 20);
        add(amnt);

        totalamnt = new JLabel();
        totalamnt.setBounds(200, 300, 150, 20);
        add(totalamnt);

        update = new JButton("Update");
        update.setBounds(30, 380, 100, 25);
        update.addActionListener(this);
        add(update);

        pay = new JButton("Pay");
        pay.setBounds(150, 380, 100, 25);
        pay.addActionListener(this);
        add(pay);

        back = new JButton("Back");
        back.setBounds(270, 380, 100, 25);
        back.addActionListener(this);
        add(back);

        setSize(900, 500);
        setLocation(300, 100);
        setLayout(null);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update) {
            String course = (String) CourseBox.getSelectedItem();
            String semester = (String) semesterBox.getSelectedItem();
            try {
                Conn c = new Conn();
                ResultSet resultSet = c.statement.executeQuery("select * from fee where course = '" + course + "'");
                while (resultSet.next()) {
                    totalamnt.setText(resultSet.getString(semester));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == pay) {  // Moved outside the 'if (e.getSource() == update)' block
            String roll = (String) rollno.getSelectedItem();  // Fixed incorrect variable usage
            String course = (String) CourseBox.getSelectedItem();
            String semester = (String) semesterBox.getSelectedItem();
            String branch = (String) departmentBox.getSelectedItem();
            String total = totalamnt.getText();

            try {
                Conn c = new Conn();
                String Q = "insert into collegefees values('" + roll + "', '" + course + "', '" + branch + "', '" + semester + "', '" + total + "')";
                c.statement.executeUpdate(Q);
                JOptionPane.showMessageDialog(null, "Fee Submitted Successfully");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {  // This is correctly placed now
            setVisible(false);
        }
    }


    public static void main(String[] args) {
        new StudentFeeForm();
    }
}

package University.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class EnterMarks extends JFrame implements ActionListener {
    Choice choicerollno;
    JComboBox comboBox;
    JTextField sub1, sub2, sub3, sub4, sub5, mark1, mark2, mark3, mark4, mark5;
    JButton submit, cancel;
    EnterMarks(){

        getContentPane().setBackground(new Color(252, 245, 210));

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(500, 40, 400, 300);
        add(img);

        JLabel heading = new JLabel("Enter marks of Student");
        heading.setBounds(50, 0, 500, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel roll = new JLabel("Select Roll number");
        roll.setBounds(50, 70, 150, 20);
        add(roll);

        choicerollno = new Choice();
        choicerollno.setBounds(200, 70, 150, 20);
        add(choicerollno);

        try{
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("Select *from student");
            while (resultSet.next()){
                choicerollno.add(resultSet.getString("roll"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel sem = new JLabel("Select Roll number");
        sem.setBounds(50, 110, 150, 20);
        add(sem);

        String semester[] = {"1st Semester", "2nd Semester", "3rd Semester", "4th Semester", "5th Semester", "6th Semester", "7th Semester", "8th Semester"};
        comboBox = new JComboBox(semester);
        comboBox.setBounds(200, 110, 150, 20);
        comboBox.setBackground(Color.WHITE);
        add(comboBox);

        JLabel entersub = new JLabel("Enter Subject");
        entersub.setBounds(90, 150, 130, 20);
        add(entersub);

        JLabel entermarks = new JLabel("Enter Marks");
        entermarks.setBounds(260, 140, 130, 40);
        add(entermarks);

        sub1 = new JTextField();
        sub1.setBounds(60, 200, 130,20);
        add(sub1);

        sub2 = new JTextField();
        sub2.setBounds(60, 230, 130,20);
        add(sub2);

        sub3 = new JTextField();
        sub3.setBounds(60, 260, 130,20);
        add(sub3);

        sub4 = new JTextField();
        sub4.setBounds(60, 290, 130,20);
        add(sub4);

        sub5 = new JTextField();
        sub5.setBounds(60, 320, 130,20);
        add(sub5);

        mark1 = new JTextField();
        mark1.setBounds(230, 200, 130,20);
        add(mark1);

        mark2 = new JTextField();
        mark2.setBounds(230, 230, 130,20);
        add(mark2);

        mark3 = new JTextField();
        mark3.setBounds(230, 260, 130,20);
        add(mark3);

        mark4 = new JTextField();
        mark4.setBounds(230, 290, 130,20);
        add(mark4);

        mark5 = new JTextField();
        mark5.setBounds(230, 320, 130,20);
        add(mark5);

        submit = new JButton("Submit");
        submit.setBounds(70, 380, 100, 30);
        submit.setBackground(new Color(119, 136, 153));
        submit.setForeground(Color.darkGray);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(240, 380, 100, 30);
        cancel.setBackground(new Color(119, 136, 153));
        cancel.setForeground(Color.darkGray);
        cancel.addActionListener(this);
        add(cancel);

        setSize(1000, 500);
        setLayout(null);
        setLocation(300, 150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){
            try{
                Conn c = new Conn();
                String q1 = "Insert into subject values('"+choicerollno.getSelectedItem()+"', " +
                                "'"+comboBox.getSelectedItem()+"', '"+sub1.getText()+"', " +
                                "'"+sub2.getText()+"', '"+sub3.getText()+"', '"+sub4.getText()+"'," +
                                "'"+sub5.getText()+"')";
                String q2 = "Insert into marks values('"+choicerollno.getSelectedItem()+"', " +
                                "'"+comboBox.getSelectedItem()+"', '"+mark1.getText()+"', " +
                                "'"+mark2.getText()+"', '"+mark3.getText()+"', '"+mark4.getText()+"'," +
                                "'"+mark5.getText()+"')";
                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                JOptionPane.showMessageDialog(null, "Marks Inserted Successfully");
                setVisible(false);
            } catch (Exception E) {
                E.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new EnterMarks();
    }
}

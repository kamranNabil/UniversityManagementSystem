package University.Management.System;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentLeave extends JFrame implements ActionListener {

    Choice choicerollno, chotime;
    JDateChooser seldate;
    JButton submit, cancel;
    StudentLeave(){

        getContentPane().setBackground(new Color(210, 232, 252));

        JLabel heading = new JLabel("Apply Student's Leave");
        heading.setBounds(40, 50, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel rollno = new JLabel("Search by Roll");
        rollno.setBounds(60, 100, 200, 30);
        rollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(rollno);

        choicerollno = new Choice();
        choicerollno.setBounds(60, 130, 200, 20);
        add(choicerollno);

        try{
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("Select * from Student");
            while(resultSet.next()){
                choicerollno.add(resultSet.getString("roll"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel date = new JLabel("Date");
        date.setBounds(60, 180, 200, 20);
        date.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(date);

        seldate = new JDateChooser();
        seldate.setBounds(60, 210, 200, 25);
        add(seldate);

        JLabel time = new JLabel("Leave For Durartion:");
        time.setBounds(60, 250, 200, 30);
        time.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(time);

        chotime = new Choice();
        chotime.setBounds(60, 290, 200, 20);
        chotime.add("Full Day");
        chotime.add("Half Day");
        add(chotime);

        submit = new JButton("Submit");
        submit.setBounds(60, 350, 100, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(200, 350, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setSize(500, 550);
        setLocation(550, 100);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit){
            String rollno = choicerollno.getSelectedItem();
            String datee = ((JTextField) seldate.getDateEditor().getUiComponent()).getText();
            String time = chotime.getSelectedItem();

            String q = "insert into studentleave values('"+rollno+"', '"+datee+"','"+time+"')";
            try{
                Conn c = new Conn();
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Leave Confirmed");
                setVisible(false);
            } catch (Exception E) {
                E.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentLeave();
    }
}

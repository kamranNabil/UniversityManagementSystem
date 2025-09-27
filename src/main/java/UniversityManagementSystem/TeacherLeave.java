package UniversityManagementSystem;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class TeacherLeave extends JFrame implements ActionListener {

    Choice choiceempid, chotime;
    JDateChooser seldate;
    JButton submit, cancel;

    TeacherLeave() {

        getContentPane().setBackground(new Color(210, 232, 252));

        JLabel heading = new JLabel("Apply Teacher's Leave");
        heading.setBounds(40, 50, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel empidLabel = new JLabel("Search by employee ID");
        empidLabel.setBounds(60, 100, 200, 30);
        empidLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(empidLabel);

        choiceempid = new Choice();
        choiceempid.setBounds(60, 130, 200, 20);
        add(choiceempid);

        // Populate employee IDs
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT empid FROM teacher");
            while (resultSet.next()) {
                choiceempid.add(resultSet.getString("empid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel dateLabel = new JLabel("Date");
        dateLabel.setBounds(60, 180, 200, 20);
        dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(dateLabel);

        seldate = new JDateChooser();
        seldate.setBounds(60, 210, 200, 25);
        add(seldate);

        JLabel timeLabel = new JLabel("Leave Duration:");
        timeLabel.setBounds(60, 250, 200, 30);
        timeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(timeLabel);

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
        if (e.getSource() == submit) {
            String empid = choiceempid.getSelectedItem();
            String date = ((JTextField) seldate.getDateEditor().getUiComponent()).getText();
            String time = chotime.getSelectedItem();

            // Fixed SQL: table name & reserved word date
            String q = "INSERT INTO teacherleaves (empid, `date`, time) VALUES ('" + empid + "', '" + date + "', '" + time + "')";

            try {
                Conn c = new Conn();
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Leave Confirmed");
                setVisible(false);
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new TeacherLeave();
    }
}

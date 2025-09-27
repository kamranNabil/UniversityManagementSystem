package UniversityManagementSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentLeaveDetails extends JFrame implements ActionListener {


    Choice choicerollno;
    JTable table;
    JButton search, cancel, print;

    StudentLeaveDetails(){
        getContentPane().setBackground(new Color(250, 172, 206));

        JLabel heading = new JLabel("Search by Roll no");
        heading.setBounds(20, 20, 150, 20);
        add(heading);

        choicerollno = new Choice();
        choicerollno.setBounds(180, 20, 150, 20);
        add(choicerollno);
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("Select * from studentleave");
            while (resultSet.next()) {
                choicerollno.add(resultSet.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();
        try{
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("Select * from studentleave");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception E){
            E.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 100, 900,  600);
        add(scrollPane);

        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);

        cancel = new JButton("Cancel");
        cancel.setBounds(120, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);

        print = new JButton("Print");
        print.setBounds(220, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        setSize(900, 700);
        setLocation(300, 100);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == search){
            String q = "select * from studentleave where rollno = '"+choicerollno.getSelectedItem()+"'";
            try{
                Conn c = new Conn();
                ResultSet resultSet = c.statement.executeQuery(q);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == print) {
            try{
                table.print();
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new StudentLeaveDetails();
    }
}

package UniversityManagementSystem;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class TeacherLeaveDetails extends JFrame implements ActionListener {

    Choice choiceempID;
    JTable table;
    JButton search, cancel, print;

    TeacherLeaveDetails() {

        getContentPane().setBackground(new Color(250, 172, 206));

        JLabel heading = new JLabel("Search by Employee Id");
        heading.setBounds(20, 20, 200, 20);
        add(heading);

        choiceempID = new Choice();
        choiceempID.setBounds(220, 20, 150, 20);
        add(choiceempID);

        // Populate employee IDs
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT DISTINCT empid FROM teacherleaves");
            while (resultSet.next()) {
                choiceempID.add(resultSet.getString("empid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Initialize table
        table = new JTable();
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT empid, `date`, time FROM teacherleaves");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception E) {
            E.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 100, 900, 600);
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

        initComponents();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {
            String q = "SELECT empid, `date`, time FROM teacherleaves WHERE empid = '" + choiceempID.getSelectedItem() + "'";
            try {
                Conn c = new Conn();
                ResultSet resultSet = c.statement.executeQuery(q);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == print) {
            try {
                table.print();
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    private void initComponents() {
        // put all Conn and JTable setup code here
    }

    public static void main(String[] args) {
        new TeacherLeaveDetails();
    }
}

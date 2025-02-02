package University.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class UpdateStudent extends JFrame implements ActionListener {

    JTextField textaddress, phnnum, Email, Numadhaar, textcourse, textbranch;
    JLabel roll;
    JButton update, cancel;
    Choice cempID;
    UpdateStudent(){
        getContentPane().setBackground(new Color(230, 210, 252));

        JLabel heading = new JLabel("Update student Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 35));
        add(heading);

        JLabel empID = new JLabel("Select roll no.:");
        empID.setBounds(50, 100, 200, 20);
        empID.setFont(new Font("serif", Font.BOLD, 20));
        add(empID);

        cempID = new Choice();
        cempID.setBounds(250, 100, 200, 20);
        add(cempID);

        try{
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from student");
            while (resultSet.next()){
                cempID.add(resultSet.getString("roll"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel name = new JLabel("Name:");
        name.setBounds(50, 150, 100, 30);
        name.setFont(new Font("serif", Font.BOLD, 20));
        add(name);

        JLabel textname = new JLabel();
        textname.setBounds(200, 150, 200, 30);
        add(textname);

        JLabel fname = new JLabel("Father's Name:");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(new Font("Serif", Font.BOLD, 20));
        add(fname);

        JLabel textfname = new JLabel();
        textfname.setBounds(550, 150, 250, 30);
        add(textfname);

        JLabel Roll =new JLabel("Roll no.:");
        Roll.setBounds(50, 200, 200, 30);
        Roll.setFont(new Font("serif", Font.BOLD, 20));
        add(Roll);

        roll = new JLabel();
        roll.setBounds(200, 200, 150, 30);
        roll.setFont(new Font("serif", Font.BOLD, 20));
        add(roll);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setBounds(400, 200, 200, 30);
        dob.setFont(new Font("serif", Font.BOLD, 20));
        add(dob);

        JLabel dob2 = new JLabel();
        dob2.setBounds(600, 200, 150, 30);
        add(dob2);

        JLabel Add = new JLabel("Address:");
        Add.setBounds(50, 250, 150, 30);
        Add.setFont(new Font("serif", Font.BOLD, 20));
        add(Add);

        textaddress = new JTextField();
        textaddress.setBounds(200, 250, 150, 30);
        textaddress.setFont(new Font("serif", Font.BOLD, 20));
        add(textaddress);

        JLabel phn = new JLabel("Phone No.:");
        phn.setBounds(400, 250, 150, 30);
        phn.setFont(new Font("serif", Font.BOLD, 20));
        add(phn);

        phnnum = new JTextField();
        phnnum.setBounds(600, 250, 150, 30);
        phnnum.setFont(new Font("serif", Font.BOLD, 20));
        add(phnnum);

        JLabel email = new JLabel("Email:");
        email.setBounds(50, 300, 100, 30);
        email.setFont(new Font("serif", Font.BOLD, 20));
        add(email);

        Email = new JTextField();
        Email.setBounds(180, 300, 200, 30);
        Email.setFont(new Font("serif", Font.BOLD, 20));
        add(Email);

        JLabel marksx = new JLabel("Class x (%):");
        marksx.setBounds(400, 300, 150, 30);
        marksx.setFont(new Font("serif", Font.BOLD, 20));
        add(marksx);

        JLabel MarksX = new JLabel();
        MarksX.setBounds(600, 300, 150, 30);
        MarksX.setFont(new Font("serif", Font.BOLD, 20));
        add(MarksX);

        JLabel my = new JLabel("Class XII (%):");
        my.setBounds(50, 350, 150, 30);
        my.setFont(new Font("serif", Font.BOLD, 20));
        add(my);

        JLabel MarksY = new JLabel();
        MarksY.setBounds(210, 350, 160, 30);
        MarksY.setFont(new Font("serif", Font.BOLD, 20));
        add(MarksY);

        JLabel adhaarNo = new JLabel("Adhaar Number:");
        adhaarNo.setBounds(400, 350, 150, 30);
        adhaarNo.setFont(new Font("serif", Font.BOLD, 20));
        add(adhaarNo);

        Numadhaar = new JTextField();
        Numadhaar.setBounds(600, 350, 150, 30);
        Numadhaar.setFont(new Font("serif", Font.BOLD, 20));
        add(Numadhaar);

        JLabel course = new JLabel("Course:");
        course.setBounds(50, 400, 150, 30);
        course.setFont(new Font("serif", Font.BOLD, 20));
        add(course);

        textcourse = new JTextField();
        textcourse.setBounds(200, 400, 150, 30);
        add(textcourse);

        JLabel branch = new JLabel("Branch:");
        branch.setBounds(400, 400, 150, 30);
        branch.setFont(new Font("serif", Font.BOLD, 20));
        add(branch);

        textbranch = new JTextField();
        textbranch.setBounds(600, 400, 150, 30);
        add(textbranch);


        try{
            Conn c = new Conn();
            String query = "select * from student where roll = '"+cempID.getSelectedItem()+"'";
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()) {
                textname.setText(resultSet.getString("name"));
                textfname.setText(resultSet.getString("fname"));
                dob2.setText(resultSet.getString("dob"));
                textaddress.setText(resultSet.getString("address"));
                phnnum.setText(resultSet.getString("Phone"));
                Email.setText(resultSet.getString("email"));
                MarksX.setText(resultSet.getString("class_x"));
                MarksY.setText(resultSet.getString("class_y"));
                Numadhaar.setText(resultSet.getString("adhaar"));
                roll.setText(resultSet.getString("Roll"));
                textcourse.setText(resultSet.getString("course"));
                textbranch.setText(resultSet.getString("branch"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        cempID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    Conn c = new Conn();
                    String query = "select * from student where roll = '"+cempID.getSelectedItem()+"'";
                    ResultSet resultSet = c.statement.executeQuery(query);
                    while (resultSet.next()) {
                        textname.setText(resultSet.getString("name"));
                        textfname.setText(resultSet.getString("fname"));
                        dob2.setText(resultSet.getString("dob"));
                        textaddress.setText(resultSet.getString("address"));
                        phnnum.setText(resultSet.getString("Phone"));
                        Email.setText(resultSet.getString("email"));
                        MarksX.setText(resultSet.getString("class_x"));
                        MarksY.setText(resultSet.getString("class_y"));
                        Numadhaar.setText(resultSet.getString("adhaar"));
                        roll.setText(resultSet.getString("Roll"));
                        textcourse.setText(resultSet.getString("course"));
                        textbranch.setText(resultSet.getString("branch"));
                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        update = new JButton("Update");
        update.setBounds(250, 500, 120, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 500, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900, 700);
        setLocation(350, 50);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update){
            String empID = roll.getText();
            String address = textaddress.getText();
            String phn = phnnum.getText();
            String email = Email.getText();
            String course = textcourse.getText();
            String branch = textbranch.getText();

            try{
                String q = "Update student set address = '"+address+"', phone = '"+phn+"', " +
                        "email = '"+email+"', course = '"+course+"', branch = '"+branch+"' " +
                        "where roll = '"+empID+"'";
                Conn c = new Conn();
                c.statement.executeUpdate(q);

                JOptionPane.showMessageDialog(null, "Details Updated");
                setVisible(false);
            } catch (Exception E) {
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateStudent();
    }
}

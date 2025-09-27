package UniversityManagementSystem;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddFaculty extends JFrame implements ActionListener {

    JTextField textname, textfname, textadd, phnnum, mailadd, MarksX, MarksY, Numadhaar;
    JLabel emptext;
    JDateChooser cdob;
    JComboBox CourseBox, departmentBox;
    JButton submit, cancel;
    Random ran = new Random();
    long f4 = Math.abs((ran.nextLong() % 9000L) + 1000l);
    AddFaculty(){

        getContentPane().setBackground(new Color(166, 164, 252));

        JLabel heading = new JLabel("New teacher Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        JLabel name = new JLabel("Name:");
        name.setBounds(50, 150, 100, 30);
        name.setFont(new Font("serif", Font.BOLD, 20));
        add(name);

        textname = new JTextField();
        textname.setBounds(150, 150, 200, 30);
        add(textname);

        JLabel fname = new JLabel("Father's Name:");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(new Font("Serif", Font.BOLD, 20));
        add(fname);

        textfname = new JTextField();
        textfname.setBounds(550, 150, 250, 30);
        add(textfname);

        JLabel empID =new JLabel("Employee ID:");
        empID.setBounds(50, 200, 200, 30);
        empID.setFont(new Font("serif", Font.BOLD, 20));
        add(empID);

        emptext = new JLabel("" + f4);
        emptext.setBounds(200, 200, 150, 30);
        emptext.setFont(new Font("serif", Font.BOLD, 20));
        add(emptext);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setBounds(400, 200, 200, 30);
        dob.setFont(new Font("serif", Font.BOLD, 20));
        add(dob);

        cdob = new JDateChooser();
        cdob.setBounds(550, 200, 150, 30);
        add(cdob);

        JLabel address = new JLabel("Address:");
        address.setBounds(50, 250, 200, 30);
        address.setFont(new Font("serif", Font.BOLD, 20));
        add(address);

        textadd = new JTextField();
        textadd.setBounds(150, 250, 200, 30);
        textadd.setFont(new Font("serif", Font.BOLD, 20));
        add(textadd);

        JLabel phn = new JLabel("Phone No.");
        phn.setBounds(400, 250, 150, 30);
        phn.setFont(new Font("serif", Font.BOLD, 20));
        add(phn);

        phnnum = new JTextField();
        phnnum.setBounds(550, 250, 150, 30);
        phnnum.setFont(new Font("serif", Font.BOLD, 20));
        add(phnnum);

        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 100, 30);
        email.setFont(new Font("serif", Font.BOLD, 20));
        add(email);

        mailadd = new JTextField();
        mailadd.setBounds(150, 300, 200, 30);
        mailadd.setFont(new Font("serif", Font.BOLD, 20));
        add(mailadd);

        JLabel marksx = new JLabel("Class x (%):");
        marksx.setBounds(400, 300, 150, 30);
        marksx.setFont(new Font("serif", Font.BOLD, 20));
        add(marksx);

        MarksX = new JTextField();
        MarksX.setBounds(550, 300, 150, 30);
        MarksX.setFont(new Font("serif", Font.BOLD, 20));
        add(MarksX);

        JLabel my = new JLabel("Class XII (%):");
        my.setBounds(50, 350, 150, 30);
        my.setFont(new Font("serif", Font.BOLD, 20));
        add(my);

        MarksY = new JTextField();
        MarksY.setBounds(190, 350, 160, 30);
        MarksY.setFont(new Font("serif", Font.BOLD, 20));
        add(MarksY);

        JLabel adhaarNo = new JLabel("Adhaar Number:");
        adhaarNo.setBounds(400, 350, 150, 30);
        adhaarNo.setFont(new Font("serif", Font.BOLD, 20));
        add(adhaarNo);

        Numadhaar = new JTextField();
        Numadhaar.setBounds(550, 350, 150, 30);
        Numadhaar.setFont(new Font("serif", Font.BOLD, 20));
        add(Numadhaar);

        JLabel qualifiation = new JLabel("Qualification:");
        qualifiation.setBounds(50, 400, 150, 30);
        qualifiation.setFont(new Font("serif", Font.BOLD, 20));
        add(qualifiation);

        String  course[] = {"B.Tech", "M.Tech", "BBA" , "MBA", "BCA", "MCA", "B.Sc", "M.Sc", "B.Com", "M.Com", "B.A", "M.A"};
        CourseBox = new JComboBox(course);
        CourseBox.setBounds(180, 400, 150, 30);
        CourseBox.setBackground(Color.WHITE);
        add(CourseBox);

        JLabel Department = new JLabel("Department:");
        Department.setBounds(400, 400, 150, 30);
        Department.setFont(new Font("serif", Font.BOLD, 20));
        add(Department);

        String department[] = {"Computer Science", "Electronics and Electricals", "Mechanical", "Civil", "Information and Technology"};
        departmentBox = new JComboBox(department);
        departmentBox.setBounds(550, 400, 250, 30);
        departmentBox.setBackground(Color.WHITE);
        add(departmentBox);


        submit = new JButton("Submit");
        submit.setBounds(250, 500, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

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
        if (e.getSource() == submit){
            String name = textname.getText();
            String fname = textfname.getText();
            String empid = emptext.getText();
            String dob = ((JTextField) cdob.getDateEditor().getUiComponent()).getText();
            String address = textadd.getText();
            String phone = phnnum.getText();
            String email = mailadd.getText();
            String X = MarksX.getText();
            String Y= MarksY.getText();
            String adhaar = Numadhaar.getText();
            String course = (String) CourseBox.getSelectedItem();
            String dept = (String) departmentBox.getSelectedItem();

            try {
                String q = "INSERT INTO teacher (name, fname, empID, dob, address, phone, email, class_X, class_XII, aadhaar, education, department) "
                        + "VALUES ('" + name + "', '" + fname + "', '" + empid + "', '" + dob + "', '" + address + "', '" + phone + "', '"
                        + email + "', '" + X + "', '" + Y + "', '" + adhaar + "', '" + course + "', '" + dept + "')";

                Conn c = new Conn();
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Details Inserted");
                setVisible(false);
            } catch (Exception E) {
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }
}

    public static void main(String[] args) {
        new AddFaculty();
    }
}

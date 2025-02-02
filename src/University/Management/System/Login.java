package University.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField textFieldName;
    JPasswordField passwordField;
    JButton Login, Back;

    Login(){

        JLabel LabelName = new JLabel("Username");
        LabelName.setBounds(40, 20, 100, 20);
        add(LabelName);

        textFieldName = new JTextField();
        textFieldName.setBounds(150, 20, 150, 20);
        add(textFieldName);

        JLabel labelpass = new JLabel("password");
        labelpass.setBounds(40, 70, 100, 20);
        add(labelpass);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 70, 150, 20);
        add(passwordField);

        Login = new JButton("Login");
        Login.setBounds(50, 140, 100, 30);
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.white);
        Login.addActionListener(this);
        add(Login);

        Back = new JButton("Back");
        Back.setBounds(180, 140, 100, 30);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.white);
        Back.addActionListener(this);
        add(Back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(350, 20, 200, 200);
        add(img);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/loginback.png"));
        Image i22 = i11.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel image = new JLabel(i33);
        image.setBounds(0, 0, 600, 300);
        add(image);

        setSize(600, 300);
        setLocation(500, 250);
        setLayout(null);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Login) {
            String username = textFieldName.getText();
            String password = new String(passwordField.getPassword());

            String query = "SELECT * FROM Login WHERE username = ? AND password = ?";
            try {
                Conn c = new Conn();
                PreparedStatement preparedStatement = c.connection.prepareStatement(query);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    setVisible(false); // login successful
                    new Main();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }


    public static void main(String[] args) {
        new Login();
    }
}

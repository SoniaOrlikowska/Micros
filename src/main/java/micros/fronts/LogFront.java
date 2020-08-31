package micros.fronts;

import micros.LoginValidation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class LogFront {

    JPanel logPanel = new JPanel();
    JLabel username = new JLabel("Login:");
    JTextField usernameField = new JTextField();
    JLabel password = new JLabel("Password:");
    JPasswordField passwordField = new JPasswordField();
    JButton cancel = new JButton("Cancel");
    JButton login = new JButton("Login");
    JLabel signIn = new JLabel("Click here to create new account");

    public String LogFront(JTextField usernameField, JPasswordField passwordField){
        this.usernameField = usernameField;
        this.passwordField = passwordField;
        String userName = username.getText();
        return userName;
        //this.passwordField = passwordField;

    }

    public LogFront() {

        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        logPanel.setLayout(gridBagLayout);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(100, 10, 0, 0);
        gridBagConstraints.weightx = 0;
        logPanel.add(username, gridBagConstraints);


        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(100, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        logPanel.add(usernameField,gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        logPanel.add(password,gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        logPanel.add(passwordField,gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        logPanel.add(cancel, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        logPanel.add(login, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(200, 95, 0, 50);
        gridBagConstraints.weightx = 1;
        logPanel.add(signIn, gridBagConstraints);
        signIn.setForeground(Color.BLUE);

        LoginValidation loginValidation = new LoginValidation(login,cancel);
        login.addActionListener(loginValidation);
        cancel.addActionListener(loginValidation);
    }

    public JButton getLogin() {
        return this.login;
    }

    public JPanel getLogUI(){ return this.logPanel; }

    public JLabel getSignIn() {
        return this.signIn;
    }

    public JTextField getUsernameField() { return this.usernameField; }

    public JPasswordField getPasswordField() { return passwordField;}

    public void setUsernameField(JTextField usernameField) { this.usernameField = usernameField;
    }

}

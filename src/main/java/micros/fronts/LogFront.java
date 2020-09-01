package micros.fronts;

import micros.DataBaseConnectivity;
import micros.LoginValidation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogFront implements ActionListener {

    JPanel logPanel = new JPanel();

    JLabel userNameLabel = new JLabel("Login:");
    JTextField usernameField = new JTextField();


    JLabel passwordLabel = new JLabel("Password:");
    JPasswordField passwordField = new JPasswordField();
    String password = passwordField.getText();

    JButton cancel = new JButton("Cancel");
    JButton login = new JButton("Login");
    JLabel signIn = new JLabel("Click here to create new account");

    public LogFront() {

        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        logPanel.setLayout(gridBagLayout);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(100, 10, 0, 0);
        gridBagConstraints.weightx = 0;
        logPanel.add(userNameLabel, gridBagConstraints);


        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(100, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        logPanel.add(usernameField, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        logPanel.add(passwordLabel, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        logPanel.add(passwordField, gridBagConstraints);

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

        // LoginValidation loginValidation = new LoginValidation(login,cancel); //todo do skonczenia jak bede wiedziala jak zrobic action listner w innej klasie
        //login.addActionListener(loginValidation);
        //cancel.addActionListener(loginValidation);
        login.addActionListener(this);
        cancel.addActionListener(this);

    }

    public JButton getLogin() {
        return this.login;
    }

    public JPanel getLogUI() {
        return this.logPanel;
    }

    public JLabel getSignIn() {
        return this.signIn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == login && usernameField != null){
            //todo check if this username exists in database
            try{
                String queryString = "SELECT * from userData WHERE USERNAME = ?";
                PreparedStatement preparedStatementstatement = DataBaseConnectivity.getConnection()
                        .prepareStatement(queryString);
                preparedStatementstatement.setString(1, usernameField.getText());
                ResultSet resultSet = preparedStatementstatement.executeQuery();

                if (resultSet.next()) {
                    System.out.println("success: u can log in");
                } else {
                    System.out.println("no such user name in database");
                }
            }
          catch (SQLException | ClassNotFoundException ex) {

              ex.printStackTrace();
            }

        }
        if(source == cancel){
            System.out.println("Cancel");
        }
    }
}

package micros.fronts;

import micros.DataBaseConnectivity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class SignFront {

    JPanel signPanel = new JPanel();

    JLabel userName = new JLabel("Username: ");
    JLabel pass = new JLabel("Password: ");
    JLabel passValid = new JLabel("Repeat Password: ");
    JLabel email = new JLabel("E-mail: ");

    JTextField userNameField = new JTextField();
    JPasswordField passField = new JPasswordField();
    JPasswordField pasValField = new JPasswordField();
    JTextField emailField = new JTextField();

    JButton submitSign = new JButton("Submit");
    JButton clearSubmit = new JButton("Clear All");


//todo musi sprawdzac:
// 1.czy nie ma juz uzytkownika o takiej nazwie,
// 2.czy haslo ma odpowiednie parametry,
// 3.czy hasla sa takie same,
// 4.czy mail ma poprawny format
    // napisac ładne metody zeby mozna bylo wiedziec co jest co


    public SignFront() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        signPanel.setLayout(gridBagLayout);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        signPanel.add(userName, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        signPanel.add(userNameField, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        signPanel.add(pass, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        signPanel.add(passField, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        signPanel.add(passValid, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        signPanel.add(pasValField, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        signPanel.add(email, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        signPanel.add(emailField, gridBagConstraints);


        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        signPanel.add(clearSubmit, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        signPanel.add(submitSign, gridBagConstraints);


        ActionListener signListner = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submitSign) {
                    System.out.println("signbutton Lister");

                    try {

                        PreparedStatement pstatement = DataBaseConnectivity.getConnection().prepareStatement("insert into userData ( USERNAME, PASSWRD, CONFIRMPASSWRD, EMAIL) values(?,?,?,?)"); //todo user id
                        //Specifying the values of it's parameter
                        pstatement.setString(1, userNameField.getText());
                        pstatement.setString(2, passField.getText());
                        pstatement.setString(3, pasValField.getText());
                        pstatement.setString(4, emailField.getText());

                        System.out.println("INSERT");


                        //Checking for the Password match
                        if (passField.getText().equalsIgnoreCase(pasValField.getText())) {
                            //Executing query
                            pstatement.execute();
                            // statement.execute("insert into userData ( USERNAME, PASSWRD, CONFIRMPASSWRD, EMAIL) VALUES ('" + userNameField.getText() + "', 'bes', 'css', 'dss');");
                            JOptionPane.showMessageDialog(null, "Data Registered Successfully");
                        } else {
                            JOptionPane.showMessageDialog(null, "password did not match");
                        }

                    } catch (SQLException | ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }

                    if (e.getSource() == clearSubmit) {

                        //todo nie umiem tego zrobić na getterach żeby działało

                        userNameField.setText("");
                        passField.setText("");
                        pasValField.setText("");
                        emailField.setText("");
                    }
                }

            }
        };

        submitSign.addActionListener(signListner);
        clearSubmit.addActionListener(signListner);

    }
        public JPanel getSignPanel() {
            return signPanel;
        }

}


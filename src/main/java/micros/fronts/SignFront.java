package micros.fronts;


import micros.SignFrontButtonsActionListeners;

import javax.swing.*;
import java.awt.*;

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

        addListeners();

    }
     public void addListeners(){

        submitSign.addActionListener(new SignFrontButtonsActionListeners.SubmitButtonActionListener());
        clearSubmit.addActionListener(new SignFrontButtonsActionListeners.ClearAllButtonActionListener());
    }


    public JPanel getSignPanel() {
        return signPanel;
    }

    public JPasswordField getPassField() {
        return passField;
    }

    public JPasswordField getPasValField() {
        return pasValField;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JTextField getUserNameField() {
        return userNameField;
    }

}


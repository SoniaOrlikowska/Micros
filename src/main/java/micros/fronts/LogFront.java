package micros.fronts;

import micros.CardsLayout;
import micros.LogFrontButtonsActionListeners;

import javax.swing.*;
import java.awt.*;

public class LogFront {

    JPanel logPanel = new JPanel();

    JLabel userNameLabel = new JLabel("Login:    ");
    JTextField usernameField = new JTextField();

    JLabel passwordLabel = new JLabel("Password:");
    JPasswordField passwordField = new JPasswordField();

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
        gridBagConstraints.insets = new Insets(10, 20, 0, 0);
        gridBagConstraints.weightx = 1;
        logPanel.add(cancel, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(10, 20, 0, 10);
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


        addActionListeners();

    }

    private void addActionListeners() {

        login.addActionListener(new LogFrontButtonsActionListeners.LoginButtonActionListener());
        cancel.addActionListener(new LogFrontButtonsActionListeners.CancelButtonActionListener());
    }



    public JPanel getLogUI() {
        return this.logPanel;
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public JPasswordField getPasswordField() { return passwordField; }

    public JLabel getSignIn() {
        return this.signIn;
    }


}

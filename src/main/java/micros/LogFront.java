package micros;

import javax.swing.*;
import java.awt.*;

public class LogFront {

    JPanel logPanel = new JPanel();
    JLabel username = new JLabel("Login");
    JTextField usernameField = new JTextField();
    JLabel password = new JLabel("Password");
    JPasswordField passwordField = new JPasswordField();
    JButton cancel = new JButton("Cancel");
    JButton login = new JButton("Login");
    JLabel signIn = new JLabel("Click hear to create new account");

    public LogFront() {

        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        logPanel.setLayout(gridBagLayout);


        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        logPanel.add(username, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        logPanel.add(usernameField,gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        logPanel.add(password,gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        logPanel.add(passwordField,gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        logPanel.add(cancel, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        logPanel.add(login, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        logPanel.add(signIn, gridBagConstraints);

    }

    public JButton getLogin() {
        return login;
    }

    public JPanel getLogUI(){
        return logPanel;

    }
}

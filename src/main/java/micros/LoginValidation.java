package micros;

import micros.fronts.LogFront;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginValidation implements ActionListener {

    LogFront logFront = new LogFront();
    String userName = logFront.getUsernameField().getText();
    String userPassword = logFront.getPasswordField().getText();

    JButton loginButton;
    JButton cancelButton;

    public LoginValidation(JButton loginButton, JButton cancelButton){

        this.loginButton = loginButton;
        this.cancelButton = cancelButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if( this.loginButton == e.getSource()){
            System.out.println(userName);
        }
        if(this.cancelButton == e.getSource()){
            System.out.println(userPassword);
        }
    }
}

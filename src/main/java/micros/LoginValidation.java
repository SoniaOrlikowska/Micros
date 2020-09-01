package micros;

import micros.fronts.LogFront;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginValidation implements ActionListener {

    //todo zagadka jest jak przekazac zawartosc pol z LogFront wypelnione przez uzytkownika
    //chwilowo porzucam ten pomysł i wrzucam ActionListner do klasy LogFront

    // String userPassword = logFront.getPasswordField().getText();

    JButton loginButton;
    JButton cancelButton;

    public LoginValidation(JButton loginButton, JButton cancelButton) {

        this.loginButton = loginButton;
        this.cancelButton = cancelButton;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.loginButton == e.getSource()) {


            System.out.println("ok:" );
        }
        if (this.cancelButton == e.getSource()) {
            System.out.println("cancel");
        }
    }
}


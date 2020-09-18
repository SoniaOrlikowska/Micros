package micros;

import micros.main.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LogFrontButtonsActionListeners {

    public static class LoginButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            CardsLayout cl = CardsLayout.getInstance(); //todo pozbyc sie wgl tutaj tego cl ono jest tylko w menu barach i w cancel ActionListnerze

            User user = new User(cl.getLogFront().getUsernameField().getText(),cl.getLogFront().getPasswordField().getText());
            PasswordHashing ph = new PasswordHashing();

            if (user.getUserName() != null && user.getUserPassword() != null) {
                try {
                    String queryString = "SELECT * from USER WHERE USERNAME  = ? AND PASSWORD = ?";

                    PreparedStatement preparedStatementstatement = DataBaseConnectivity.getConnection()
                            .prepareStatement(queryString);


                    preparedStatementstatement.setString(1, user.getUserName());
                    preparedStatementstatement.setString(2, ph.HashPassword(user.getUserPassword()));

                    ResultSet resultSet = preparedStatementstatement.executeQuery();

                    if (resultSet.next()) {
                        cl.getFrame().setJMenuBar(cl.getMicrosMenuBar());
                        cl.cardLayout.show(cl.getCont(), "3");

                    } else {
                        JOptionPane.showMessageDialog(cl.getFrame(),
                                "Incorrect Username or Password",
                                "Incorrect Username or Password",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static class CancelButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            //todo dlaczego settery usera nie dzialaja?

            CardsLayout cl = CardsLayout.getInstance();

            cl.getLogFront().getUsernameField().setText("");
            cl.getLogFront().getPasswordField().setText("");
        }
    }
}


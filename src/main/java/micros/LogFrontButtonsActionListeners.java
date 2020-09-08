package micros;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LogFrontButtonsActionListeners {

    public static class LoginButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            CardsLayout cl = CardsLayout.getInstance();
            PasswordHashing ph = new PasswordHashing();

            if (cl.getLogFront().getUsernameField() != null && cl.getLogFront().getPasswordField() != null) {
                try {
                    String queryString = "SELECT * from USER WHERE USERNAME  = ? AND PASSWORD = ?";

                    PreparedStatement preparedStatementstatement = DataBaseConnectivity.getConnection()
                            .prepareStatement(queryString);

                    preparedStatementstatement.setString(1, cl.getLogFront().getUsernameField().getText());
                    preparedStatementstatement.setString(2, ph.HashPassword(cl.getLogFront().getPasswordField().getText()));

                    ResultSet resultSet = preparedStatementstatement.executeQuery();

                    if (resultSet.next()) {
                        cl.getFrame().setJMenuBar(cl.getMenuBar1());
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

            CardsLayout cl = CardsLayout.getInstance();

            cl.getLogFront().getUsernameField().setText("");
            cl.getLogFront().getPasswordField().setText("");
        }
    }
}


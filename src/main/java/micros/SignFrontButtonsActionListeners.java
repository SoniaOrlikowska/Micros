package micros;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.apache.commons.validator.routines.EmailValidator;


public class SignFrontButtonsActionListeners {
    //todo musi sprawdzac:
    // 2.czy haslo ma odpowiednie parametry,(opcjonalnie)

    public static class SubmitButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            CardsLayout cl = CardsLayout.getInstance();
            PasswordHashing ph = new PasswordHashing();
            EmailValidator validator = EmailValidator.getInstance();

            try {
                String userName = cl.getSignFront().getUserNameField().getText();
                String password = ph.HashPassword(cl.getSignFront().getPassField().getText());
                String passValidation = ph.HashPassword(cl.getSignFront().getPasValField().getText());
                String email = cl.getSignFront().getEmailField().getText();


                String checkUserNameQueryString = "SELECT * from USER WHERE USERNAME  = ? ";
                String insertUserDataQueryStirng = "INSERT into USER ( USERNAME, PASSWORD, CONFIRM_PASSWORD, EMAIL) values(?,?,?,?)";

                PreparedStatement preparedStatement = DataBaseConnectivity.getConnection()
                        .prepareStatement(checkUserNameQueryString);

                preparedStatement.setString(1, userName);

                ResultSet resultSet = preparedStatement.executeQuery();

                //sprawdzenie czy nie ma juz takiej nazwy użytkownika w bazie
                if (!resultSet.next()) {
                    PreparedStatement preparedStatementInsert = DataBaseConnectivity.getConnection()
                            .prepareStatement(insertUserDataQueryStirng);

                    //sprawdzanie czy pola hasla sa identyczne
                    if (password.equals(passValidation) ) {
                        if(validator.isValid(email)){
                        //Executing query

                        preparedStatementInsert.setString(1, userName);
                        preparedStatementInsert.setString(2, password);
                        preparedStatementInsert.setString(3, passValidation);
                        preparedStatementInsert.setString(4, email);
                        preparedStatementInsert.execute();
                        JOptionPane.showMessageDialog(null, "Data Registered Successfully");
                        cl.getFrame().setJMenuBar(cl.getMenuBar1());
                        cl.cardLayout.show(cl.getCont(), "3");}
                        else{
                            JOptionPane.showMessageDialog(null, "incorrect email format");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "password did not match");
                    }

                } else {

                    JOptionPane.showMessageDialog(cl.getFrame(),
                            "Username already exists",
                            "Username already exists",
                            JOptionPane.ERROR_MESSAGE);

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static class ClearAllButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            CardsLayout cl = CardsLayout.getInstance();
            cl.getSignFront().getUserNameField().setText("");
            cl.getSignFront().getPassField().setText("");
            cl.getSignFront().getPasValField().setText("");
            cl.getSignFront().getEmailField().setText("");


        }
    }
}

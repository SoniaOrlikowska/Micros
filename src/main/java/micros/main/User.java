package micros.main;

import micros.listeners.CardsLayout;
import micros.DataBaseConnectivity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class User {

    private String userID;
    private String userName;
    private String userPassword;

    public User() {

    }

    public User(String userName, String userPassword) {

        this.userName = userName;
        this.userPassword = userPassword;

    }

    public String getUserID(String userName) {

        this.userName = userName;

        try {

            String findUserNameQuery = "SELECT ID_USER FROM USER WHERE USERNAME = ? ";

            PreparedStatement preparedStatement = DataBaseConnectivity.getConnection()
                    .prepareStatement(findUserNameQuery);

            preparedStatement.setString(1, userName);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                userID = resultSet.getString("ID_USER");
                System.out.println("TO jest wyik userID" + userID);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return userID;
    }


    public void forgetUser(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;

        CardsLayout cl = CardsLayout.getInstance();
        User user = new User(cl.getLogFront().getUsernameField().getText(), String.valueOf(cl.getLogFront().getPasswordField().getPassword()));

        user.setUserName("");
        user.setUserPassword("");
        cl.getLogFront().getUsernameField().setText("");
        cl.getLogFront().getPasswordField().setText("");

    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}



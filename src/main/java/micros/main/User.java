package micros.main;

import micros.CardsLayout;
import micros.DataBaseConnectivity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class User {
    private static User instance;
    private String userID;
    private String userName;
    private String userPassword;
    private int totalScore;




    public User(){

        CardsLayout cl = CardsLayout.getInstance();
        userName = cl.getLogFront().getUsernameField().getText();
        userPassword = cl.getLogFront().getPasswordField().getText();

    }


    public String getUserID (String userName){

        this.userName = userName;

        try {

            String findUserNameQuery = "SELECT ID_USER FROM USER WHERE USERNAME = ? ";

            PreparedStatement preparedStatement = DataBaseConnectivity.getConnection()
                    .prepareStatement(findUserNameQuery);

            preparedStatement.setString(1, userName);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                userID = resultSet.getString("ID_USER");
                System.out.println("TO jest wyik userID" + userID);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return userID;
    }

    public int getUserTotalScore(String userName){
        this.userName = userName;

        try{
            String findUserScore = "SELECT SUM(SCORE) FROM SCORE WHERE ID_USER = ? ";
            PreparedStatement preparedStatement = DataBaseConnectivity.getConnection()
                    .prepareStatement(findUserScore);

            preparedStatement.setString(1, userID);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                totalScore = resultSet.getInt("SUM(SCORE)");

                System.out.println("To jest total score: " + totalScore);
            }

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return totalScore;

    }


    public String getUserName() {
        return userName;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public static User getInstance() {
        if (instance == null) instance = new User();
        return instance;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}



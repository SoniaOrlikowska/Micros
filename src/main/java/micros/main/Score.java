package micros.main;

import micros.DataBaseConnectivity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Score {

    private String problemType;
    private int totalScore;
    private int typeScore;


    public Score() {

    }

    public int getUserTotalScore(int userID) {

        try {
            String findUserScore = "SELECT SUM(SCORE) FROM SCORE WHERE ID_USER = ?";
            PreparedStatement preparedStatement = DataBaseConnectivity.getConnection()
                    .prepareStatement(findUserScore);

            preparedStatement.setString(1, String.valueOf(userID));

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                totalScore = resultSet.getInt("SUM(SCORE)");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return totalScore;

    }

    public int getTypeScore(int userID, String problemType) {
        this.problemType = problemType;
        try {
            String findUserScore = "SELECT SUM(SCORE) FROM SCORE WHERE ID_USER = ? AND TYPE = ?";
            PreparedStatement preparedStatement = DataBaseConnectivity.getConnection()
                    .prepareStatement(findUserScore);

            preparedStatement.setString(1, String.valueOf(userID));
            preparedStatement.setString(2, problemType);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
               typeScore  = resultSet.getInt("SUM(SCORE)");
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return typeScore;
    }

}
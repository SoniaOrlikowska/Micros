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

    public User(){}


    public User(String userName, String userPassword){

        this.userName = userName;
        this.userPassword = userPassword;

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
        //todo
        // 1. Musi odczytac numer zadania? numer zdania = numer linii + inicjaly pliku EC, EM, EP, MC, MM, MP, HC, HM, HP
        // 2. Sprawdzać czy już to zadanie było rozwiązane przez tego użytkownika, jeśli tak to wylosować następne
        // 3. Jezeli zadanie poprawnie rozwiazane max ilosc punktow  if(easy >> 1pkt) if(medium >> 2pkt) if(hard >> 3pkt)
        // 4. Jezeli zadanie zle rozwiazanie 0 punktow
        // 5. Po wpisac wynik do bazy danych
        // 6. Sumowanie punktów na profilu użytkownika
        // 7. Ile zadań łatwych, średnich, trudnych użytkownik rozwiązał
        // 8. Całkowita liczba punktów
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

    public void forgetUser(String userName, String userPassword){
        this.userName = userName;
        this.userPassword = userPassword;

        CardsLayout cl = CardsLayout.getInstance();
        User user = new User(cl.getLogFront().getUsernameField().getText(),cl.getLogFront().getPasswordField().getText());

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
   /* public static User getInstance() {
        if (instance == null) instance = new User();
        return instance;
    }*/

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}



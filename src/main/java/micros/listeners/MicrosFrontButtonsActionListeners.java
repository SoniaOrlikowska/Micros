package micros.listeners;


import micros.DataBaseConnectivity;
import micros.ProblemGenerator;
import micros.ProblemVeryfier;
import micros.main.Score;
import micros.main.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.PreparedStatement;


public class MicrosFrontButtonsActionListeners {

    public static class GenerateButtonActionListener implements ActionListener {
        //Deklaracja wszystkich plikow
        //EasyFiles
        File easyCalki = new File("EasyCalki.txt");
        Path easyCalkiPath = Paths.get("/Users/soniaorlikowska/IdeaProjects/Micros/EasyCalki.txt");

        File easyPochodne = new File("EasyPochodne.txt");
        Path easyPochodnePath = Paths.get("/Users/soniaorlikowska/IdeaProjects/Micros/EasyPochodne.txt");

        File easyMatrix = new File("EasyMacierze.txt");
        Path easyMatrixPath = Paths.get("/Users/soniaorlikowska/IdeaProjects/Micros/EasyMacierze.txt");

        //MediumFiles
        File mediumCalki = new File("MediumCalki.txt");
        Path mediumCalkiPath = Paths.get("/Users/soniaorlikowska/IdeaProjects/Micros/MediumCalki.txt");

        File mediumPochodne = new File("MediumPochodne.txt");
        Path mediumPochodnePath = Paths.get("/Users/soniaorlikowska/IdeaProjects/Micros/MediumPochodne.txt");

        File mediumMatrix = new File("MediumMacierze.txt");
        Path mediumMatrixPath = Paths.get("/Users/soniaorlikowska/IdeaProjects/Micros/MediumMacierze.txt");

        //HardFiles
        File hardCalki = new File("HardCalki.txt");
        Path hardCalkiPath = Paths.get("/Users/soniaorlikowska/IdeaProjects/Micros/HardCalki.txt");

        File hardPochodne = new File("HardPochodne.txt");
        Path hardPochodnePath = Paths.get("/Users/soniaorlikowska/IdeaProjects/Micros/HardPochodne.txt");

        File hardMatrix = new File("HardMacierze.txt");
        Path hardMatrixPath = Paths.get("/Users/soniaorlikowska/IdeaProjects/Micros/HardMacierze.txt");

        @Override
        public void actionPerformed(ActionEvent e) {
            CardsLayout cl = CardsLayout.getInstance();

            JRadioButton easyRadio = cl.getMicrosFront().getEasyRadio();
            JRadioButton mediumRadio = cl.getMicrosFront().getMediumRadio();
            JRadioButton hardRadio = cl.getMicrosFront().getHardRadio();
            String[] dziedziny = cl.getMicrosFront().getDziedziny();
            JComboBox dziedzina = cl.getMicrosFront().getDziedzina();
            File file;
            Path path;

            //EasyCałki
            if (easyRadio.isSelected() && dziedzina.getSelectedIndex() == 0) {

                file = easyCalki;
                path = easyCalkiPath;
                new ProblemGenerator(file, path);
            }
            //EasyPochodne
            else if (easyRadio.isSelected() && dziedzina.getSelectedIndex() == 1) {
                file = easyPochodne;
                path = easyPochodnePath;
                new ProblemGenerator(file, path);
            }
            //EasyMatrix
            else if (easyRadio.isSelected() && dziedzina.getSelectedIndex() == 2) {
                file = easyMatrix;
                path = easyMatrixPath;
                new ProblemGenerator(file, path);
            }
            //MediumCałki
            else if (mediumRadio.isSelected() && dziedzina.getSelectedIndex() == 0) {
                file = mediumCalki;
                path = mediumCalkiPath;
                new ProblemGenerator(file, path);
            }
            //MediumPochodne
            else if (mediumRadio.isSelected() && dziedzina.getSelectedIndex() == 1) {
                file = mediumPochodne;
                path = mediumPochodnePath;
                new ProblemGenerator(file, path);
            }
            //MediumMatrix
            else if (mediumRadio.isSelected() && dziedzina.getSelectedIndex() == 2) {
                file = mediumMatrix;
                path = mediumMatrixPath;
                new ProblemGenerator(file, path);
            }
            //HardCałki
            else if (hardRadio.isSelected() && dziedzina.getSelectedIndex() == 0) {
                file = hardCalki;
                path = hardCalkiPath;
                new ProblemGenerator(file, path);
            }
            //HardPochodne
            else if (hardRadio.isSelected() && dziedzina.getSelectedIndex() == 1) {
                file = hardPochodne;
                path = hardPochodnePath;
                new ProblemGenerator(file, path);
            }
            //HardMatrix
            else if (hardRadio.isSelected() && dziedzina.getSelectedIndex() == 2) {
                file = hardMatrix;
                path = hardMatrixPath;
                new ProblemGenerator(file, path);
            }
        }
    }

    public static class ClearButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            CardsLayout cl = CardsLayout.getInstance();

            cl.getMicrosFront().getZadanie().setIcon(null);
            cl.getMicrosFront().getRozwiazanie().setText("");
        }
    }

    public static class CheckButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ProblemVeryfier problemVeryfier = new ProblemVeryfier();
            problemVeryfier.ProblemVeryfier();
        }
    }

    public static class SubmitButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            CardsLayout cl = CardsLayout.getInstance();
            ProblemVeryfier problemVeryfier = new ProblemVeryfier();
            problemVeryfier.ProblemVeryfier();


            try {
                if (problemVeryfier.isFlag()) {

                    //todo sprawdzac czy takie zadnie przez takiego uzytkownika bylo juz rozwiazane

                    User user = new User(cl.getLogFront().getUsernameField().getText(),cl.getLogFront().getPasswordField().getText());
                    Score scoreS = new Score();

                    String userName = user.getUserName();
                    String userID = user.getUserID(userName);
                    String problem = cl.getMicrosFront().getNumerZadania();
                    String score = cl.getMicrosFront().getScore();
                    String problemType = cl.getMicrosFront().getTypZadania();
                    System.out.println("Typ zadania to " + problemType);

                    String insertUserScoreQueryString = "INSERT into SCORE ( ID_USER, PROBLEM, SCORE, TYPE) values(?,?,?,?)";

                    PreparedStatement preparedStatement = DataBaseConnectivity.getConnection()
                            .prepareStatement(insertUserScoreQueryString);

                    preparedStatement.setInt(1, Integer.parseInt(userID));
                    preparedStatement.setInt(2, Integer.parseInt(problem));
                    preparedStatement.setInt(3, Integer.parseInt(score));
                    preparedStatement.setString(4, problemType);

                    int resultSet = preparedStatement.executeUpdate();

                    cl.getProfileFront().getUserName().setText(userName);
                    cl.getProfileFront().getUserScore().setText("You solved " + scoreS.getUserTotalScore(Integer.parseInt(userID))+ " problems");


                } else {
                    // todo komunikat, że rozwiązanie jest niepoprawne

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static class HintButtonActionListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            CardsLayout cl = CardsLayout.getInstance();
            JLabel zadanie = cl.getMicrosFront().getZadanie();
            if (zadanie.getIcon() != null) {
                JOptionPane.showMessageDialog(null, "Hint", "hint", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }
}

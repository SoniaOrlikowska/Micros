package micros.listeners;

import micros.DataBaseConnectivity;
import micros.ProblemGenerator;
import micros.ProblemVerifier;
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

/**
 * This class declares all problems source files, defines what kind of problem user chooses, and sets Action Listeners in Micros Card
 **/
public class MicrosFrontButtonsActionListeners {

    //todo how to avoid absolute paths?
    public static class GenerateButtonActionListener implements ActionListener {
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
            // String[] problemTypes = cl.getMicrosFront().getProblemTypes();
            JComboBox<String> problemTypesComboBox = cl.getMicrosFront().getProblemTypesComboBox();
            File file;
            Path path;

            //EasyCałki
            if (easyRadio.isSelected() && problemTypesComboBox.getSelectedIndex() == 0) {

                file = easyCalki;
                path = easyCalkiPath;
                new ProblemGenerator(file, path);
            }
            //EasyPochodne
            else if (easyRadio.isSelected() && problemTypesComboBox.getSelectedIndex() == 1) {
                file = easyPochodne;
                path = easyPochodnePath;
                new ProblemGenerator(file, path);
            }
            //EasyMatrix
            else if (easyRadio.isSelected() && problemTypesComboBox.getSelectedIndex() == 2) {
                file = easyMatrix;
                path = easyMatrixPath;
                new ProblemGenerator(file, path);
            }
            //MediumCałki
            else if (mediumRadio.isSelected() && problemTypesComboBox.getSelectedIndex() == 0) {
                file = mediumCalki;
                path = mediumCalkiPath;
                new ProblemGenerator(file, path);
            }
            //MediumPochodne
            else if (mediumRadio.isSelected() && problemTypesComboBox.getSelectedIndex() == 1) {
                file = mediumPochodne;
                path = mediumPochodnePath;
                new ProblemGenerator(file, path);
            }
            //MediumMatrix
            else if (mediumRadio.isSelected() && problemTypesComboBox.getSelectedIndex() == 2) {
                file = mediumMatrix;
                path = mediumMatrixPath;
                new ProblemGenerator(file, path);
            }
            //HardCałki
            else if (hardRadio.isSelected() && problemTypesComboBox.getSelectedIndex() == 0) {
                file = hardCalki;
                path = hardCalkiPath;
                new ProblemGenerator(file, path);
            }
            //HardPochodne
            else if (hardRadio.isSelected() && problemTypesComboBox.getSelectedIndex() == 1) {
                file = hardPochodne;
                path = hardPochodnePath;
                new ProblemGenerator(file, path);
            }
            //HardMatrix
            else if (hardRadio.isSelected() && problemTypesComboBox.getSelectedIndex() == 2) {
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

            cl.getMicrosFront().getProblemLabel().setIcon(null);
            cl.getMicrosFront().getYourSolution().setText("");
        }
    }

    public static class CheckButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ProblemVerifier problemVerifier = new ProblemVerifier();
            problemVerifier.ProblemVerifier();
        }
    }

    public static class SubmitButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            CardsLayout cl = CardsLayout.getInstance();
            ProblemVerifier problemVerifier = new ProblemVerifier();
            problemVerifier.ProblemVerifier();


            try {
                if (problemVerifier.isFlag()) {

                    User user = new User(cl.getLogFront().getUsernameField().getText(), String.valueOf(cl.getLogFront().getPasswordField().getPassword()));
                    Score scoreS = new Score();

                    String userName = user.getUserName();
                    String userID = user.getUserID(userName);
                    String problem = cl.getMicrosFront().getProblemNumber();
                    String score = cl.getMicrosFront().getScore();
                    String problemType = cl.getMicrosFront().getProblemLevel();

                    String insertUserScoreQueryString = "INSERT into SCORE ( ID_USER, PROBLEM, SCORE, TYPE) values(?,?,?,?)";

                    PreparedStatement preparedStatement = DataBaseConnectivity.getConnection()
                            .prepareStatement(insertUserScoreQueryString);

                    preparedStatement.setInt(1, Integer.parseInt(userID));
                    preparedStatement.setInt(2, Integer.parseInt(problem));
                    preparedStatement.setInt(3, Integer.parseInt(score));
                    preparedStatement.setString(4, problemType);

                    int resultSet = preparedStatement.executeUpdate();

                    int easyScore = scoreS.getTypeScore(Integer.parseInt(userID), "E");
                    int mediumScore = scoreS.getTypeScore(Integer.parseInt(userID), "M");
                    int hardScore = scoreS.getTypeScore(Integer.parseInt(userID), "H");

                    //todo przeniesc to do profileAction Listenera zeby bylo dodstepne zawsze a nie po kliknieciu w submit

                    cl.getProfileFront().getUserName().setText(userName);
                    cl.getProfileFront().getUserScore().setText("You solved " + scoreS.getUserTotalScore(Integer.parseInt(userID)) + " problems");
                    cl.getProfileFront().getEasyProblemsScore().setText("You solved: " + easyScore + " easy problems");
                    cl.getProfileFront().getMediumProblemsScore().setText("You solved: " + mediumScore + " medium problems");
                    cl.getProfileFront().getHardProblemsScore().setText("You solved: " + hardScore + " hard problems");
                } else {
                    JOptionPane.showMessageDialog(null, "Your solution is incorrect. Try again", "Wrong answer", JOptionPane.INFORMATION_MESSAGE);

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static class HintButtonActionListener extends MouseAdapter {

        //todo this should be added. App doesn't show hints yet
        @Override
        public void mouseClicked(MouseEvent e) {
            CardsLayout cl = CardsLayout.getInstance();
            JLabel problem = cl.getMicrosFront().getProblemLabel();
            if (problem.getIcon() != null) {
                JOptionPane.showMessageDialog(null, "Hint", "hint", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }
}

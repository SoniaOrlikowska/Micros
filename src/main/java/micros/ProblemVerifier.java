package micros;

import micros.listeners.CardsLayout;

import javax.swing.*;
/** This class veryfies if solution provided by user is correct **/

public class ProblemVerifier {
    boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    public ProblemVerifier() {

        CardsLayout cl = CardsLayout.getInstance();

        JLabel problem = cl.getMicrosFront().getProblemLabel();
        JTextArea solution = cl.getMicrosFront().getYourSolution();
        String correctAnswer = cl.getMicrosFront().getTheCorrectAnswer();
        
        ImageIcon errorIcon = new ImageIcon("/Users/soniaorlikowska/IdeaProjects/Micros/wrong.png");
        ImageIcon correctIcon = new ImageIcon("/Users/soniaorlikowska/IdeaProjects/Micros/correct.png");

        if (problem.getIcon() != null && !solution.getText().equals("")) {

            if (solution.getText().equals(correctAnswer)) {
                JOptionPane.showMessageDialog(null, "Poprawna odpowiedź", "Poprawna odpowiedź!", JOptionPane.INFORMATION_MESSAGE, correctIcon);
                flag = true;
            }
            if (problem.getIcon() != null && !solution.getText().equals(correctAnswer)) {
                JOptionPane.showMessageDialog(null, "Spróbuj jeszcze raz", "Błędna odpowiedż", JOptionPane.INFORMATION_MESSAGE, errorIcon);
                flag = false;
            }
        }

    }
}

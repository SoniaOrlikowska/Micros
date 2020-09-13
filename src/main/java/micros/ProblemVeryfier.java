package micros;

import micros.CardsLayout;

import javax.swing.*;

public class ProblemVeryfier {
    boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    public void ProblemVeryfier(){

        CardsLayout cl = CardsLayout.getInstance();

        JLabel zadanie = cl.getMicrosFront().getZadanie();
        JTextArea rozwiazanie = cl.getMicrosFront().getRozwiazanie();
        String prawidlowaOdpowiedz = cl.getMicrosFront().getPrawidlowaOdpowiedz();

        ImageIcon blednaIcon = new ImageIcon("/Users/soniaorlikowska/IdeaProjects/Micros/wrong.png");
        ImageIcon poprawnaIcon = new ImageIcon("/Users/soniaorlikowska/IdeaProjects/Micros/correct.png");

        if (zadanie.getIcon() != null && !rozwiazanie.getText().equals("")) {

            if (rozwiazanie.getText().equals(prawidlowaOdpowiedz)) {
                JOptionPane.showMessageDialog(null, "Poprawna odpowiedź", "Poprawna odpowiedź!", JOptionPane.INFORMATION_MESSAGE, poprawnaIcon);
                flag =  true;
            }
            if (zadanie.getIcon() != null && !rozwiazanie.getText().equals(prawidlowaOdpowiedz)) {
                JOptionPane.showMessageDialog(null, "Spróbuj jeszcze raz", "Błędna odpowiedż", JOptionPane.INFORMATION_MESSAGE, blednaIcon);
                flag =  false;
            }
        }

    }
}

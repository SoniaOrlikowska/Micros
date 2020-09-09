package micros;

import micros.fronts.MicrosFront;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class MicrosFrontButtonsActionListeners {

    public static class GenerateButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            CardsLayout cl = CardsLayout.getInstance();

            JRadioButton easyRadio = cl.getMicrosFront().getEasyRadio();
            JRadioButton mediumRadio = cl.getMicrosFront().getMediumRadio();
            JRadioButton hardRadio = cl.getMicrosFront().getHardRadio();
            String[] dziedziny = cl.getMicrosFront().getDziedziny();
            JComboBox dziedzina = cl.getMicrosFront().getDziedzina();


            //EasyCałki
            if (easyRadio.isSelected() && dziedzina.getSelectedIndex() == 0) cl.getMicrosFront().displayProblem();
                //EasyPochodne
            else if (easyRadio.isSelected() && dziedzina.getSelectedIndex() == 1)
                cl.getMicrosFront().displayProblem();
                //EasyMatrix
            else if (easyRadio.isSelected() && dziedzina.getSelectedIndex() == 2)
                cl.getMicrosFront().displayProblem();
                //MediumCałki
            else if (mediumRadio.isSelected() && dziedzina.getSelectedIndex() == 0)
                cl.getMicrosFront().displayProblem();
                //MediumPochodne
            else if (mediumRadio.isSelected() && dziedzina.getSelectedIndex() == 1)
                cl.getMicrosFront().displayProblem();
                //MediumMatrix
            else if (mediumRadio.isSelected() && dziedzina.getSelectedIndex() == 2)
                cl.getMicrosFront().displayProblem();
                //HardCałki
            else if (hardRadio.isSelected() && dziedzina.getSelectedIndex() == 0)
                cl.getMicrosFront().displayProblem();
                //HardPochodne
            else if (hardRadio.isSelected() && dziedzina.getSelectedIndex() == 1)
                cl.getMicrosFront().displayProblem();
                //HardMatrix
            else if (hardRadio.isSelected() && dziedzina.getSelectedIndex() == 2)
                cl.getMicrosFront().displayProblem();

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
            //CardsLayout cl = CardsLayout.getInstance();
        }
    }

    public static class SubmitButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            CardsLayout cl = CardsLayout.getInstance();

            JLabel zadanie = cl.getMicrosFront().getZadanie();
            JTextArea rozwiazanie = cl.getMicrosFront().getRozwiazanie();
            String prawidlowaOdpowiedz = cl.getMicrosFront().getPrawidlowaOdpowiedz();

            ImageIcon blednaIcon = new ImageIcon("/Users/soniaorlikowska/IdeaProjects/Micros/wrong.png");
            ImageIcon poprawnaIcon = new ImageIcon("/Users/soniaorlikowska/IdeaProjects/Micros/correct.png");

            if (zadanie != null && !rozwiazanie.getText().equals("")) {

                if (rozwiazanie.getText().equals(prawidlowaOdpowiedz)) {
                    JOptionPane.showMessageDialog(null, "Poprawna odpowiedź", "Poprawna odpowiedź!", JOptionPane.INFORMATION_MESSAGE, poprawnaIcon);
                    //todo wpisac do bazy danych nie? :)

                }
                if (zadanie.getIcon() != null && !rozwiazanie.getText().equals(prawidlowaOdpowiedz)) {
                    JOptionPane.showMessageDialog(null, "Spróbuj jeszcze raz", "Błędna odpowiedż", JOptionPane.INFORMATION_MESSAGE, blednaIcon);

                }
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

package micros.fronts;

import micros.listeners.MicrosFrontButtonsActionListeners;

import javax.swing.*;
import java.awt.*;


public class MicrosFront {
    //todo druga karta profil z liczba uzyskanych punktow(sprawdzanie czy dane zadanie nie bylo juz rozwiazane), 3 karta zadanie, no i dorobic wskazowki


    JPanel microsPanel = new JPanel();
    JLabel wybierzPoziom = new JLabel("Wybierz poziom:");
    JRadioButton easyRadio = new JRadioButton("Easy");
    JRadioButton mediumRadio = new JRadioButton("Medium");
    JRadioButton hardRadio = new JRadioButton("Hard");
    JLabel wybierzDziedzine = new JLabel("Wybierz dziedzinę:");
    String[] dziedziny = {"Całki", "Pochodne", "Macierze"};
    JComboBox dziedzina = new JComboBox(dziedziny);


    JLabel zadanie = new JLabel();
    JLabel twojeRozwiazanieLabel = new JLabel("Odpowiedź:");
    JLabel hint = new JLabel();
    JTextArea rozwiazanie = new JTextArea(3, 4);


    JButton generate = new JButton("Generate");
    JButton check = new JButton("Check");
    JButton submit = new JButton("Submit");
    JButton clear = new JButton("Clear");



    String prawidlowaOdpowiedz;                    //zmienna przechowująca wartość poprawnej odpowiedzi


    String numerZadania;
    String score;
    String typZadania;


    ImageIcon hintIcon = new ImageIcon("/Users/soniaorlikowska/IdeaProjects/Micros/hint.png");
    ImageIcon back = new ImageIcon("/Users/soniaorlikowska/IdeaProjects/Micros/back.png");
    ImageIcon woman = new ImageIcon("/Users/soniaorlikowska/IdeaProjects/Micros/woman.png");


    //Layout setup
    public MicrosFront() {

        // set panel layout and look
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        microsPanel.setLayout(gbl);
        microsPanel.setBackground(Color.white);

        // Add components to panel

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 0, 0);
        gbc.weightx = 1;
        microsPanel.add(wybierzPoziom, gbc);

        //RadioButton Easy
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 20, 0, 0);
        gbc.weightx = 1;
        microsPanel.add(easyRadio, gbc);

        //RadioButton Medium
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 10, 0, 0);
        gbc.weightx = 1;
        microsPanel.add(mediumRadio, gbc);

        //RadioButton Hard
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 20, 0, 30);
        gbc.weightx = 1;
        microsPanel.add(hardRadio, gbc);

        //Set Radio Buttons in group
        ButtonGroup radioButtonsGroup = new ButtonGroup();
        radioButtonsGroup.add(easyRadio);
        radioButtonsGroup.add(mediumRadio);
        radioButtonsGroup.add(hardRadio);

        //JLabel Dziedzina
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 10, 0, 0);
        gbc.weightx = 1;
        microsPanel.add(wybierzDziedzine, gbc);

        //JCombobox Dziedzina
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(10, 10, 0, 0);
        gbc.weightx = 1;
        microsPanel.add(dziedzina, gbc);

        //Generuj JButton
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.insets = new Insets(10, 10, 0, 20);
        gbc.weightx = 1;
        microsPanel.add(generate, gbc);

        //JLabel tresc zadania
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 4;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(15, 20, 10, 10);
        gbc.weightx = 1;
        microsPanel.add(zadanie, gbc);
        zadanie.setPreferredSize(new Dimension(100, 90));

        //JLabel rozwiązanie
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.insets = new Insets(10, 10, 0, 0);
        gbc.weightx = 1;
        microsPanel.add(twojeRozwiazanieLabel, gbc);

        //JLabel hint
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.insets = new Insets(10, 100, 5, 10);
        gbc.weightx = 1;
        microsPanel.add(hint, gbc);
        hint.setIcon(hintIcon);

        //JTextArea Rozwiązanie
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 4;
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.insets = new Insets(10, 10, 0, 10);
        gbc.weightx = 1;
        microsPanel.add(rozwiazanie, gbc);
        rozwiazanie.setBorder(BorderFactory.createEtchedBorder());

        //Clear JButton
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.insets = new Insets(10, 20, 10, 0);
        gbc.weightx = 1;
        microsPanel.add(clear, gbc);

        //JButton Sprawdz
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.insets = new Insets(10, 10, 10, 0);
        gbc.weightx = 1;
        microsPanel.add(check, gbc);

        //JButton Zapisz
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.insets = new Insets(10, 10, 10, 20);
        gbc.weightx = 1;
        microsPanel.add(submit, gbc);


        addActionListeners();

    }

    public String getNumerZadania() {
        return numerZadania;
    }

    public void setPrawidlowaOdpowiedz(String prawidlowaOdpowiedz) {
        this.prawidlowaOdpowiedz = prawidlowaOdpowiedz;
    }

    public void setNumerZadania(String numerZadania) {
        this.numerZadania = numerZadania;
    }

    public String getPrawidlowaOdpowiedz() {
        return prawidlowaOdpowiedz;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    private void addActionListeners() {

        generate.addActionListener(new MicrosFrontButtonsActionListeners.GenerateButtonActionListener());
        submit.addActionListener(new MicrosFrontButtonsActionListeners.SubmitButtonActionListener());
        check.addActionListener(new MicrosFrontButtonsActionListeners.CheckButtonActionListener());
        clear.addActionListener(new MicrosFrontButtonsActionListeners.ClearButtonActionListener());
        hint.addMouseListener(new MicrosFrontButtonsActionListeners.HintButtonActionListener());

    }

    public String getTypZadania() {
        return typZadania;
    }

    public JRadioButton getEasyRadio() {
        return easyRadio;
    }

    public JRadioButton getMediumRadio() {
        return mediumRadio;
    }

    public JRadioButton getHardRadio() {
        return hardRadio;
    }

    public JTextArea getRozwiazanie() {
        return rozwiazanie;
    }

    public JPanel getUI() {
        return microsPanel;
    }

    public JLabel getZadanie() {
        return zadanie;
    }

    public void setTypZadania(String typZadania) { this.typZadania = typZadania; }

    public JComboBox getDziedzina() {
        return dziedzina;
    }

    public String[] getDziedziny() {
        return dziedziny;
    }
}


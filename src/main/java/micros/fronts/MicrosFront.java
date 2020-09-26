package micros.fronts;

import micros.listeners.MicrosFrontButtonsActionListeners;

import javax.swing.*;
import java.awt.*;

/**
 * This class set layout for Micros Panel, and add ActionListeners to the buttons
 **/

public class MicrosFront {
    //todo sprawdzanie czy dane zadanie nie bylo juz rozwiazane), 3 karta zadanie, no i dorobic wskazowki

    JPanel microsPanel = new JPanel();
    JLabel chooseLevel = new JLabel("Wybierz poziom:");
    JRadioButton easyRadio = new JRadioButton("Easy");
    JRadioButton mediumRadio = new JRadioButton("Medium");
    JRadioButton hardRadio = new JRadioButton("Hard");
    JLabel chooseProblemType = new JLabel("Wybierz dziedzinę:");
    String[] problemTypes = {"Całki", "Pochodne", "Macierze"};
    JComboBox<String> problemTypesComboBox = new JComboBox<>(problemTypes);

    JLabel problemLabel = new JLabel();
    JLabel yourSolutionLabel = new JLabel("Odpowiedź:");
    JLabel hint = new JLabel();
    JTextArea yourSolution = new JTextArea(3, 4);

    JButton generate = new JButton("Generate");
    JButton check = new JButton("Check");
    JButton submit = new JButton("Submit");
    JButton clear = new JButton("Clear");

    String theCorrectAnswer;                    //zmienna przechowująca wartość poprawnej odpowiedzi
    String problemNumber;
    String score;
    String problemLevel;

    ImageIcon hintIcon = new ImageIcon("/Users/soniaorlikowska/IdeaProjects/Micros/hint.png");
    ImageIcon backIcon = new ImageIcon("/Users/soniaorlikowska/IdeaProjects/Micros/back.png");
    ImageIcon womanIcon = new ImageIcon("/Users/soniaorlikowska/IdeaProjects/Micros/woman.png");

    public MicrosFront() {

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        microsPanel.setLayout(gbl);
        microsPanel.setBackground(Color.white);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 0, 0);
        gbc.weightx = 1;
        microsPanel.add(chooseLevel, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 20, 0, 0);
        gbc.weightx = 1;
        microsPanel.add(easyRadio, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 10, 0, 0);
        gbc.weightx = 1;
        microsPanel.add(mediumRadio, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 20, 0, 30);
        gbc.weightx = 1;
        microsPanel.add(hardRadio, gbc);

        ButtonGroup radioButtonsGroup = new ButtonGroup();
        radioButtonsGroup.add(easyRadio);
        radioButtonsGroup.add(mediumRadio);
        radioButtonsGroup.add(hardRadio);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 10, 0, 0);
        gbc.weightx = 1;
        microsPanel.add(chooseProblemType, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(10, 10, 0, 0);
        gbc.weightx = 1;
        microsPanel.add(problemTypesComboBox, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.insets = new Insets(10, 10, 0, 20);
        gbc.weightx = 1;
        microsPanel.add(generate, gbc);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 4;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(15, 20, 10, 10);
        gbc.weightx = 1;
        microsPanel.add(problemLabel, gbc);
        problemLabel.setPreferredSize(new Dimension(100, 90));

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.insets = new Insets(10, 10, 0, 0);
        gbc.weightx = 1;
        microsPanel.add(yourSolutionLabel, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.insets = new Insets(10, 100, 5, 10);
        gbc.weightx = 1;
        microsPanel.add(hint, gbc);
        hint.setIcon(hintIcon);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 4;
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.insets = new Insets(10, 10, 0, 10);
        gbc.weightx = 1;
        microsPanel.add(yourSolution, gbc);
        yourSolution.setBorder(BorderFactory.createEtchedBorder());

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.insets = new Insets(10, 20, 10, 0);
        gbc.weightx = 1;
        microsPanel.add(clear, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.insets = new Insets(10, 10, 10, 0);
        gbc.weightx = 1;
        microsPanel.add(check, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.insets = new Insets(10, 10, 10, 20);
        gbc.weightx = 1;
        microsPanel.add(submit, gbc);

        addActionListeners();

    }

    private void addActionListeners() {

        generate.addActionListener(new MicrosFrontButtonsActionListeners.GenerateButtonActionListener());
        submit.addActionListener(new MicrosFrontButtonsActionListeners.SubmitButtonActionListener());
        check.addActionListener(new MicrosFrontButtonsActionListeners.CheckButtonActionListener());
        clear.addActionListener(new MicrosFrontButtonsActionListeners.ClearButtonActionListener());
        hint.addMouseListener(new MicrosFrontButtonsActionListeners.HintButtonActionListener());

    }

    public String getProblemNumber() {
        return problemNumber;
    }

    public void setTheCorrectAnswer(String theCorrectAnswer) {
        this.theCorrectAnswer = theCorrectAnswer;
    }

    public void setProblemNumber(String problemNumber) {
        this.problemNumber = problemNumber;
    }

    public String getTheCorrectAnswer() {
        return theCorrectAnswer;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }


    public String getProblemLevel() {
        return problemLevel;
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

    public JTextArea getYourSolution() {
        return yourSolution;
    }

    public JPanel getUI() {
        return microsPanel;
    }

    public JLabel getProblemLabel() {
        return problemLabel;
    }

    public void setProblemLevel(String problemLevel) {
        this.problemLevel = problemLevel;
    }

    public JComboBox<String> getProblemTypesComboBox() {
        return problemTypesComboBox;
    }

    public String[] getProblemTypes() {
        return problemTypes;
    }
}


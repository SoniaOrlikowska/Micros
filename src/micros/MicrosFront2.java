/*package micros;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringTokenizer;

public class MicrosFront2 implements ActionListener {

    JPanel panel = new JPanel();
    JRadioButton easyRadio = new JRadioButton("Easy");
    JRadioButton mediumRadio = new JRadioButton("Medium");
    JRadioButton hardRadio = new JRadioButton("Hard");
    String dziedziny[] = {"Całki", "Pochodne", "Macierze"};
    JComboBox dziedzina = new JComboBox(dziedziny);
    JButton generuj = new JButton("Generuj");
    JLabel zadanie = new JLabel();
    JLabel twojeRozwiazanie = new JLabel("Odpowiedź:");
    JTextArea rozwiazanie = new JTextArea();
    JButton submit = new JButton("Sprawdź");
    JButton clear = new JButton("Wyczyść");

    public MicrosFront2(){

        // set panel layout and look
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setLayout(gbl);
        panel.setBackground(Color.white);

        // add components to panel
        JLabel wybierzPoziom = new JLabel("Wybierz poziom:");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10,10,0,0);
        gbc.weightx = 1;
        panel.add(wybierzPoziom,gbc);

        //RadioButton Easy
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0,60,0,0);
        gbc.weightx = 1;
        panel.add(easyRadio,gbc);

        //RadioButton Medium
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = new Insets(0,15,0,0);
        gbc.weightx = 1;
        panel.add(mediumRadio,gbc);

        //RadioButton Hard
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.insets = new Insets(0,0,0,10);
        gbc.weightx = 1;
        panel.add(hardRadio,gbc);

        //JLabel Dziedzina
        JLabel wybierzDziedzine = new JLabel("Wybierz dziedzinę:");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10,10,0,0);
        gbc.weightx = 1;
        panel.add(wybierzDziedzine,gbc);

        //JCombobox Dziedzina
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(10,10,0,0);
        gbc.weightx = 1;
        panel.add(dziedzina,gbc);

        //Generuj JButton
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 10, 0, 10);
        gbc.weightx = 1;
        panel.add(generuj, gbc);

        // tresc zadania
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 4;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(10,20,0,10);
        gbc.weightx = 1;
        panel.add(zadanie, gbc);

        //JLabel rozwiązanie
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(10,10,0,0);
        gbc.weightx = 1;
        panel.add(twojeRozwiazanie,gbc);

        //JTextArea Rozwiązanie
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 4;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(10,10,0,10);
        gbc.weightx = 1;
        panel.add(rozwiazanie, gbc);

       //Clear JButton
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.insets = new Insets(10,10,0,0);
        gbc.weightx = 1;
        panel.add(clear,gbc);

        JButton hint = new JButton("Podpowiedź");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.insets = new Insets(10,10,0,0);
        gbc.weightx = 1;
        panel.add(hint,gbc);

        //JButton Sprawdz
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.insets = new Insets(10,10,0,0);
        gbc.weightx = 1;
        panel.add(submit,gbc);


        //Set Radio Buttons in group
        ButtonGroup radioButtonsGroup = new ButtonGroup();
        radioButtonsGroup.add(easyRadio);
        radioButtonsGroup.add(mediumRadio);
        radioButtonsGroup.add(hardRadio);

        easyRadio.addActionListener( this);
        mediumRadio.addActionListener( this);
        hardRadio.addActionListener( this);
        generuj.addActionListener(this);
        submit.addActionListener(this);


        clear.addActionListener(s -> zadanie.setText(""));
        dziedzina.addActionListener(this);

        /*Object source = e.getSource();
        if (source == clear) zadanie.setText("");*/

   /* }

    public JTextArea getRozwiazanie() {
        return rozwiazanie;
    }

    public JPanel getUI() {
        return panel;
    }


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




    File file;
    Path path;

    @Override
    public void actionPerformed(ActionEvent e)
    {



        }
        Object source = e.getSource();
        Object source2 = e.getSource();
        //EasyCałki
        if (easyRadio.isSelected() && dziedzina.getSelectedIndex() == 0  && source == generuj) {
            zadanie.setText(problemGenerator.getTrescZadania()); }
        if(rozwiazanie.getText() != null && source2 == submit) {
            String trescZadania;
            String delim = ";";
            StringTokenizer stringT = new StringTokenizer(problemGenerator.tresc, delim);
            trescZadania = stringT.nextToken();
            String trescOdpowiedzi = stringT.nextToken();
            if (rozwiazanie.getText().equals(trescOdpowiedzi)) {
                submit.setBackground(Color.GREEN);
                System.out.println("MASZ TO " + rozwiazanie.getText());
            }
            if (rozwiazanie.getText().equals(trescOdpowiedzi)) {
                System.out.println("NIE MASZ TEGO!" + rozwiazanie.getText() + "tresc odpowiedzi byla: " + trescOdpowiedzi);
            }
        }


        //EasyPochodne
        else if (easyRadio.isSelected() && dziedzina.getSelectedIndex() == 1 && source == generuj) {
            ProblemGenerator easyProblemGenerator = new ProblemGenerator(easyPochodne,easyPochodnePath);
            zadanie.setText(easyProblemGenerator.getTrescZadania());}
        //EasyMatrix
        else if (easyRadio.isSelected() && dziedzina.getSelectedIndex() == 2 && source == generuj) {
            ProblemGenerator easyProblemGenerator = new ProblemGenerator(easyMatrix,easyMatrixPath);
            zadanie.setText(easyProblemGenerator.getTrescZadania());}

        //MediumCałki
        else if (mediumRadio.isSelected() && dziedzina.getSelectedIndex() == 0  && source == generuj) {
            ProblemGenerator easyProblemGenerator = new ProblemGenerator(mediumCalki,mediumCalkiPath);
            zadanie.setText(easyProblemGenerator.getTrescZadania());}
        //MediumPochodne
        else if (mediumRadio.isSelected() && dziedzina.getSelectedIndex() == 1  && source == generuj) {
            ProblemGenerator easyProblemGenerator = new ProblemGenerator(mediumPochodne,mediumPochodnePath);
            zadanie.setText(easyProblemGenerator.getTrescZadania());}
        //MediumMatrix
        else if (mediumRadio.isSelected() && dziedzina.getSelectedIndex() == 2  && source == generuj) {
            ProblemGenerator easyProblemGenerator = new ProblemGenerator(mediumMatrix, mediumMatrixPath);
            zadanie.setText(easyProblemGenerator.getTrescZadania());}

        //HardCałki
        else if (hardRadio.isSelected() && dziedzina.getSelectedIndex() == 0  && source == generuj) {
            ProblemGenerator easyProblemGenerator = new ProblemGenerator(hardCalki,hardCalkiPath);
            zadanie.setText(easyProblemGenerator.getTrescZadania());}
        else if (hardRadio.isSelected() && dziedzina.getSelectedIndex() == 1  && source == generuj) {
            ProblemGenerator easyProblemGenerator = new ProblemGenerator(hardPochodne,hardPochodnePath);
            zadanie.setText(easyProblemGenerator.getTrescZadania());}
        else if (hardRadio.isSelected() && dziedzina.getSelectedIndex() == 2  && source == generuj) {
            ProblemGenerator easyProblemGenerator = new ProblemGenerator(hardMatrix,hardMatrixPath);
            zadanie.setText(easyProblemGenerator.getTrescZadania());}


    }
}

*/
package micros.fronts;

import micros.MicrosFrontButtonsActionListeners;
import micros.ProblemGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;

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

    JButton generuj = new JButton("Generuj");
    JLabel zadanie = new JLabel();
    JLabel twojeRozwiazanieLabel = new JLabel("Odpowiedź:");
    JLabel hint = new JLabel();
    JTextArea rozwiazanie = new JTextArea(3, 4);
    JButton submit = new JButton("Sprawdź");
    JButton save = new JButton("Zapisz wynik");
    JButton clear = new JButton("Wyczyść");

    File file;                                     //zmienna do przechowywania pliku z którego generowane jest zadanie
    Path path;                                     // zmienna przechowująca ścieżkę pliku file

    String prawidlowaOdpowiedz;                    //zmienna przechowująca wartość poprawnej odpowiedzi

    ImageIcon hintIcon = new ImageIcon("/Users/soniaorlikowska/IdeaProjects/Micros/hint.png");
    ImageIcon back = new ImageIcon("/Users/soniaorlikowska/IdeaProjects/Micros/back.png");
    ImageIcon woman = new ImageIcon("/Users/soniaorlikowska/IdeaProjects/Micros/woman.png");

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
        microsPanel.add(generuj, gbc);

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
        microsPanel.add(submit, gbc);

        //JButton Zapisz
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.insets = new Insets(10, 10, 10, 20);
        gbc.weightx = 1;
        microsPanel.add(save, gbc);


        addActionListeners();

    }

    private void addActionListeners() {
        clear.addActionListener(new MicrosFrontButtonsActionListeners.ClearButtonActionListener());
        submit.addActionListener(new MicrosFrontButtonsActionListeners.SubmitButtonActionListener());
        generuj.addActionListener(new MicrosFrontButtonsActionListeners.GenerateButtonActionListener());
        hint.addMouseListener(new MicrosFrontButtonsActionListeners.HintButtonActionListener());

    }


    //Metoda wyświetlająca zadanie do zrobienia
    public Icon displayProblem() {

        if (easyRadio.isSelected()) {
            if (dziedzina.getSelectedIndex() == 0) {
                file = easyCalki;
                path = easyCalkiPath;
            } else if (dziedzina.getSelectedIndex() == 1) {
                file = easyPochodne;
                path = easyPochodnePath;
            } else if (dziedzina.getSelectedIndex() == 2) {
                file = easyMatrix;
                path = easyMatrixPath;
            }
        } else if (mediumRadio.isSelected()) {
            if (dziedzina.getSelectedIndex() == 0) {
                file = mediumCalki;
                path = mediumCalkiPath;
            } else if (dziedzina.getSelectedIndex() == 1) {
                file = mediumPochodne;
                path = mediumPochodnePath;
            } else if (dziedzina.getSelectedIndex() == 2) {
                file = mediumMatrix;
                path = mediumMatrixPath;
            }
        } else if (hardRadio.isSelected()) {
            if (dziedzina.getSelectedIndex() == 0) {
                file = hardCalki;
                path = hardCalkiPath;
            } else if (dziedzina.getSelectedIndex() == 1) {
                file = hardPochodne;
                path = hardPochodnePath;
            } else if (dziedzina.getSelectedIndex() == 2) {
                file = hardMatrix;
                path = hardMatrixPath;
            }
        }
        ProblemGenerator problemGenerator = new ProblemGenerator(file, path);

        File file = new File("/Users/soniaorlikowska/IdeaProjects/Micros/src/main/resources/");
        File[] files = file.listFiles();
        Arrays.sort(files, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        String name = "";
        if (files != null)
            name = files[files.length - 1].getPath();
        zadanie.setIcon(new ImageIcon(name));

        deleteFiles(files);
        prawidlowaOdpowiedz = problemGenerator.trescOdpowiedzi;

        return zadanie.getIcon();
    }

    private void deleteFiles(File[] files) {
        for (File file1 : files) {

            file1.delete();
        }
    }


    //Metoda zwracająca prawidłową wartość rozwiązania

    /*public void setPrawidlowaOdpowiedz(String prawidlowaOdpowiedz) {
        this.prawidlowaOdpowiedz = prawidlowaOdpowiedz;
    }*/


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

    public String getPrawidlowaOdpowiedz() {
        return prawidlowaOdpowiedz;
    }

    public JComboBox getDziedzina() {
        return dziedzina;
    }

    public String[] getDziedziny() {
        return dziedziny;
    }
}


package micros;

import micros.listeners.CardsLayout;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class ProblemGenerator {
    //todo inaczej ponazywać te zmienne

    String tresc;
    String trescZadania;
    String trescOdpowiedzi;
    String numerZadania;
    String typZadania;
    String score;
    int linesCount;
    int wylosowaneZadanie;

    //Generator zadania

    public ProblemGenerator(File file, Path path) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            linesCount = getLinesCount(file);

            wylosowaneZadanie = (int) (Math.random() * linesCount);

            tresc = Files.readAllLines(path).get(wylosowaneZadanie);

            String delim = ";";
            StringTokenizer stringT = new StringTokenizer(tresc, delim);
            trescZadania = stringT.nextToken();         //zmienna przechowujaca tresc zadania
            trescOdpowiedzi = stringT.nextToken();      //zmienna przechowujaca tresc odpowiedzi
            numerZadania = stringT.nextToken();
            typZadania = stringT.nextToken();
            score = stringT.nextToken();
            System.out.println("PG Tresc:" + trescOdpowiedzi);

            Latex.renderLatex(trescZadania);

            reader.close();

            System.out.println("Po zamkniecou: " + trescOdpowiedzi);
            File srcFile = new File("/Users/soniaorlikowska/IdeaProjects/Micros/src/main/resources/");
            File[] files = srcFile.listFiles();
            Arrays.sort(files, new Comparator<File>() {
                @Override
                public int compare(File o1, File o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });

            String name = "";
            if (files != null)
                name = files[files.length - 1].getPath();

            CardsLayout cl = CardsLayout.getInstance();

            cl.getMicrosFront().getZadanie().setIcon(new ImageIcon(name));
            cl.getMicrosFront().setPrawidlowaOdpowiedz(trescOdpowiedzi);
            cl.getMicrosFront().setNumerZadania(numerZadania);
            cl.getMicrosFront().setTypZadania(typZadania);
            cl.getMicrosFront().setScore(score);


            for(File file1 : files) {
                file1.delete();
            }

            System.out.println("Po usunieciu " + trescOdpowiedzi);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }



    //Metoda zliczająca linijki w pliku
    public int getLinesCount(File file) throws IOException {

        InputStream is = new BufferedInputStream(new FileInputStream(file));
        try {
            byte[] c = new byte[1024]; //nie rozumiem tego
            int count = 0;
            int readChars = 0;
            boolean empty = true;

            while ((readChars = is.read(c)) != -1) {
                empty = false;
                for (int i = 0; i < readChars; i++) {
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
            }
            return (count == 0 && !empty) ? 1 : count;

        } finally {
            is.close();
        }
    }

    public String getNumerZadania() {
        return numerZadania;
    }
    public String getTrescOdpowiedzi() {
        System.out.println("w getterze" + trescOdpowiedzi);
        return trescOdpowiedzi;
    }
}

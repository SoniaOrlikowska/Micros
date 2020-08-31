package micros;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.StringTokenizer;

public class ProblemGenerator {

    public String tresc;
    public String trescZadania;
    public String trescOdpowiedzi;
    int linesCount;


    //Generator zadania
    public ProblemGenerator(File file, Path path) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            linesCount = getLinesCount(file);
            int wylosowaneZadanie = (int) (Math.random() * linesCount);
            tresc = Files.readAllLines(path).get(wylosowaneZadanie);


            String delim = ";";
            StringTokenizer stringT = new StringTokenizer(tresc, delim);

            trescZadania = stringT.nextToken();         //zmienna przechowujaca tresc zadania
            System.out.println("Zmieniłem wartość treść zadania na : " + trescZadania);
            latexGenerator();
            trescOdpowiedzi = stringT.nextToken();      //zmienna przechowujaca tresc odpowiedzi

            reader.close();

        } catch (IOException var5) {
            System.out.println(var5.getMessage());
        }
    }

    public void latexGenerator() throws IOException {
        Latex.renderLatex(trescZadania);
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
}

package micros;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.StringTokenizer;

public class ProblemGenerator {

    File easy;
    public  String tresc;
    public  String trescZadania;
    public  String trescOdpowiedzi;
    public  String odpowiedzUzytkownika;
    boolean  isequal;

    int linesCount;



    public  ProblemGenerator(File file, Path path) {
       // easy = new File("Easy.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            linesCount = getLinesCount(file);
            int wylosowaneZadanie = (int) (Math.random()*linesCount);
            tresc = Files.readAllLines(path).get(wylosowaneZadanie);

            String delim = ";";
            StringTokenizer stringT = new StringTokenizer(tresc, delim);

            trescZadania = stringT.nextToken();
            trescOdpowiedzi = stringT.nextToken();

            System.out.println("plik to: " + file + " Sciezka to : " + path);
            reader.close();


        } catch (IOException var5) {
            System.out.println(var5.getMessage());
        }
    }

    public int getLinesCount(File file) throws IOException {

        InputStream is = new BufferedInputStream(new FileInputStream(file));
        try {
            byte[] c = new byte[1024];
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

        }
         finally{is.close();}


    }

    public String getTresc() {
        return tresc;
    }

    public String getTrescZadania() {
        return trescZadania;
    }

    public String getTrescOdpowiedzi() {
        return trescOdpowiedzi;
    }
}

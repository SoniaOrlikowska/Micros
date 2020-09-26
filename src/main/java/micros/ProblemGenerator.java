package micros;

import micros.listeners.CardsLayout;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/** this class draws problem from a file and use Latex class to render it and display. Each Latex file is deleted after inserting it to the panel **/
public class ProblemGenerator {

    String problemFileText;
    String problemText;
    String answerText;
    String problemNumber;
    String problemType;
    String problemScore;
    int linesCount;
    int generatedProblemIndex;

    public ProblemGenerator(File file, Path path) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            linesCount = getLinesCount(file);

            generatedProblemIndex = (int) (Math.random() * linesCount);

            problemFileText = Files.readAllLines(path).get(generatedProblemIndex);

            String delim = ";";
            StringTokenizer stringT = new StringTokenizer(problemFileText, delim);
            problemText = stringT.nextToken();
            answerText = stringT.nextToken();
            problemNumber = stringT.nextToken();
            problemType = stringT.nextToken();
            problemScore = stringT.nextToken();

            Latex.renderLatex(problemText);

            reader.close();

            File srcFile = new File("/Users/soniaorlikowska/IdeaProjects/Micros/src/main/resources/");
            File[] files = srcFile.listFiles();

            assert files != null;
            Arrays.sort(files, Comparator.comparing(File::getName));

            String name = files[files.length - 1].getPath();

            CardsLayout cl = CardsLayout.getInstance();

            cl.getMicrosFront().getProblemLabel().setIcon(new ImageIcon(name));
            cl.getMicrosFront().setTheCorrectAnswer(answerText);
            cl.getMicrosFront().setProblemNumber(problemNumber);
            cl.getMicrosFront().setProblemLevel(problemType);
            cl.getMicrosFront().setScore(problemScore);

            for (File file1 : files) {
                file1.delete();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public int getLinesCount(File file) throws IOException {

        try (InputStream is = new BufferedInputStream(new FileInputStream(file))) {
            byte[] c = new byte[1024];
            int count = 0;
            int readChars;
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
    }

}

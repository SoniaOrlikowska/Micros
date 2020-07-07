package draftyTesty;

import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;


import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Time;
import java.time.LocalTime;


public class Latex {

    public Latex() {
    }

    public static void renderLatex(String trescZadania) throws IOException {

       // LocalTime now = LocalTime.now();
        TeXFormula formula = new TeXFormula(trescZadania);

       // FileUtils.cleanDirectory("/Users/soniaorlikowska/IdeaProjects/Micros/src/main/resources/");
        formula.createPNG(TeXConstants.STYLE_DISPLAY, 20, "/Users/soniaorlikowska/IdeaProjects/Micros/src/main/resources/Example5"+ System.currentTimeMillis() + ".png", Color.white, Color.black);
        //formula.createPNG(TeXConstants.STYLE_DISPLAY, 20, "/Users/soniaorlikowska/IdeaProjects/Micros/src/main/resources/"+ now+"Example5.png", Color.white, Color.black);

    }

}


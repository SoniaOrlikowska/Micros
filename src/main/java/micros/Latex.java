package micros;

import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;


import java.awt.*;
import java.io.IOException;

public class Latex {

    public Latex() {
    }

    public static void renderLatex(String trescZadania) throws IOException {

        TeXFormula formula = new TeXFormula(trescZadania);
        formula.createPNG(TeXConstants.STYLE_DISPLAY, 20, "/Users/soniaorlikowska/IdeaProjects/Micros/src/main/resources/Problem"+ System.currentTimeMillis() + ".png", Color.white, Color.black);

    }

}


package draftyTesty;

import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;

import java.awt.*;


public class Latex {

    public Latex() {
    }

    public static void renderLatex(String trescZadania) {
        TeXFormula formula = new TeXFormula(trescZadania);
        formula.createPNG(TeXConstants.STYLE_DISPLAY, 20, "/Users/soniaorlikowska/IdeaProjects/Micros/src/main/resources/Example5.png", Color.white, Color.black);

    }

}


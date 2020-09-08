package micros;

import javax.swing.*;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() { //todo co to jest wlasciwie? Po co mi to ?

            @Override
            public void run() {

                CardsLayout.getInstance();
            }
        });


    }
}
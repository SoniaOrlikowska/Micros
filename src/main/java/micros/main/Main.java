package micros.main;

import micros.listeners.CardsLayout;

import javax.swing.*;

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
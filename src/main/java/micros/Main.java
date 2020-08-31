package micros;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() { //co to jest wlasciwie?

            @Override
            public void run() {
                /*JFrame frame = new JFrame("Mikros");
                frame.getContentPane().add(new LogFront().getLogUI());
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);*/
                new CardsLayout().Frame();



            }
        });


    }
}
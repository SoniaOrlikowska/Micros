package draftyTesty;

import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.*;

public class CardLay {
    JFrame frame;
    CardLayout cardLayout;
    JPanel cards;
    JPanel card1;
    JPanel card2;
    JLabel label1;
    JLabel label2;
    JMenuBar menuBar1;
    JMenuBar menuBar2;
    JMenu menu1;
    JMenu menu2;
    JMenuItem menuItem1;
    JMenuItem menuItem2;
    Container container;


            Toolkit toolkit;

            public CardLay() {
                frame = new JFrame();
                frame.setTitle(getClass().getName());
                toolkit = Toolkit.getDefaultToolkit();
                frame.setLocationRelativeTo(null);
                frame.setSize(400,400);
                initialize();
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }

            private void initialize(){

            }

            public static void main(String[] args) {
                new CardLay();
            }



}
package draftyTesty;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class CardTesty {
        JFrame frame;
        Toolkit toolkit;
        CardLayout cardLayout;
        JPanel cards;
        JPanel card1;
        JPanel card2;
        JMenuBar menuBar1;
        JMenuBar menuBar2;
        JMenu menu1;
        JMenu menu2;
        JMenuItem menuItem1;
        JMenuItem menuItem2;
        Container container;


        public CardTesty() {
            frame = new JFrame();
            frame.setTitle(getClass().getName());
            frame.setSize(400, 400);
            toolkit = Toolkit.getDefaultToolkit();
            frame.setLocation(toolkit.getScreenSize().width / 2 - frame.getSize().width / 2,
                    toolkit.getScreenSize().height / 2 - frame.getSize().height / 2);
            initialize();
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }

        private void initialize() {
            container = frame.getContentPane();
            cardLayout = new CardLayout();
            cards = new JPanel(cardLayout);
            card1 = new JPanel(new BorderLayout());
            card2 = new JPanel(new BorderLayout());

            cards.add(card1, "card1");


         menuBar1 = new JMenuBar();
            menu1 = new JMenu("Menu");
            menuItem1 = new JMenuItem("Menu item1");
            menuBar1.add(menu1);
            menu1.add(menuItem1);

            card1.add(menuBar1,BorderLayout.NORTH);

            //Features

            menuBar1.add(menuItem1);

            //

            cards.add(card2, "card2");


            menuBar2 = new JMenuBar();
            menu2 = new JMenu("Menu");
            menuItem2 = new JMenuItem("Menu item2");
            menuBar2.add(menu2);
            menu2.add(menuItem2);
            card2.add(menuBar2,BorderLayout.NORTH);

            //Features

            menuBar2.add(menuItem2);

            //

            container.add(cards);
        }

        class menuItem1 implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "card2");
            }
        }

        class menu2 implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "card1");
            }
        }

        public static void main(String[] args) {
            new CardTesty();
        }
    }

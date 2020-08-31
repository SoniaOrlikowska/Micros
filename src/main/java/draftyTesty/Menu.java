package draftyTesty;
import micros.CardsLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
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
    JButton button1;
    JButton button2;

    public Menu() {

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
        //button1 = new JButton("button w card1");
        //card1.add(button1,BorderLayout.SOUTH);
        //button1.addActionListener(new ActionButton1());

        menuBar1 = new JMenuBar();
        //menu1 = new JMenu("Menu");
        menuItem1 = new JMenuItem("Menu item1");
        //menuBar1.add(menu1);
        //menu1.add(menuItem1);
        menuItem1.addActionListener(new ActionButton1());
        card1.add(menuBar1,BorderLayout.NORTH);

        //Features

        menuBar1.add(menuItem1);

        //

        cards.add(card2, "card2");
        //button2 = new JButton("buton w card2");
        //card2.add(button2,BorderLayout.SOUTH);
        //button2.addActionListener(new ActionButton2());

        menuBar2 = new JMenuBar();
        //menu2 = new JMenu("Menu");
        menuItem2 = new JMenuItem("Menu item2");
        //menuBar2.add(menu2);
        //menu2.add(menuItem2);
        menuItem2.addActionListener(new ActionButton2());
        card2.add(menuBar2,BorderLayout.NORTH);

        //Features

        menuBar2.add(menuItem2);

        //

        container.add(cards);
    }

    class ActionButton1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cardLayout.show(cards, "card2");
        }
    }

    class ActionButton2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cardLayout.show(cards, "card1");
        }
    }

    public static void main(String[] args) {
        new Menu();
    }
}
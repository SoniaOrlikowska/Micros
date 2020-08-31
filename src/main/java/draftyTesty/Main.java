package draftyTesty;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class Main {
    JFrame frame;
    Toolkit toolkit;
    JPanel cards;
    JPanel card1;
    JPanel card2;
    Container container;
    JButton button1;
    JButton button2;

    public Main() {
        frame = new JFrame();
        frame.setSize(400,400);
        toolkit = Toolkit.getDefaultToolkit();
        frame.setLocation(toolkit.getScreenSize().width/2-frame.getSize().width/2,
                toolkit.getScreenSize().height/2-frame.getSize().height/2);
        initialize();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void initialize(){
        container = frame.getContentPane();
        CardLayout cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);
        card1 = new JPanel();
        card2 = new JPanel();

        cards.add(card1,"card1");
        button1 = new JButton("buton w card1");
        card1.add(button1);
        button1.addActionListener(
                s -> cardLayout.show(cards,"card2"));

        cards.add(card2,"card2");
        button2 = new JButton("buton w card2");
        card2.add(button2);
        button2.addActionListener(
                s -> cardLayout.show(cards,"card1"));

        container.add(cards);
    }

    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }

    public static void main(String[] args) {
        new Main();
    }
}
package micros;

import micros.fronts.LogFront;
import micros.fronts.MicrosFront;
import micros.fronts.ProfileFront;
import micros.fronts.SignFront;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Ta klasa ustawia CardLayout i actionlistnery dla buttonów przechodzących między stronami
 **/

public class CardsLayout {
    private static CardsLayout instance;

    final JFrame frame = new JFrame("Mikros");
    JPanel Cont = new JPanel();

    CardLayout cardLayout = new CardLayout();

    SignFront signFront = new SignFront();
    JPanel firstSignPanel = signFront.getSignPanel();


    LogFront logFront = new LogFront();
    JPanel secondLogPanel = logFront.getLogUI();
    JLabel clickHere = logFront.getSignIn();

    MicrosFront microsFront = new MicrosFront();
    JPanel thirdMicrosPanel = microsFront.getUI();

    ProfileFront profileFront = new ProfileFront();
    JPanel profileFrontPanel = profileFront.getUserProfilePanel();

    JMenuBar menuBar1 = new JMenuBar();

    JMenuItem backMenu = new JMenuItem();
    JMenuItem empty = new JMenuItem("                             ");
    JMenuItem profileMenu = new JMenuItem();

    Icon womanIcon = new ImageIcon("/Users/soniaorlikowska/IdeaProjects/Micros/woman.png");
    Icon backIcon = new ImageIcon("/Users/soniaorlikowska/IdeaProjects/Micros/back.png");

    private CardsLayout() {
        Frame();

        Cont.setLayout(cardLayout);

        Cont.add(firstSignPanel, "1");
        Cont.add(secondLogPanel, "2");
        Cont.add(thirdMicrosPanel, "3");
        Cont.add(profileFrontPanel, "4");

        profileMenu.setIcon(womanIcon);
        backMenu.setIcon(backIcon);

        menuBar1.add(backMenu);
        menuBar1.add(empty);
        menuBar1.add(profileMenu); //todo można zrobić dwa menubary, aby w karcie rejestracji nie pojawiała się ikona profilu

        // Karta startowa
        cardLayout.show(Cont, "2");

        clickHere.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setJMenuBar(menuBar1);
                super.mouseClicked(e);
                cardLayout.show(Cont, "1");
            }
        });

        backMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setJMenuBar(null);

                cardLayout.show(Cont, "2");
                System.out.println("Back menu");
            }
        });

        profileMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setJMenuBar(menuBar1);
                cardLayout.show(Cont, "4");
            }
        });

    }


    public void Frame() {

        frame.getContentPane().add(Cont);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 550);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static CardsLayout getInstance() {
        if (instance == null) instance = new CardsLayout();
        return instance;
    }

    public SignFront getSignFront() { return signFront; }

    public LogFront getLogFront() {
        return logFront;
    }

    public MicrosFront getMicrosFront() { return microsFront; }

    public JPanel getCont() {
        return Cont;
    }

    public JMenuBar getMenuBar1() {
        return menuBar1;
    }

    public JFrame getFrame() {
        return frame;
    }


}
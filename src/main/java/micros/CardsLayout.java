package micros;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Ta klasa ustawia CardLayout i actionlistnery dla buttonów przechodzących między stronami**/

public class CardsLayout {
    final JFrame frame = new JFrame("Mikros");
    LogFront logFront = new LogFront();
    MicrosFront microsFront = new MicrosFront();

    JPanel Cont = new JPanel();
    JPanel first = logFront.getLogUI();
    JPanel second = microsFront.getUI();
    JButton blogin =  logFront.getLogin();

    CardLayout cl = new CardLayout();

    JMenuBar menuBar = new JMenuBar();
    JMenu backMenu = new JMenu();
    JMenu profileMenu = new JMenu();
    Icon womanIcon = new ImageIcon("/Users/soniaorlikowska/IdeaProjects/Micros/woman.png");
    Icon backIcon = new ImageIcon("/Users/soniaorlikowska/IdeaProjects/Micros/back.png");

    public CardsLayout() {

        Cont.setLayout(cl);

        Cont.add(first,"1");
        Cont.add(second,"2");


        cl.show(Cont,"1");

        blogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { cl.show(Cont,"2"); }
        });
//todo Nie dziala MenuListner, reaguje na menuSelected, ale nie przełącza karty :(
        backMenu.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                System.out.println("AKCJA");
                cl.previous(Cont);
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });


    }

    public void Frame() {

        profileMenu.setIcon(womanIcon);
        backMenu.setIcon(backIcon);

        menuBar.add(backMenu);
        menuBar.add(profileMenu);

        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(new CardsLayout().getCont()); //zamiast frame cardlayout?
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public JPanel getCont() {
        return Cont;
    }

}


package micros.listeners;

import micros.fronts.LogFront;
import micros.fronts.MicrosFront;
import micros.fronts.ProfileFront;
import micros.fronts.SignFront;
import micros.main.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * This Class is setting CardLayout, Frame. ActionListeners for MenuBars and ClickHere blue field. CardLayout class is set as a singleton.
 **/

//todo after ClickHere wrong menubar is set
public class CardsLayout {

    private static CardsLayout instance;

    CardLayout cardLayout = new CardLayout();

    JFrame frame = new JFrame("Mikros");
    JPanel container = new JPanel();

    SignFront signFront = new SignFront();
    JPanel firstSignPanel = signFront.getSignPanel();

    LogFront logFront = new LogFront();
    JPanel secondLogPanel = logFront.getLogUI();
    JLabel clickHere = logFront.getSignIn();

    MicrosFront microsFront = new MicrosFront();
    JPanel thirdMicrosPanel = microsFront.getUI();

    ProfileFront profileFront = new ProfileFront();
    JPanel profileFrontPanel = profileFront.getUserProfilePanel();

    JMenuBar loginInMenuBar = new JMenuBar();
    JMenuBar microsMenuBar = new JMenuBar();
    JMenuBar profileMenuBar = new JMenuBar();

    JMenuItem backMenuSignIn = new JMenuItem();

    JMenuItem backMenuMicros = new JMenuItem();
    JMenuItem emptyMicros = new JMenuItem("                             ");
    JMenuItem profileMenuMicros = new JMenuItem();

    JMenuItem backMenuProfile = new JMenuItem();
    JMenuItem emptyProfile = new JMenuItem("                             ");
    JMenuItem logOutProfile = new JMenuItem();

    String userName = logFront.getUsernameField().getText();
    String userPassword = String.valueOf(logFront.getPasswordField().getPassword());

    private Icon backIcon = new ImageIcon("/Users/soniaorlikowska/IdeaProjects/Micros/back.png");

    private CardsLayout() {

        Frame();

        container.setLayout(cardLayout);

        container.add(firstSignPanel, "1");
        container.add(secondLogPanel, "2");
        container.add(thirdMicrosPanel, "3");
        container.add(profileFrontPanel, "4");

        cardLayout.show(container, "2");

        //Micros MenuBar
        backMenuMicros.setIcon(backIcon);
        Icon womanIcon = new ImageIcon("/Users/soniaorlikowska/IdeaProjects/Micros/woman.png");
        profileMenuMicros.setIcon(womanIcon);
        microsMenuBar.add(backMenuMicros);
        microsMenuBar.add(emptyMicros);
        microsMenuBar.add(profileMenuMicros);

        //Profile MenuBar
        backMenuProfile.setIcon(backIcon);
        Icon logoutIcon = new ImageIcon("/Users/soniaorlikowska/IdeaProjects/Micros/logout.png");
        logOutProfile.setIcon(logoutIcon);
        profileMenuBar.add(backMenuProfile);
        profileMenuBar.add(emptyProfile);
        profileMenuBar.add(logOutProfile);

        ActionListeners();
    }

    public void ActionListeners() {

        //LogFront ClickHere Listener
        clickHere.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                backMenuSignIn.setIcon(backIcon);
                loginInMenuBar.add(backMenuSignIn);
                frame.setJMenuBar(loginInMenuBar);
                cardLayout.show(container, "1");
            }
        });

        //MicrosFront MenuBar Listeners

        backMenuMicros.addActionListener(e -> {

            User user = new User();
            user.forgetUser(userName, userPassword);
            cardLayout.show(container, "2");
            frame.setJMenuBar(loginInMenuBar);

        });

        profileMenuMicros.addActionListener(e -> {

            profileFront.setEasyScore("E");
            profileFront.setMediumScore("M");
            profileFront.setHardScore("H");
            cardLayout.show(container, "4");
            frame.setJMenuBar(profileMenuBar);
        });

        //ProfileFront MenuBars Listeners
        backMenuProfile.addActionListener(e -> {

            cardLayout.show(container, "3");
            frame.setJMenuBar(microsMenuBar);
        });

        logOutProfile.addActionListener(e -> {

            User user = new User();
            user.forgetUser(userName, userPassword);
            cardLayout.show(container, "2");
            frame.setJMenuBar(null);
        });

        //SignInFront MenuBar Listener
        backMenuSignIn.addActionListener(e -> {
            frame.setJMenuBar(null);
            cardLayout.show(container, "2");
            System.out.println("Back menu");
        });

    }

    public void Frame() {

        frame.getContentPane().add(container);
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

    public SignFront getSignFront() {
        return signFront;
    }

    public ProfileFront getProfileFront() {
        return profileFront;
    }

    public LogFront getLogFront() {
        return logFront;
    }

    public MicrosFront getMicrosFront() {
        return microsFront;
    }

    public JPanel getContainer() {
        return container;
    }

    public JMenuBar getLoginInMenuBar() {
        return loginInMenuBar;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JMenuBar getMicrosMenuBar() {
        return microsMenuBar;
    }


}
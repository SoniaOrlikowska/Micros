package micros.fronts;

import micros.main.User;

import javax.swing.*;
import java.awt.*;

public class ProfileFront {

    JPanel userProfilePanel = new JPanel();
    JLabel userName = new JLabel();
    JLabel userScore = new JLabel();
    JLabel easyProblemsScore = new JLabel("8 easy problems");
    JLabel mediumProblemsScore = new JLabel("2 medium problems");
    JLabel hardProblemsScore = new JLabel("3 hard problems");
//new Color(250, 20, 215)

    public ProfileFront() {

        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        userProfilePanel.setLayout(gridBagLayout);
        userProfilePanel.setBackground(Color.white);
        easyProblemsScore.setForeground(new Color(0, 144, 0));
        mediumProblemsScore.setForeground(new Color(255, 139, 0));
        hardProblemsScore.setForeground(new Color(154, 32, 102));

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 3;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 10, 0, 0);
        gbc.weightx = 1;
        userName.setFont(new Font("Serif",Font.PLAIN,60));
        userProfilePanel.add(userName, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 3;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 10, 0, 20);
        userScore.setFont(new Font("Serif",Font.PLAIN,30));
        gbc.weightx = 1;
        userProfilePanel.add(userScore, gbc);

        //Clear JButton
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(25, 10, 5, 0);
        gbc.weightx = 1;
        easyProblemsScore.setFont(new Font("Serif",Font.BOLD, 15));
        userProfilePanel.add(easyProblemsScore, gbc);
       //

        //JButton Sprawdz
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.insets = new Insets(5, 10, 5, 0);
        gbc.weightx = 1;
        mediumProblemsScore.setFont(new Font("Serif",Font.BOLD, 15));
        userProfilePanel.add(mediumProblemsScore, gbc);

        //JButton Zapisz
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.insets = new Insets(5, 10, 5, 20);
        gbc.weightx = 1;
        hardProblemsScore.setFont(new Font("Serif",Font.BOLD, 15));
        userProfilePanel.add(hardProblemsScore, gbc);







    }

    public JPanel getUserProfilePanel() {
        return userProfilePanel;
    }

    public JLabel getUserScore() { return userScore; }

    public JLabel getUserName() { return userName; }

    }



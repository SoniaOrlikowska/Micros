package micros.fronts;

import javax.swing.*;
import java.awt.*;

public class ProfileFront {

    JPanel userProfilePanel = new JPanel();
    JLabel userName = new JLabel();
    JLabel userScore = new JLabel();
    JLabel getUserScore = new JLabel();

    String userNameString;
    String userScoreString;

    public void setUserScoreString(String userScoreString) {
        this.userScoreString = userScoreString;
    }

    public void setUserNameString(String userNameString) {
        this.userNameString = userNameString;
    }

    public ProfileFront() {
        userName.setText(userNameString);
        userScore.setText(userScoreString);

        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        userProfilePanel.setLayout(gridBagLayout);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        gridBagConstraints.weightx = 0;
        userProfilePanel.add(userName, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(10, 10, 0, 20);
        gridBagConstraints.weightx = 1;
        userProfilePanel.add(userScore, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        gridBagConstraints.weightx = 1;
        userProfilePanel.add(getUserScore, gridBagConstraints);

    }

    public JPanel getUserProfilePanel() {
        return userProfilePanel;
    }


}


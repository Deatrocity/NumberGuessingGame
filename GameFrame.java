package NumberGuessingGame;

import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class GameFrame extends JFrame implements ActionListener{

    private JLabel mainLabel;
    private JButton easyButton, mediumButton, hardButton;

    GameFrame(){
        setTitle("Number Guessing Game");
        setLayout(null);

        // Labels
        mainLabel = new JLabel("I'm thinking of a number between...");
        mainLabel.setBounds(40, 20, 300, 25);
        mainLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(mainLabel);

        // Buttons
        easyButton = new JButton("1 - 100");
        easyButton.setBounds(120, 80, 100, 30);
        easyButton.setActionCommand("easy");
        easyButton.addActionListener(this);
        add(easyButton);

        mediumButton = new JButton("1 - 1,000");
        mediumButton.setBounds(120, 130, 100, 30);
        mediumButton.setActionCommand("medium");
        mediumButton.addActionListener(this);
        add(mediumButton);

        hardButton = new JButton("1 - 10,000");
        hardButton.setBounds(120, 180, 100, 30);
        hardButton.setActionCommand("hard");
        hardButton.addActionListener(this);
        add(hardButton);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350,275);  // set frame size
        setVisible(true);  // make frame visible
        setLocation(500, 100);
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // Action listener creates new game frame based on which of the three buttons are pressed
        String command = ae.getActionCommand();
        switch(command){
            case "easy":
                setVisible(false);
                new GameFrame2(101).setVisible(true);
                break;
            case "medium":
                setVisible(false);
                new GameFrame2(1_001).setVisible(true);
                break;
            case "hard":
                setVisible(false);
                new GameFrame2(10_001).setVisible(true);
                break;
        }
    }



    public static void main(String[] args) {
        new GameFrame();
    }
  
}
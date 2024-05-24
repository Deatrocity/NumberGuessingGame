package NumberGuessingGame;

import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class MenuFrame extends JFrame implements ActionListener{

    private JLabel mainLabel;
    private JButton startButton, exitButton;

    MenuFrame(){

        setTitle("Number Guessing Game");
        setLayout(null);

        // Labels
        mainLabel = new JLabel("Number Guessing Game");
        mainLabel.setBounds(55,10,500,100);
        mainLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(mainLabel);

        // Buttons
        startButton = new JButton("Start");
        startButton.setBounds(120, 150, 100, 30);
        startButton.addActionListener(this);
        add(startButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(120, 200, 100, 30);
        exitButton.addActionListener(this);
        add(exitButton);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350,275);  // set frame size
        setVisible(true);  // make frame visible
        setLocation(500, 100);
        setResizable(false);
    }

    
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() == startButton) {
            setVisible(false); 
            new GameFrame().setVisible(true);
        } else if (ae.getSource() == exitButton) {
            // closes program
            System.exit(0);
        }
    }


    public static void main(String args[]){
        new MenuFrame();
    }
    
}

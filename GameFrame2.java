package NumberGuessingGame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class GameFrame2 extends JFrame implements ActionListener{

    private JLabel mainLabel, winLabel, guessCountLabel, howCloseLabel, winCountLabel;
    private JButton submitButton, rematchButton;
    private JTextField guessInput;
    //private int userInput;   Work in progress
    private GuessingGame game; // practice practice practice

    GameFrame2 (int ceiling) {
        // create GuessingGame instance
        game = new GuessingGame(ceiling);

        setTitle("Number Guessing Game");
        setLayout(null);

        // Labels
        mainLabel = new JLabel("Guess the number (1 - " + (ceiling - 1) + ")");
        mainLabel.setBounds(40, 20, 300, 25);
        mainLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(mainLabel);

        winLabel = new JLabel("You Win!"); // only displays after guessing correct number.
        winLabel.setBounds(125, 55, 300, 25);
        winLabel.setFont(new Font("Arial", Font.BOLD, 24));

        winCountLabel = new JLabel("Wins: " + GuessingGame.getWinCount());
        winCountLabel.setBounds(40, 80, 300, 25);
        add(winCountLabel);

        guessCountLabel = new JLabel("Guess Count: " + game.getGuesses());
        guessCountLabel.setBounds(40, 100, 300, 25);
        add(guessCountLabel);

        howCloseLabel = new JLabel("");
        howCloseLabel.setBounds(125, 130, 300, 25);
        add(howCloseLabel);

        // Text Field
        guessInput = new JTextField(20);
        guessInput.setBounds(125, 160, 100, 30);
        add(guessInput);

        // Buttons
        submitButton = new JButton("Submit");
        submitButton.setBounds(125, 200, 100, 30);
        submitButton.addActionListener(this);
        add(submitButton);

        rematchButton = new JButton("Try Again?");
        rematchButton.setBounds(125, 200, 100, 30);
        rematchButton.addActionListener(this);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350,275);  // set frame size
        setVisible(true);  // make frame visible
        setLocation(500, 100);
        setResizable(false);
    }

    GameFrame2(){
        this(101);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() == submitButton){
            handleInput();

        } else if (ae.getSource() == rematchButton) {
                rematch();
        }
    
    }

    public void handleInput(){
        String userInputText = guessInput.getText().trim(); // Trim whitespace
        if (!userInputText.isEmpty()) {
            try {
                int userInput = Integer.parseInt(userInputText);
                game.makeGuess(userInput);
                howCloseLabel.setText(game.getHowClose());
                guessCountLabel.setText("Guess Count: " + game.getGuesses());
                guessInput.setText(""); // Clear textbox
                if (game.isVictory()) {
                    victoryUpdate();
                }
            } catch (NumberFormatException e) {
                howCloseLabel.setText("Thats not a number!");
                guessInput.setText(""); // Clear textbox
            }
        } else {
            howCloseLabel.setText("No number entry.");
        }
    }

    public void victoryUpdate() {
        add(winLabel);
        remove(submitButton);
        add(rematchButton);
        remove(winCountLabel);
        add(winCountLabel);
        revalidate();
        repaint();
    }

    public void rematch() {
        setVisible(false);
        new GameFrame();
    }

    public static void main(String args[]){
        new GameFrame2(101);
        
    }
}
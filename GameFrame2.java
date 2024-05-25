package NumberGuessingGame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GameFrame2 extends JFrame implements ActionListener{

    // Declare JFrame widgets
    private JLabel mainLabel, winLabel, guessCountLabel, howCloseLabel, winCountLabel;
    private JButton submitButton, rematchButton;
    private JTextField guessInput;
    // Declare GuessingGame object
    private GuessingGame game; 


    GameFrame2 (int ceiling) {

        // Instantiate GuessingGame
        game = new GuessingGame(ceiling);

        setTitle("Number Guessing Game");
        setLayout(null);

        // Main JLabel - Describes guessing range
        mainLabel = new JLabel("Guess the number (1 - " + (ceiling - 1) + ")");
        mainLabel.setBounds(40, 20, 300, 25);
        mainLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(mainLabel);

        // You Won! JLabel - Tells user they won, displayed only after guessing correct number
        winLabel = new JLabel("You Win!");
        winLabel.setBounds(125, 55, 300, 25);
        winLabel.setFont(new Font("Arial", Font.BOLD, 24));

        // Win count JLabel - Keeps track of number of games won
        winCountLabel = new JLabel("Wins: " + GuessingGame.getWinCount());
        winCountLabel.setBounds(40, 80, 300, 25);
        add(winCountLabel);

        // Guess count JLabel - Keeps track of number of guesses on current game
        guessCountLabel = new JLabel("Guess Count: " + game.getGuesses());
        guessCountLabel.setBounds(40, 100, 300, 25);
        add(guessCountLabel);

        // How close JLabel - Tells user if their guess was too high or too low
        howCloseLabel = new JLabel("");
        howCloseLabel.setBounds(125, 130, 300, 25);
        add(howCloseLabel);

        // Text Field - User enters their guess in text field
        guessInput = new JTextField(20);
        guessInput.setBounds(125, 160, 100, 30);
        add(guessInput);

        // Submit JButton - User submits text field input as guess
        submitButton = new JButton("Submit");
        submitButton.setBounds(125, 200, 100, 30);
        submitButton.addActionListener(this);
        add(submitButton);

        // Rematch JButton - User restarts game after winning
        rematchButton = new JButton("Try Again?");
        rematchButton.setBounds(125, 200, 100, 30);
        rematchButton.addActionListener(this);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set close operation
        setSize(350,275);  // set frame size
        setVisible(true);  // make frame visible
        setLocation(500, 100); // sets where frame is opened on screen
        setResizable(false);  // makes frame non-resizable
    }

    // No args constructor creates default 1-100 game
    GameFrame2(){
        this(101);
    }

    @Override
    // Handle button clicks
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submitButton){
            handleInput();
        } else if (ae.getSource() == rematchButton) {
                rematch();
        }
    }

    // Handles the users number guess
    public void handleInput(){

        String userInputText = guessInput.getText().trim();  // Get input from text field

        // If the users text field entry is not empty
        if (!userInputText.isEmpty()) {
            try {
                int userInput = Integer.parseInt(userInputText);
                // Call makeGuess method on GuessingGame object using user entry
                game.makeGuess(userInput);
                // Update JFrame widgets to show how close the guess was and how many guesses were made
                howCloseLabel.setText(game.getHowClose());
                guessCountLabel.setText("Guess Count: " + game.getGuesses());
                guessInput.setText("");
                // if user guess is correct, call victoryUpdate method which updates widgets
                if (game.isVictory()) {
                    victoryUpdate();
                }
            } catch (NumberFormatException e) {
                // Tell user to make sure their entry is a number
                howCloseLabel.setText("Thats not a number!");
                guessInput.setText("");  // Reset guess text field
            }
        } else {
            // If user submits empty text field, tell them nothing was entered
            howCloseLabel.setText("No number entry.");
        }
    }

    public void victoryUpdate() {
        // Updates JFrame widgets to reflect victory and replace submit button with a replay button
        add(winLabel);
        remove(submitButton);
        add(rematchButton);
        remove(winCountLabel);
        add(winCountLabel);
        revalidate();
        repaint();
    }

    public void rematch() {
        // Restarts game by taking user back to first GameFrame to pick the guess range for new game
        setVisible(false);
        new GameFrame();
    }

    public static void main(String args[]){
        // For testing
        new GameFrame2(101);
    }
}
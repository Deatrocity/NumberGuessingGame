package NumberGuessingGame;

import java.util.Random;

public class GuessingGame {

    private static int winCount = 0;
    //private static int bestGuesses;

    private int winningNumber;
    private int guess;
    private int guesses = 0;
    private String howClose;
    private boolean victory = false;

    GuessingGame(){
        this(101);
        Random random = new Random();
        winningNumber = random.nextInt(101);
    }

    GuessingGame(int ceilingValue){

        Random random = new Random(); // instantiate Random class
        winningNumber = random.nextInt(ceilingValue); // set winning number from 1 - 100(easy), 1000(medium), 10000(hard)

        // CHEAT CODES~~~~~~~~~~~~~~~~~~~~~~~~~
        System.out.println(winningNumber);

    }

    // Player makes a guess
    public void makeGuess(int guess){
        
        this.guesses += 1; // increase total guess count
        
        // check if guessed number matches winning number
        if(guess > winningNumber){
            this.howClose = guess + " is too high!";
        } else if(guess < winningNumber) {
            this.howClose = guess + " is too low!";
        } else{
            winCount++;
            this.victory = true;
            this.howClose = "The number is " + this.winningNumber + "!";
        }
    }


    // getter methods
    public String getHowClose(){
        return this.howClose;
    }
    public int getWinningNumber (){
        return this.winningNumber;
    }
    public int getGuess(){
        return this.guess;
    }
    public int getGuesses(){
        return this.guesses;
    }
    public boolean isVictory(){
        return this.victory;
    }
    public static int getWinCount(){
        return winCount;
    }


    // setter methods
    public void setGuess(int guess){
        this.guess = guess;
    }
    public void setGuesses(int guesses){
        this.guesses = guesses;
    }



    public static void main(String[] args) {
        new GuessingGame();
    }
}

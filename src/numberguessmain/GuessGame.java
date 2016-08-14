/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberguessmain;

import javax.swing.JOptionPane;

/**
 * A class to drive the NumberGuesser class
 * This class provides user prompts and makes a game
 * out of guessing the users number
 * FIX COMMENTS!!!!
 * @author zu
 */
public class GuessGame 
{
    // ------------------------------ Private Members ------------------------------
    
    // Holds the class with the appropriate methods to guess a number from 1-100
    private NumberGuesser numGame;
    // Holds the number of turns it takes the computer to guess the users number
    private int turns;
    /*
    If this value is false the computer has not guessed the users number correctly
    and true otherwise
    */
    private boolean guessed;
    
    // ------------------------------ Private Members ------------------------------
    
    // ------------------------------ Public Members -------------------------------
    
    // Constructor
    public GuessGame()
    {
        numGame = new NumberGuesser();
        turns = 0;
        guessed = false;
    }
    
    // Stars a new Guess game
    public String newGame()
    {   
        // Holds computer guess
        int computerGuess = 0;
        
        // While the computer has not guessed the users number
        while(!guessed)
        {
            // Get computer guess
            computerGuess = numGame.getGuess();
            // Prompt user for input
            if(validateGuess(computerGuess) == 0)
            {   
                // Computer has guessed correctly! End loop
                guessed = true;
            }
            else
            {   
                // Get user input
                int userInput = highOrLow();
                // If the guess was too high...
                if(userInput == 0)
                {
                    // Update lowest value
                    numGame.updateHigh();
                    ++turns;
                }
                // If the guess was too low
                else if(userInput == 1)
                {
                    // Update highest value
                    numGame.updateLow();
                    ++turns;
                }
            }
        }
        
        // Display how many turns it took to guess the number
        return "It took me " + turns + " turns to guess your number!";
    }
    
    /*
    Displays a message box asking user if the computer guess is correct
    Returns 0 if the computer is correct and 1 otherwise. Takes in 
    a number that represents the computers guess
    */
    public int validateGuess(int guessValue)
    {   
        int answer = JOptionPane.showConfirmDialog(null,"Is " + guessValue + " your number?",null,JOptionPane.YES_NO_OPTION);
        return answer ;
    }
    
    /*
    Displays a message box asking the user if the number the computer guessed
    was too high or too low. Returns 1 if the guess was too low and 0 if the
    guess was too high
    */
    public int highOrLow()
    {   
        Object[] options = {"Too high",
                            "Too low"};
        int answer = JOptionPane.showOptionDialog(null,
            "Was the number too high or too low?",
            "A Question",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,     //do not use a custom Icon
            options,  //the titles of buttons
            options[0]); //default button title
    
        return answer;
    }
    
    // ------------------------------ Public Members -------------------------------
    
}

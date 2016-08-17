/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberguessmain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * A class to drive the NumberGuesser class This class provides user prompts and
 * makes a game out of guessing the users number FIX COMMENTS!!!!
 *
 * @author zu
 */
public class GuessGame {
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
    // Determines GUI behavior
    private int gameState;
    // Differente state values affect the look and function of the GUI
    /*
    This state is used when starting a new game
    The only buttons enable in this state are the
    yes and no buttons
     */
    private final int INITIAL = 0;
    /*
    Once the user has started a new game, this new state in invoked,
    here the program will display THE FIRST GUESS by the computer
    */
    private final int INITIAL_GUESS = 1;
    /*
    This state is used when asking the user if the
    computers guess is correct. The only buttons
    enabled in this state are the yes and no buttons
     */
    private final int ASK_USER = 2;
    /*
    This state is used when asking the user if
     */
    private final int HIGH_OR_LOW = 3;
    /*
    This state is used when the computer has guessed the users number and asks to play a new game
    */
    private final int END_GAME = 4;
    // Holds all GUI elements
    private MainFrame frame;

    // ------------------------------ Public Members -------------------------------
    // Constructor
    public GuessGame() {
        numGame = new NumberGuesser();
        // Create frame
        frame = new MainFrame("Guess game");
        turns = 0;
        guessed = false;
        // Set initial state
        gameState = INITIAL;
        // Set all button listeners
        setButtonListeners();
    }

    // Stars a new Guess game
    public void newGame() 
    {   
        showGUI();
        // Get button panel
        ButtonPanel bp = frame.getButtonsPanel();
        // Get yes/no buttons
        
       // Perform different actions depending on gameState
        switch(gameState)
        {
            case HIGH_OR_LOW:
                // Disable yes and no buttons
                System.out.println("DEEZ NUTS BOI");
                break;
            default:
                break;
        }
    }
        
    /*
    Displays a message box asking user if the computer guess is correct
    Returns 0 if the computer is correct and 1 otherwise. Takes in 
    a number that represents the computers guess
     */
    public int validateGuess(int guessValue) {
        int answer = JOptionPane.showConfirmDialog(null, "Is " + guessValue + " your number?", null, JOptionPane.YES_NO_OPTION);
        return answer;
    }

    /*
    Displays a message box asking the user if the number the computer guessed
    was too high or too low. Returns 1 if the guess was too low and 0 if the
    guess was too high
     */
    public int highOrLow() {
        Object[] options = {"Too high",
            "Too low"};
        int answer = JOptionPane.showOptionDialog(null,
                "Was the number too high or too low?",
                "A Question",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, //do not use a custom Icon
                options, //the titles of buttons
                options[0]); //default button title

        return answer;
    }
    
    
    /////////////////////////////////// GUI ///////////////////////////////////////
    
    public void showGUI()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // ------------------------------ Button listeners ------------------------------
    private void setButtonListeners()
    {   
         // Get button panel from frame
         ButtonPanel bp = frame.getButtonsPanel();
         
         /////////////////////////// Yes Button ///////////////////////////
        JButton yButton = bp.getYesButton();
         // Set action listener
        yButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)
        {
                switch(gameState)
                {
                   case INITIAL :
                        // Prompt user to think of a number between 1-100
                        frame.promptUser();
                        // Change game state
                        gameState = INITIAL_GUESS;
                        break;
                   case INITIAL_GUESS:
                       // Get current guess
                       int currGuess = numGame.getGuess();
                       // Show user first computer guess
                       frame.askUser(currGuess);
                       // Add one to turns
                       ++turns;
                       // Change game state to ASK_USER
                       gameState = ASK_USER;
                        break;
                   case ASK_USER: 
                        // Computer guess is correct, print win message and number of turns
                        frame.showEndMessage(turns);
                        // Change game state
                        gameState = END_GAME;
                        break;
                   case END_GAME:
                       frame.clearText();
                       //Show welcome message
                       frame.showWelcomeMessage();
                       // Change gameState
                       gameState = INITIAL;
                       break;
                   default:
                       break;
                }
        }   
    });
        
          /////////////////////////// No Button ///////////////////////////
          JButton nButton = bp.getNoButton();
          // Set action listener
          nButton.addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent e)
              {
                  switch(gameState)
                  {
                      case INITIAL:          
                          // Exit Game
                          frame.closeGUI();
                          break;
                      case ASK_USER:
                          // Disable yes, no buttons
                          frame.disable(0);
                          frame.disable(1);
                          // Enable too high, low buttons
                          frame.enable(2);
                          frame.enable(3);
                          // Show message
                          frame.showGameMessage();
                            // If the number the computer has guessed is not correct, change state
                          gameState= HIGH_OR_LOW;
                          break;
                      case END_GAME:
                          // Exit Game
                          frame.closeGUI();
                      default:
                          break;
                  }
              }
          });
          
          /////////////////////////// Too High Button ///////////////////////////
         JButton tHButton = bp.getTooHighButton();
         // Set action listener
         tHButton.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e)
             {
                  // Guess lower
                 numGame.updateHigh();
                 // Show new guess
                 int currGuess = numGame.getGuess();
                 frame.askUser(currGuess);
                 // Add one to turns
                 ++turns;
                 // Enable yes, no buttons
                frame.enable(0);
                frame.enable(1);
                // Disable too high,low buttons
                frame.disable(2);
                frame.disable(3);
                 // Change game state
                 gameState = ASK_USER;                 
             }
         });
         
         /////////////////////////// Too Low Button ///////////////////////////
          JButton lHButton = bp.getTooLowButton();
         // Set action listener
         lHButton.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e)
             {
                  // Guess lower
                 numGame.updateLow();
                 // Show new guess
                 int currGuess = numGame.getGuess();
                 frame.askUser(currGuess);
                 // Add one to turns
                 ++turns;
                 // Enable yes, no buttons
                 frame.enable(0);
                  frame.enable(1);
                  // Disable too high,low buttons
                  frame.disable(2);
                  frame.disable(3);
                 // Change game state
                 gameState = ASK_USER;                 
             }
         });        
    }
}

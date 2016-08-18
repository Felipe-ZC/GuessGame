package numberguessmain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * A class to play the GuessGame which consists in the user thinking of a number
 * from 1-100 and the computer (program) guessing that number in 7 turns or less.
 * @author Felipe Zuniga
 */
public class GuessGame
{
    // ------------------------------ Private Members ------------------------------

    /**
     * Performs the nececcsary operations to guess the users number (1-100).
     */
    private NumberGuesser numGame;
    
    /**
     * Holds the number of guesses it takes the computer to the guess the user's number
     * correctly.
     */
    private int turns;

    /**
     * Determines GUI behvior as well as the look, the possible vallues are
     * constants that decide what the computer should do next.
     */
    private int gameState;
    
    /**
     *  This state is used when starting a new game, in this state
     * the too high, too low buttons are disabled.
     */
    private final int INITIAL = 0;

    /**
     *  Once the user has started a new game this state is invoked, here
     * the program will display THE FIRST GUESS made by the computer.
     */
    private final int INITIAL_GUESS = 1;
    
    /**
     * This state is used when asking the user if the computer guess
     * is correct, only the yes and no buttons are enabled in this state.
     */
    private final int ASK_USER = 2;
    
    /**
     * This state is used when the computer has guessed incorrectly and must ask
     * the user if its guess was too high or too low, yes and no buttons are disabled
     * in this sate.
     */
    private final int HIGH_OR_LOW = 3;

    /**
     * This state is used when the computer has guessed the user's number and ask if he/she will like
     * to play a new game.
     */
    private final int END_GAME = 4;
    
    /**
     * Holds the GUI.
     */
    private MainFrame frame;

    // ------------------------------ Public Members ------------------------------
    
    // Constructor
    public GuessGame() {
        numGame = new NumberGuesser();
        // Create frame
        frame = new MainFrame("Guess game");
        turns = 0;
        // Set initial state
        gameState = INITIAL;
        // Set all button listeners
        setButtonListeners();
    }
    
    /**
     *  Creates a new NumberGuesser object, resets turns and sets game state to INITIAL,
     * this method should be used when starting a new GuessGame AFTER at least one
     * game has been played and completed.
     */
   public void newGame()
   {
        frame.clearText();
        //Show welcome message
        frame.showWelcomeMessage();
        // Create a new numGame
        numGame = new NumberGuesser();
        // Reset number of turns
        turns = 0;
        // Change gameState
        gameState = INITIAL;       
   }

     // ------------------------------ GUI ------------------------------
    
   /**
    * Makes GUI visible, should be called when starting a new instance of GuessGame.
    */
    public void showGUI()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * Defines and sets all button listeners for the GUI, this must be done here as the behavior of the GUI
     * depends on the status (state) of a GuessGame.
     */
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
                       frame.clearText();
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
                       System.out.println(turns);
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
                       newGame();
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

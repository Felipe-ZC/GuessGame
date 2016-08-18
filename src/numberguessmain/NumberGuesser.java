package numberguessmain;

/**
 * A class that uses a modified binary search algorithm
 * to guess a number from 1-100.
 * @author Felipe Zuniga
 */
public class NumberGuesser 
{   
    // ------------------------------ Private Members ------------------------------
    
    /**
     *  Holds the lowest number currently being considered.
     */
    private int low;
    
   /**
    * Holds the highest number currently being considered.
    */
    private int high;
    
    /**
     * Holds the number between high and low.
     */
    private int middle;
   
    // ------------------------------ Public Members -------------------------------
    
    // Constructor
    public NumberGuesser()
    {           
        // Set number values
        // Lowest number in from 1-100
        low = 1;
        // Highest number from 1-100
        high = 100;
        // This number is what the computer uses to "guess" the users number
        middle = (low+high) / 2;
    }    
    
    // -------------------- Accessor methods --------------------
    
    public int getGuess()
    {
        return middle;
    }
    public int getLow()
    {
        return low;
    }
    public int getHigh()
    {
        return high;
    }
    
    // -------------------- Mutator methods --------------------
    
    /**
     *   This method updates the lowest value being considered, this way the program
     * takes no unnecessary steps in guessing the user's number.
     */
    public void updateLow()
    {
        // Make lowest value possible one more than the current middle value
        low = middle + 1;
        // Recalculate middle value
        middle = (low + high) / 2;
    }
    
    /**
     *  This method updates the highest value being considered, this way the program
     * takes no unnecessary steps in guessing the user's number.
     */
    public void updateHigh()
    {
        // Make the highest value possible one less than the current middle value
        high = middle - 1;
        middle = (low + high) / 2;
    }
     
}

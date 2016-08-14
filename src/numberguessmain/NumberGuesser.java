package numberguessmain;

/**
 * A class that uses a modified binary search algorithm
 * to guess a number from 1-100.
 * @author Felipe Zuniga
 */
public class NumberGuesser 
{   
    // ------------------------------ Private Members ------------------------------
    
    // Holds the lowest value possible
    private int low;
    // Holds the highest value possible 
    private int high;
    // Holds the middle value between low and high
    private int middle;
    
    // ------------------------------ Private Members ------------------------------
    
    // ------------------------------ Public Members -------------------------------
    
    // Constructor
    public NumberGuesser()
    {           
        // Set number values
        low = 1;
        high = 100;
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
    
    // -------------------- Accessor methods --------------------
    
    // -------------------- Mutator methods --------------------
    
    /*
    This method is used to update the value of the lowest and middle numbers.
    If the number the computer has guessed is too high the program then changes
    the lowest value possible to one more than the middle value, then the middle
    value is recalculated. 
    
    This ensure that the program takes no unnecssary steps in guessing the users 
    number.
    */
    public void updateLow()
    {
        // Make lowest value possible one more than the current middle value
        low = middle + 1;
        // Recalculate middle value
        middle = (low + high) / 2;
    }
    
    /*
    This method is used to update the value of the highest and middle numbers.
    If the number the computer has guessed is too low the program then changes
    the highest value possible to one less than the middle value, then the middle
    value is recalculated. 
    
    This ensure that the program takes no unnecssary steps in guessing the users 
    number.
    */
    public void updateHigh()
    {
        // Make the highest value possible one less than the current middle value
        high = middle - 1;
        middle = (low + high) / 2;
    }
    
    // -------------------- Mutator methods --------------------
    
    // ------------------------------ Public Members -------------------------------
     
}

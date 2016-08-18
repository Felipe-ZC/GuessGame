package numberguessmain;

import javax.swing.SwingUtilities;

public class NumberGuessMain 
{

    public static void main(String[] args)
    {   
        GuessGame game = new GuessGame();
        
        SwingUtilities.invokeLater(new Runnable()
        {
                public void run()
                {
                    game.showGUI();
                }
          });
    }
}

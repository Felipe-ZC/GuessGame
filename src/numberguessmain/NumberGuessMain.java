/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberguessmain;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class NumberGuessMain 
{

    public static void main(String[] args)
    {   
        SwingUtilities.invokeLater(new Runnable(){
           public void run(){

        GuessGame game = new GuessGame();
        game.showGUI();
        //game.newGame();
           }
        });
    }
    
}

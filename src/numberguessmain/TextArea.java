/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberguessmain;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;

/**
 *
 * @author zu
 */
public class TextArea extends JTextArea
{
    // Holds font details
    private Font fontDetails; 
    // --------------------------- Constructor ---------------------------
    public TextArea()
    {        
        // Create Font
        fontDetails = new Font("Arial",Font.BOLD,11);
        // Set font
        setFont(fontDetails);
        setForeground(Color.black);
    }
    // ------------------------ Other mthods ---------------------------
    public void clear()
    {
        setText(null);
    }
    
}

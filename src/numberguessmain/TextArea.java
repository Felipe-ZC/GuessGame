package numberguessmain;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;

/**
 * A modified JTextArea class that defines a specific font and color for the text area,
 * also makes the JTextArea uneditable.
 * @author Felipe Zuniga
 */
public class TextArea extends JTextArea
{
    /**
     * Holds specific font properties.
     */
    private Font fontDetails; 
    
    // --------------------------- Constructor ---------------------------
    
    public TextArea()
    {        
        // Create Font
        fontDetails = new Font("Arial",Font.BOLD,12);
        // Set font
        setFont(fontDetails);
        setForeground(Color.black);
        setEditable(false);
    }
    
    // ------------------------ Other methods ---------------------------
    
    /**
     * Clears all text in a TextArea oject.
     */
    public void clear()
    {
        setText(null);
    }
    
}

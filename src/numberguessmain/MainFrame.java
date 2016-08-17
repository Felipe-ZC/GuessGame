/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberguessmain;

import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class MainFrame extends JFrame
{   
    // --------------------- Instance variables --------------------- 
    
    // Holds the Frame's layout manager
    private BorderLayout layout;
    // Holds content pane
    private Container content;
    // Holds width of frame
    private final int frameWidth = 550 ;
    // Holds length of frame
    private final int frameLength = 300;
    // Holds control buttons
    private ButtonPanel buttonsPanel;
    // Holds TextArea that displays messages to user
    private TextArea textArea;
    
    // --------------------- Constructor -----------------------------    
    
    public MainFrame(String title)
    {
        // Call JFrame constructor
        super(title);
        
        // Set frame size
        setSize(frameWidth,frameLength);
        
        // Get content pane
        content = getContentPane();
        
        // Close program when cross is pressed on frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Instantiate layout manager
        layout = new BorderLayout();
                
        // Set layout manager of frame
        setLayout(layout);
          
        ///////////////////////// Buttons Panel //////////////////////   
        
        // Create buttons panel
        buttonsPanel = new ButtonPanel();
        // Add button panel to the western portion of the window
        content.add(buttonsPanel,BorderLayout.WEST);
               
        ///////////////////////// Text Area ///////////////////////// 
        
        // Create new Text area
        textArea = new TextArea();

        // Add to content pane
        content.add(textArea,BorderLayout.CENTER);
        
        // Display greetiing
        showWelcomeMessage();
    }
    
    // ---------------------- Accesor Methods ---------------------------
    
    public TextArea getTextArea()
    {
        return textArea;
    }
    
    public ButtonPanel getButtonsPanel()
    {
        return buttonsPanel;
    }
    
    // ---------------------- DIsplay Methods ------------------------------
    public void showWelcomeMessage()
    {
        textArea.append("Welcome!\nWould you like to start a new game?\n");
    }
    
    public void promptUser()
    {
        textArea.append("Please think of a number from 1-100\nPress yes when you are ready.\n");
    }
        
    public void askUser(int guess)
    {
        textArea.append("Is " + guess + " the number that you're thinking of?\n");
    }
    
    public void showGameMessage()
    {
        textArea.append("Was my guess too high or too low?\n");
    }
    
    public void showEndMessage(int t)
    {
        textArea.append("I win! It took me " + t + " turns to guess your number!\nPlay again?");
    }
    
    // ---------------------- Other Methods ------------------------------
    
    // Used to close GUI
    public void closeGUI()
    {  
        // Show exit message
        JOptionPane.showMessageDialog(rootPane, "Goodbye!", "Thanks for playing!",JOptionPane.INFORMATION_MESSAGE);
        super.dispose();
    }
    
     // Used to disable a button on buttonPanel
    public void disable(int b)
    {
        buttonsPanel.disableButton(b);
    }
    
    // Used to enable a button on buttonPanel
    public void enable(int b)
    {
        buttonsPanel.enableButton(b);
    }
    
    // Used to erase all text from textArea
    public void clearText()
    {
        textArea.clear();
    }
}



   


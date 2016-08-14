/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberguessmain;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MainFrame extends JFrame
{   
    // --------------------- Instance variables --------------------- 
    
    // Holds the Frame's layout manager
    private BorderLayout layout;
    // Holds content pane
    private Container content;
    // Holds width of frame
    private final int frameWidth = 500 ;
    // Holds length of frame
    private final int frameLength = 200;
    // Displays messages to the user
    private JTextArea textArea;
    // Holds control buttons
    private JPanel buttonsPanel;
    // Holds font details for textArea
    private Font fontDetails;
    
    // --------------------- Instance variables ---------------------    
    
    // Constructor
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
          
        ///////////////////////// Buttons Panel /////////////////////////     
        
        // Create buttons panel
        buttonsPanel = new ButtonPanel();
        // Add button panel to the western portion of the window
        content.add(buttonsPanel,BorderLayout.WEST);
        
        ///////////////////////// Text Area ///////////////////////// 
        
        // Create text area component
        textArea = new JTextArea();
        textArea.setEditable(false);
        
        // Create Font
        fontDetails = new Font("Arial",Font.BOLD,11);
        // Set font
        textArea.setFont(fontDetails);
        textArea.setForeground(Color.black);
        
        textArea.append("Welcome!\nWould you like to start a new game?");
        
        // Add to content pane
        content.add(textArea,BorderLayout.CENTER);
    }
}



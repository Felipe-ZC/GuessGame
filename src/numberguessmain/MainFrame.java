/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberguessmain;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MainFrame extends JFrame
{   
    // --------------------- Instance variables --------------------- 
    
    // Holds the Frame's layout manager
    GridBagLayout layout;
    // Holds the layout maanager's constraints
    GridBagConstraints constraints;
    // Holds content pane
    Container content;
    // Holds width of frame
    final int frameWidth = 300;
    // Holds length of frame
    final int frameLength = 300;
    // Buttons
    JButton yes;
    JButton no;
    JButton tooHigh;
    JButton tooLow;
    // Displays messages to the user
    JTextArea textArea;
    
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
        layout = new GridBagLayout();
        // Instantiate constriants
        constraints = new GridBagConstraints();
                
        // Set layout manager of frame
        setLayout(layout);
        
        ///////////////////////// Text Area   ///////////////////////// 
        
        // Create text area component
        textArea = new JTextArea(500,30);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord (true);
        // Disable editing
        //textArea.setEditable(false);
        
        // Set weight 
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        
        // Set x and y coordinates
        constraints.gridx = 0;
        constraints.gridy = 0;
        
        constraints.anchor = GridBagConstraints.PAGE_START ;
        
        // Set width and height
        constraints.gridheight = 50;
        constraints.gridwidth = 20;
        constraints.ipady = 50;
       // constraints.fill = GridBagConstraints.HORIZONTAL;
        
        // Add to frame
       content.add(textArea,constraints);
       
    }
}


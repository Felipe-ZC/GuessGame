package numberguessmain;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author zu
 */
public class ButtonPanel extends JPanel
{   
    // Buttons
    JButton yesButton;
    JButton noButton;
    JButton tooHighButton;
    JButton tooLowButton;
    
    // Holds layout manager
    GridBagLayout layout;
    GridBagConstraints constraints;
    
    // Constructor
    public ButtonPanel()
    {
        Dimension size = getPreferredSize();
        // Set width of panel in pixels
        size.width = 200;
        // Set panel size
        setPreferredSize(size); 
        // Set panel title
        setBorder(BorderFactory.createTitledBorder("Controls"));
        
        // Initialize buttons
        yesButton = new JButton("Yes");
        noButton = new JButton("No");
        tooHighButton = new JButton("Too high");
        tooLowButton = new JButton("Too low");
        
        // Set layout of panel
        layout = new GridBagLayout();
        setLayout(layout);
        
        // Add yes button
        createYesButton();
        // Add no button
        createNoButton();
        // Add too high button
        createTooHighButton();
        // Add too low button
        createTooLowButton();
        
    }
    
    // Creates "Yes" button
    private void createYesButton()
    {
        // Create new constraints
        constraints = new GridBagConstraints();
        
        // Set constraints
        constraints.weightx = 0.1;
        constraints.weighty = 0.1;
        constraints.gridx = 0;
        constraints.gridy = 0;
        
        // Set fill
        constraints.fill = GridBagConstraints.BOTH;
               
        // Set anchor
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        
        // Add to panel
        add(yesButton,constraints);
    }
    
    // Creates "No" button
    private void createNoButton()
    {
        // Create new constraints
        constraints = new GridBagConstraints();
        
        // Set constraints
        constraints.weightx = 0.1;
        constraints.weighty = 0.1;
        constraints.gridx = 1;
        constraints.gridy = 0;
        
        // Set fill
        constraints.fill = GridBagConstraints.BOTH;
        
        // Set anchor
        constraints.anchor = GridBagConstraints.PAGE_START;
        
        // Add to panel
        add(noButton,constraints);       
    }
    
    // Creates "Too high" button
    private void createTooHighButton()
    {
        // Create new constraints
        constraints = new GridBagConstraints();
        
        // Set constraints
        constraints.weightx = 0.1;
        constraints.weighty = 0.1;
        constraints.gridx = 0;
        constraints.gridy = 1;
        
        // Set fill
        constraints.fill = GridBagConstraints.BOTH;
        
        // Set anchor
        constraints.anchor = GridBagConstraints.LINE_START;
        
        // Add to panel
        add(tooHighButton,constraints);               
    }
    
    // Creaes "Too low" button
    private void createTooLowButton()
    {
        // Create new constraints
        constraints = new GridBagConstraints();
        
        // Set constraints
        constraints.weightx = 0.1;
        constraints.weighty = 0.1;
        constraints.gridx = 1;
        constraints.gridy = 1;
        
        // Set fill
        constraints.fill = GridBagConstraints.BOTH;
        
        // Set anchor
        constraints.anchor = GridBagConstraints.LINE_END;
        
        // Add to panel
        add(tooLowButton,constraints);            
    }
}

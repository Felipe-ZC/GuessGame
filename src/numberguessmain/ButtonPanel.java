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
    private JButton yesButton;
    private JButton noButton;
    private JButton tooHighButton;
    private JButton tooLowButton;
    
    // Represents each button, used for disabling or enabling a button
    private final int YES_BUTTON;
    private final int NO_BUTTON;
    private final int TOO_HIGH_BUTTON;
    private final int TOO_LOW_BUTTON;
    
    // Holds layout manager
    private GridBagLayout layout;
    private GridBagConstraints constraints;
    
    // Constructor
    public ButtonPanel()
    {
        // Initialize constants
        YES_BUTTON = 0;
        NO_BUTTON = 1;
        TOO_HIGH_BUTTON = 2;
        TOO_LOW_BUTTON = 3;
        
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
    
    // --------------------------- Accessor Methods --------------------------
    
    public JButton getYesButton()
    {
        return yesButton;
    }
    public JButton getNoButton()
    {
        return noButton;
    }
    public JButton getTooHighButton()
    {
        return tooHighButton;
    }
    public JButton getTooLowButton()
    {
        return tooLowButton;
    }
    
    // --------------------------- Mutator Methods ---------------------------
    
    // Creates "Yes" button
    private void createYesButton()
    {
        // Create new constraints
        constraints = new GridBagConstraints();
        
        // Set constraints
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        constraints.gridx = 0;
        constraints.gridy = 0;
        
        // Set fill
        constraints.fill = GridBagConstraints.BOTH;
               
        // Set anchor
        //constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        
        // Add to panel
        add(yesButton,constraints);
    }
    
    // Creates "No" button
    private void createNoButton()
    {
        // Create new constraints
        constraints = new GridBagConstraints();
        
        // Set constraints
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        constraints.gridx = 1;
        constraints.gridy = 0;
        
        // Set fill
        constraints.fill = GridBagConstraints.BOTH;
        
        // Set anchor
       // constraints.anchor = GridBagConstraints.PAGE_START;
        
        // Add to panel
        add(noButton,constraints);       
    }
    
    // Creates "Too high" button
    private void createTooHighButton()
    {
        // Create new constraints
        constraints = new GridBagConstraints();
        
        // Set constraints
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        constraints.gridx = 0;
        constraints.gridy = 1;
        
        // Set fill
        constraints.fill = GridBagConstraints.BOTH;
        
        // Set anchor
       // constraints.anchor = GridBagConstraints.LINE_START;
        
        // Set disabled on start
        tooHighButton.setEnabled(false);
        
        // Add to panel
        add(tooHighButton,constraints);               
    }
    
    // Creaes "Too low" button
    private void createTooLowButton()
    {
        // Create new constraints
        constraints = new GridBagConstraints();
        
        // Set constraints
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        constraints.gridx = 1;
        constraints.gridy = 1;
        
        // Set fill
        constraints.fill = GridBagConstraints.BOTH;
        
        // Set anchor
       // constraints.anchor = GridBagConstraints.LINE_END;
        
        // Set disabled on start
        tooLowButton.setEnabled(false);
        
        // Add to panel
        add(tooLowButton,constraints);            
    }
    
    // --------------------------- Other Methods ---------------------------
    
    /*
    Disables specfied button
    0 for yes button
    1 for no button
    2 for too high button
    3 for too low button
    */
    public void disableButton(int button)
    {
        switch(button)
        {
            case 0:
                yesButton.setEnabled(false);
                break;
            case 1:
                noButton.setEnabled(false);
                break;
            case 2:
                tooHighButton.setEnabled(false);
                break;
            case 3:
                tooLowButton.setEnabled(false);
                break;
            default:
                break;      
        }
    }
    
    /*
    Enables specfied button
    0 for yes button
    1 for no button
    2 for too high button
    3 for too low button
    */
    public void enableButton(int button)
    {
        switch(button)
        {
            case 0:
                yesButton.setEnabled(true);
                break;
            case 1:
                noButton.setEnabled(true);
                break;
            case 2:
                tooHighButton.setEnabled(true);
                break;
            case 3:
                tooLowButton.setEnabled(true);
                break;
            default:
                break;      
        }
    }
}   

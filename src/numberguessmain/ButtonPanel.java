package numberguessmain;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Holds the controls for the GuessGame GUI, contains 4 buttons that
 * enable or disable depending on the state of the GuessGame.
 * @author Felipe Zuniga
 */
public class ButtonPanel extends JPanel
{   
    /**
     *  This button is used to confirm actions with the
     * GUI.
     */
    private JButton yesButton;
    
    /**
     *  This button is used deny actions on the GUI.
     */
    private JButton noButton;
    
    /**
     * This button is used to indicate that the number
     * the computer guessed was too high.
     */
    private JButton tooHighButton;
    
    /**
     * This button is used to indicate that the number
     * the computer guessed was too low.
     */
    private JButton tooLowButton;
    
    // Holds layout manager
    private GridBagLayout layout;
    private GridBagConstraints constraints;
    
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
    
    /**
     * Sets constraints for yes button and adds it to the panel.
     */
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
    
    /**
     * Sets constraints for no button and adds it to the panel.
     */
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
    
    /**
     * Sets constraints for too high button and adds it to the panel.
     */
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
    
    /**
     * Sets constraints for too low button and adds it to the panel.
     */
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
    
    /**
     * Disables the specified button on the panel.
     * @param button The button to disable:
     * 0 disables the yes button
     * 1 disables the no button
     * 2 disables the too high button
     * 3 disables the too low button
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
    
    /**
     * Enables the specified button on the panel.
     * @param button The button to enable:
     * 0 enables the yes button
     * 1 enables the no button
     * 2 enables the too high button
     * 3 enables the too low button
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

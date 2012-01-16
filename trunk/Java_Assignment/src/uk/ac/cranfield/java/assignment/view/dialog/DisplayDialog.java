package uk.ac.cranfield.java.assignment.view.dialog;


import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeListener;

import uk.ac.cranfield.java.assignment.controller.interfaces.DialogClient;
import uk.ac.cranfield.java.assignment.controller.utils.TextFieldFactory;
import uk.ac.cranfield.java.assignment.view.component.DimensionSlider;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

/**
 * This abstract class extends {@link NDialog} Provides common components for all shapes dialog.
 * @author Mateusz Golab
 * @version 1.0
 * @see NDialog, ChangeListener
 */
@SuppressWarnings("serial")
public abstract class DisplayDialog extends NDialog implements ChangeListener
{
    
    /**
     * maximum radius size
     */
    protected static int MAX_RADIUS = 401;
    
    /**
     * maximum number of shapes
     */
    private static int MAX_SHAPES_NUMBER = 50;
    
    /**
     * Major tick interval
     */
    private static int MAJOR_TICK = 7;
    
    /**
     * The title of the dialog
     */
    private String title;
    
    /**
     * Number of shapes label
     */
    private JLabel numberLabel;
    
    /**
     * The instance of DimensionSlider for setting the number of shapes.
     */
    protected DimensionSlider number;
    
    /**
     * Instance of constraints for components that are laid out with the FormLayout
     */
    protected CellConstraints cc;
    
    /**
     * Instance of FormLayout
     */
    protected FormLayout layout;
    
    /**
     * Instance of main panel of the dialog
     */
    protected JPanel panel;
    
    /**
     * button to accept dialog state
     */
    protected JButton okButton;
    
    /**
     * button to cancel dialog use
     */
    private JButton cancelButton;
    
    /**
     * Instance of panel containing buttons
     */
    private JPanel southPanel;
    
    /**
     * Number of shapes text field for showing exact number
     */
    protected JTextField numberText;
    
    /**
     * The constructor used by specialised shape dialog classes to create and initialize common components.
     * @param frame dialog parent frame
     * @param title the title of the dialog
     * @param dialogClient dialog client
     */
    public DisplayDialog(Frame frame, String title, DialogClient dialogClient)
    {
        super(frame, title + "s display dialog", dialogClient, true);
        this.title = title;
        this.panel = new JPanel();
        this.southPanel = new JPanel();
        
        setLayout();
        create();
        init();
        addListeners();
        add(panel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
        pack();
        
    }
    
    /**
     * The abstract method setting creating and setting proper layout for the main panel of the dialog.
     */
    protected abstract void setLayout();
    
    /**
     * Creates dialog common components.
     */
    protected void create()
    {
        numberLabel = new JLabel("Number of " + title + "s :");
        number = new DimensionSlider(1, MAX_SHAPES_NUMBER, MAX_SHAPES_NUMBER / 2, MAJOR_TICK);
        numberText = TextFieldFactory.createIntegerTextField(number.getValue());
        
        okButton = new JButton("Ok");
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new CancelButtonAction());
    }
    
    /**
     * Initializes main panel of the dialog with common components.
     * Instance od constraints is also initialized in this method.
     */
    protected void init()
    {
        cc = new CellConstraints();
        panel.add(numberLabel, cc.xy(2, 2));
        panel.add(numberText, cc.xy(4, 2));
        panel.add(number, cc.xy(6, 2));
        
        southPanel.add(okButton);
        southPanel.add(cancelButton);
    }
    
    /**
     * This method is responsible for changing dialog state to the initial one.
     */
    public void reset()
    {
        pack();
        number.reset();
        numberText.setText(Integer.toString(number.getValue()));
    }
    
    /**
     * This method adds common listeners to the dialog components.
     */
    protected void addListeners()
    {
        number.addChangeListener(this);
        addWindowListener(new DialogAdapter());
    }
    
    /**
     * This private class implements {@link ActionListener}.
     * Provides dialog closing mechanism.
     * @author Mateusz Golab
     * @version 1.0
     * @see ActionListener
     */
    private class CancelButtonAction implements ActionListener
    {
        
        /**
         * Closes the dialog.
         */
        @Override
        public void actionPerformed(ActionEvent e)
        {
            dispose();
        }
        
    }
    
    /**
     * This private class extends {@link WindowAdapter}.
     * Provides dialog closing mechanism for dialog close button.
     * @author Mateusz Golab
     * @version 1.0
     * @see WindowAdapter
     */
    private class DialogAdapter extends WindowAdapter
    {
        
        /**
         * Closes the dialog.
         */
        @Override
        public void windowClosing(WindowEvent we)
        {
            dispose();
        }
    }
    
    
}

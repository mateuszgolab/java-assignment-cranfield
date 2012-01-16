package uk.ac.cranfield.java.assignment.view.dialog;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;

import uk.ac.cranfield.java.assignment.controller.interfaces.DialogClient;
import uk.ac.cranfield.java.assignment.controller.utils.TextFieldFactory;
import uk.ac.cranfield.java.assignment.model.info.CircleDialogInfo;
import uk.ac.cranfield.java.assignment.view.component.DimensionSlider;

import com.jgoodies.forms.layout.FormLayout;

/**
 * This class extends {@link DisplayDialog} Represents the dialog component for Circle.
 * Provides the interface for the user to select number of objects and shapes boundary dimensions.
 * @author Mateusz Golab
 * @version 1.0
 * @see DisplayDialog
 */
@SuppressWarnings("serial")
public class CircleDisplayDialog extends DisplayDialog
{
    
    /**
     * Major tick interval for Circle
     */
    private static int MAJOR_TICK = 100;
    
    /**
     * Minor tick interval for Circle.
     */
    private static int MINOR_TICK = 50;
    
    /**
     * minimum radius label
     */
    private JLabel minRadiusLabel;
    
    /**
     * maximum radius label
     */
    private JLabel maxRadiusLabel;
    
    /**
     * The instance of DimensionSlider for setting the minimum radius.
     */
    private DimensionSlider minRadius;
    
    /**
     * The instance of DimensionSlider for setting the maximum radius.
     */
    private DimensionSlider maxRadius;
    
    /**
     * minimum radius text field for showing exact number
     */
    private JTextField minRadiusText;
    
    /**
     * maximum radius text field for showing exact number
     */
    private JTextField maxRadiusText;
    
    /**
     * Instance of bean containing user choices from the dialog.
     */
    private CircleDialogInfo info;
    
    
    /**
     * This constructor creates new dialog for Circle shape
     * Initializes Circle bean (CircleDialogInfo)
     * @param frame dialog's parent frame
     * @param title the title of the dialog
     * @param dialogClient Circle dialog client
     */
    public CircleDisplayDialog(Frame frame, String title, DialogClient dialogClient)
    {
        super(frame, title, dialogClient);
        this.info = new CircleDialogInfo();
    }
    
    /**
     * Creates and sets the form layout for the dialog components.
     */
    @Override
    protected void setLayout()
    {
        layout = new FormLayout("5dlu, pref, 10dlu,pref , 10dlu, fill:pref:grow,10dlu, pref, 5dlu, pref",
                "5dlu, pref, 5dlu, pref,  5dlu, pref, 5dlu, pref,  5dlu, pref, 5dlu");
        panel.setLayout(layout);
        
    }
    
    /**
     * Creates Circle dialog components
     */
    @Override
    protected void create()
    {
        super.create();
        
        minRadiusLabel = new JLabel("Minimum radius :");
        maxRadiusLabel = new JLabel("Maximum radius :");
        
        minRadius = new DimensionSlider(1, MAX_RADIUS, 1, MINOR_TICK, MAJOR_TICK);
        maxRadius = new DimensionSlider(1, MAX_RADIUS, MAX_RADIUS / 2, MINOR_TICK, MAJOR_TICK);
        
        minRadiusText = TextFieldFactory.createDecimalTextField(minRadius.getValue());
        maxRadiusText = TextFieldFactory.createDecimalTextField(maxRadius.getValue());
        
    }
    
    /**
     * Initializes the main panel of the dialog.
     * Adds all components to the panel.
     */
    @Override
    protected void init()
    {
        super.init();
        
        panel.add(minRadiusLabel, cc.xy(2, 4));
        panel.add(minRadiusText, cc.xy(4, 4));
        panel.add(minRadius, cc.xy(6, 4));
        panel.add(maxRadiusLabel, cc.xy(2, 6));
        panel.add(maxRadiusText, cc.xy(4, 6));
        panel.add(maxRadius, cc.xy(6, 6));
        
    }
    
    /**
     * This method is responsible for changing dialog state to the initial one.
     */
    @Override
    public void reset()
    {
        super.reset();
        
        minRadius.reset();
        maxRadius.reset();
        
        minRadiusText.setText(Double.toString(minRadius.getValue()));
        maxRadiusText.setText(Double.toString(maxRadius.getValue()));
    }
    
    
    /**
     * This method adds listeners to the dialog components.
     */
    @Override
    protected void addListeners()
    {
        super.addListeners();
        okButton.addActionListener(new OkButtonAction());
        minRadius.addChangeListener(this);
        maxRadius.addChangeListener(this);
    }
    
    /**
     * This method is the implementation of ChangeListener interface method.
     * It updates the text fields with the values selected on the sliders.
     */
    @Override
    public void stateChanged(ChangeEvent e)
    {
        JSlider source = (JSlider) e.getSource();
        if (!source.getValueIsAdjusting())
        {
            if (source.equals(number))
                numberText.setText(Integer.toString(number.getValue()));
            else if (source.equals(minRadius))
                minRadiusText.setText(Double.toString(minRadius.getValue()));
            else if (source.equals(maxRadius))
                maxRadiusText.setText(Double.toString(maxRadius.getValue()));
        }
    }
    
    /**
     * This private class implements {@link ActionListener}.
     * Initializes Circle bean with values selected by the user.
     * @author Mateusz Golab
     * @version 1.0
     * @see ActionListener
     */
    private class OkButtonAction implements ActionListener
    {
        
        /**
         * This method sets Circle bean after successfully checked boundary values.
         * Prints the error if boundaries are not set properly.
         */
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (areRangesOk())
            {
                info.setNumberOfObjects(number.getValue());
                info.setMaxRadius(maxRadius.getValue());
                info.setMinRadius(minRadius.getValue());
                
                dispose();
                client.dialogDismissed(CircleDisplayDialog.this, info);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "minimum range of radius is greater or equal then maximum",
                        "Range error", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        
        /**
         * Checks if minimum dimension is less than maximum
         * @return the result of checking
         */
        private boolean areRangesOk()
        {
            if (minRadius.getValue() >= maxRadius.getValue())
                return false;
            return true;
        }
        
    }
    
}

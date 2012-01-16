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
import uk.ac.cranfield.java.assignment.model.info.EllipseDialogInfo;
import uk.ac.cranfield.java.assignment.view.component.DimensionSlider;

import com.jgoodies.forms.layout.FormLayout;


@SuppressWarnings("serial")
public class EllipseDisplayDialog extends DisplayDialog
{
    
    /**
     * Major tick interval for Ellipse
     */
    private static int MAJOR_TICK = 100;
    
    /**
     * Minor tick interval for Ellipse.
     */
    private static int MINOR_TICK = 50;
    
    /**
     * Minimum minor radius label
     */
    private JLabel minMinorRadiusLabel;
    
    /**
     * Maximum minor radius label
     */
    private JLabel maxMinorRadiusLabel;
    
    /**
     * Minimum major radius label
     */
    private JLabel minMajorRadiusLabel;
    
    /**
     * Maximum major radius label
     */
    private JLabel maxMajorRadiusLabel;
    
    
    /**
     * The instance of DimensionSlider for setting the minimum minor radius.
     */
    private DimensionSlider minMinorRadius;
    
    /**
     * The instance of DimensionSlider for setting the maximum minor radius.
     */
    private DimensionSlider maxMinorRadius;
    
    /**
     * The instance of DimensionSlider for setting the minimum major radius.
     */
    private DimensionSlider minMajorRadius;
    
    /**
     * The instance of DimensionSlider for setting the maximum major radius.
     */
    private DimensionSlider maxMajorRadius;
    
    /**
     * minimum minor radius text field for showing exact number
     */
    private JTextField minMinorRadiusText;
    
    /**
     * maximum minor radius text field for showing exact number
     */
    private JTextField maxMinorRadiusText;
    
    /**
     * minimum major radius text field for showing exact number
     */
    private JTextField minMajorRadiusText;
    
    /**
     * maximum major radius text field for showing exact number
     */
    private JTextField maxMajorRadiusText;
    
    /**
     * Instance of bean containing user choices from the dialog.
     */
    private EllipseDialogInfo info;
    
    /**
     * This constructor creates new dialog for Ellipse shape
     * Initializes Ellipse bean (EllipseDialogInfo)
     * @param frame dialog's parent frame
     * @param title the title of the dialog
     * @param dialogClient Ellipse dialog client
     */
    public EllipseDisplayDialog(Frame frame, String title, DialogClient dialogClient)
    {
        super(frame, title, dialogClient);
        this.info = new EllipseDialogInfo();
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
     * Creates Ellipse dialog components
     */
    @Override
    protected void create()
    {
        super.create();
        
        
        minMinorRadiusLabel = new JLabel("Minimum minor radius :");
        maxMinorRadiusLabel = new JLabel("Maximum minor radius :");
        minMajorRadiusLabel = new JLabel("Minimum major radius :");
        maxMajorRadiusLabel = new JLabel("Maximum major radius :");
        
        
        minMinorRadius = new DimensionSlider(1, MAX_RADIUS, 1, MINOR_TICK, MAJOR_TICK);
        maxMinorRadius = new DimensionSlider(1, MAX_RADIUS, MAX_RADIUS / 4, MINOR_TICK, MAJOR_TICK);
        minMajorRadius = new DimensionSlider(1, MAX_RADIUS, 1, MINOR_TICK, MAJOR_TICK);
        maxMajorRadius = new DimensionSlider(1, MAX_RADIUS, MAX_RADIUS / 2, MINOR_TICK, MAJOR_TICK);
        
        minMinorRadiusText = TextFieldFactory.createDecimalTextField(minMinorRadius.getValue());
        maxMinorRadiusText = TextFieldFactory.createDecimalTextField(maxMinorRadius.getValue());
        minMajorRadiusText = TextFieldFactory.createDecimalTextField(minMajorRadius.getValue());
        maxMajorRadiusText = TextFieldFactory.createDecimalTextField(maxMajorRadius.getValue());
        
        
    }
    
    /**
     * Initializes the main panel of the dialog.
     * Adds all components to the panel.
     */
    @Override
    protected void init()
    {
        super.init();
        
        panel.add(minMinorRadiusLabel, cc.xy(2, 4));
        panel.add(minMinorRadiusText, cc.xy(4, 4));
        panel.add(minMinorRadius, cc.xy(6, 4));
        panel.add(maxMinorRadiusLabel, cc.xy(2, 6));
        panel.add(maxMinorRadiusText, cc.xy(4, 6));
        panel.add(maxMinorRadius, cc.xy(6, 6));
        
        panel.add(minMajorRadiusLabel, cc.xy(2, 8));
        panel.add(minMajorRadiusText, cc.xy(4, 8));
        panel.add(minMajorRadius, cc.xy(6, 8));
        panel.add(maxMajorRadiusLabel, cc.xy(2, 10));
        panel.add(maxMajorRadiusText, cc.xy(4, 10));
        panel.add(maxMajorRadius, cc.xy(6, 10));
        
        
    }
    
    /**
     * This method is responsible for changing dialog state to the initial one.
     */
    @Override
    public void reset()
    {
        super.reset();
        
        minMinorRadius.reset();
        maxMinorRadius.reset();
        minMajorRadius.reset();
        maxMajorRadius.reset();
        
        minMinorRadiusText.setText(Double.toString(minMinorRadius.getValue()));
        maxMinorRadiusText.setText(Double.toString(maxMinorRadius.getValue()));
        minMajorRadiusText.setText(Double.toString(minMajorRadius.getValue()));
        maxMajorRadiusText.setText(Double.toString(maxMajorRadius.getValue()));
    }
    
    /**
     * This method adds listeners to the dialog components.
     */
    @Override
    protected void addListeners()
    {
        super.addListeners();
        okButton.addActionListener(new OkButtonAction());
        minMinorRadius.addChangeListener(this);
        maxMinorRadius.addChangeListener(this);
        minMajorRadius.addChangeListener(this);
        maxMajorRadius.addChangeListener(this);
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
            else if (source.equals(minMinorRadius))
                minMinorRadiusText.setText(Double.toString(minMinorRadius.getValue()));
            else if (source.equals(maxMinorRadius))
                maxMinorRadiusText.setText(Double.toString(maxMinorRadius.getValue()));
            else if (source.equals(minMajorRadius))
                minMajorRadiusText.setText(Double.toString(minMajorRadius.getValue()));
            else if (source.equals(maxMajorRadius))
                maxMajorRadiusText.setText(Double.toString(maxMajorRadius.getValue()));
        }
    }
    
    /**
     * This private class implements {@link ActionListener}.
     * Initializes Ellipse bean with values selected by the user.
     * @author Mateusz Golab
     * @version 1.0
     * @see ActionListener
     */
    private class OkButtonAction implements ActionListener
    {
        
        /**
         * This method sets Ellipse bean after successfully checked boundary values.
         * Prints the error if boundaries are not set properly.
         */
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (areRangesOk())
            {
                info.setNumberOfObjects(number.getValue());
                info.setMaxMinorRadius(maxMinorRadius.getValue());
                info.setMinMinorRadius(minMinorRadius.getValue());
                info.setMaxMajorRadius(maxMajorRadius.getValue());
                info.setMinMajorRadius(minMajorRadius.getValue());
                
                dispose();
                client.dialogDismissed(EllipseDisplayDialog.this, info);
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
            if ((minMinorRadius.getValue() >= maxMinorRadius.getValue())
                    || (minMajorRadius.getValue() >= maxMajorRadius.getValue()))
                return false;
            return true;
        }
        
    }
    
}

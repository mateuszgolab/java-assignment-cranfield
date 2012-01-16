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
import uk.ac.cranfield.java.assignment.model.info.RectangleDialogInfo;
import uk.ac.cranfield.java.assignment.view.component.DimensionSlider;

import com.jgoodies.forms.layout.FormLayout;

/**
 * This class extends {@link DisplayDialog} Represents the dialog component for Rectangle.
 * Provides the interface for the user to select number of objects and shapes boundary dimensions.
 * @author Mateusz Golab
 * @version 1.0
 * @see DisplayDialog
 */
@SuppressWarnings("serial")
public class RectangleDisplayDialog extends DisplayDialog
{
    
    /**
     * Maximum width for Rectangle
     */
    private static int MAX_WIDTH = 801;
    
    /**
     * Maximum height for Rectangle
     */
    private static int MAX_HEIGHT = 601;
    
    /**
     * Major height tick interval
     */
    private static int MAJOR_HEIGHT_TICK = 100;
    
    /**
     * Minor height tick interval
     */
    private static int MINOR_HEIGHT_TICK = 50;
    
    /**
     * Major width tick interval
     */
    private static int MAJOR_WIDTH_TICK = 200;
    
    /**
     * Minor width tick interval
     */
    private static int MINOR_WIDTH_TICK = 100;
    
    /**
     * Minimum length label
     */
    private JLabel minLengthLabel;
    
    /**
     * Maximum length label
     */
    private JLabel maxLengthLabel;
    
    /**
     * Minimum width label
     */
    private JLabel minWidthLabel;
    
    /**
     * Maximum width label
     */
    private JLabel maxWidthLabel;
    
    /**
     * The instance of DimensionSlider for setting the minimum length.
     */
    private DimensionSlider minLength;
    
    /**
     * The instance of DimensionSlider for setting the maximum length.
     */
    private DimensionSlider maxLength;
    
    /**
     * The instance of DimensionSlider for setting the minimum width.
     */
    private DimensionSlider minWidth;
    
    /**
     * The instance of DimensionSlider for setting the maximum width.
     */
    private DimensionSlider maxWidth;
    
    /**
     * minimum length text field for showing exact number
     */
    private JTextField minLengthText;
    
    /**
     * maximum length text field for showing exact number
     */
    private JTextField maxLengthText;
    
    /**
     * minimum width text field for showing exact number
     */
    private JTextField minWidthText;
    
    /**
     * minimum length text field for showing exact number
     */
    private JTextField maxWidthText;
    
    /**
     * Instance of bean containing user choices from the dialog.
     */
    private RectangleDialogInfo info;
    
    /**
     * This constructor creates new dialog for Rectangle shape
     * Initializes Rectangle bean (RectangleDialogInfo)
     * @param frame dialog's parent frame
     * @param title the title of the dialog
     * @param dialogClient Rectangle dialog client
     */
    public RectangleDisplayDialog(Frame frame, String title, DialogClient dialogClient)
    {
        super(frame, title, dialogClient);
        this.info = new RectangleDialogInfo();
        
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
     * Creates Rectangle dialog components
     */
    @Override
    protected void create()
    {
        super.create();
        
        minLengthLabel = new JLabel("Minimum length :");
        maxLengthLabel = new JLabel("Maximum length :");
        minWidthLabel = new JLabel("Minimum width :");
        maxWidthLabel = new JLabel("Maximum width :");
        
        minLength = new DimensionSlider(1, MAX_HEIGHT, 1, MINOR_HEIGHT_TICK, MAJOR_HEIGHT_TICK);
        maxLength = new DimensionSlider(1, MAX_HEIGHT, MAX_HEIGHT / 2, MINOR_HEIGHT_TICK, MAJOR_HEIGHT_TICK);
        minWidth = new DimensionSlider(1, MAX_WIDTH, 1, MINOR_WIDTH_TICK, MAJOR_WIDTH_TICK);
        maxWidth = new DimensionSlider(1, MAX_WIDTH, MAX_WIDTH / 2, MINOR_WIDTH_TICK, MAJOR_WIDTH_TICK);
        
        minLengthText = TextFieldFactory.createDecimalTextField(minLength.getValue());
        maxLengthText = TextFieldFactory.createDecimalTextField(maxLength.getValue());
        minWidthText = TextFieldFactory.createDecimalTextField(minWidth.getValue());
        maxWidthText = TextFieldFactory.createDecimalTextField(maxWidth.getValue());
        
        
    }
    
    /**
     * Initializes the main panel of the dialog.
     * Adds all components to the panel.
     */
    @Override
    protected void init()
    {
        super.init();
        
        panel.add(minLengthLabel, cc.xy(2, 4));
        panel.add(minLengthText, cc.xy(4, 4));
        panel.add(minLength, cc.xy(6, 4));
        panel.add(maxLengthLabel, cc.xy(2, 6));
        panel.add(maxLengthText, cc.xy(4, 6));
        panel.add(maxLength, cc.xy(6, 6));
        
        panel.add(minWidthLabel, cc.xy(2, 8));
        panel.add(minWidthText, cc.xy(4, 8));
        panel.add(minWidth, cc.xy(6, 8));
        panel.add(maxWidthLabel, cc.xy(2, 10));
        panel.add(maxWidthText, cc.xy(4, 10));
        panel.add(maxWidth, cc.xy(6, 10));
        
        
    }
    
    /**
     * This method is responsible for changing dialog state to the initial one.
     */
    @Override
    public void reset()
    {
        super.reset();
        
        minLength.reset();
        maxLength.reset();
        minWidth.reset();
        maxWidth.reset();
        
        minLengthText.setText(Double.toString(minLength.getValue()));
        maxLengthText.setText(Double.toString(maxLength.getValue()));
        minWidthText.setText(Double.toString(minWidth.getValue()));
        maxWidthText.setText(Double.toString(maxWidth.getValue()));
    }
    
    
    /**
     * This method adds listeners to the dialog components.
     */
    @Override
    protected void addListeners()
    {
        super.addListeners();
        okButton.addActionListener(new OkButtonAction());
        minLength.addChangeListener(this);
        maxLength.addChangeListener(this);
        minWidth.addChangeListener(this);
        maxWidth.addChangeListener(this);
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
            else if (source.equals(minLength))
                minLengthText.setText(Double.toString(minLength.getValue()));
            else if (source.equals(maxLength))
                maxLengthText.setText(Double.toString(maxLength.getValue()));
            else if (source.equals(minWidth))
                minWidthText.setText(Double.toString(minWidth.getValue()));
            else if (source.equals(maxWidth))
                maxWidthText.setText(Double.toString(maxWidth.getValue()));
        }
    }
    
    /**
     * This private class implements {@link ActionListener}.
     * Initializes Rectangle bean with values selected by the user.
     * @author Mateusz Golab
     * @version 1.0
     * @see ActionListener
     */
    private class OkButtonAction implements ActionListener
    {
        
        /**
         * This method sets Rectangle bean after successfully checked boundary values.
         * Prints the error if boundaries are not set properly.
         */
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (areRangesOk())
            {
                info.setNumberOfObjects(number.getValue());
                info.setMaxLength(maxLength.getValue());
                info.setMinLength(minLength.getValue());
                info.setMaxWidth(maxWidth.getValue());
                info.setMinWidth(minWidth.getValue());
                
                dispose();
                client.dialogDismissed(RectangleDisplayDialog.this, info);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "minimum range is greater or equal then maximum range",
                        "Range error", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        
        /**
         * Checks if minimum dimension is less than maximum
         * @return the result of checking
         */
        private boolean areRangesOk()
        {
            if ((minLength.getValue() >= maxLength.getValue()) || (minWidth.getValue() >= maxWidth.getValue()))
                return false;
            return true;
        }
        
    }
    
    
}

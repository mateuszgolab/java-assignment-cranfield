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


@SuppressWarnings("serial")
public class RectangleDisplayDialog extends DisplayDialog
{
    
    private static int MAX_WIDTH = 801;
    private static int MAX_HEIGHT = 601;
    private static int MAJOR_HEIGHT_TICK = 100;
    private static int MINOR_HEIGHT_TICK = 50;
    private static int MAJOR_WIDTH_TICK = 200;
    private static int MINOR_WIDTH_TICK = 100;
    private JLabel minLengthLabel;
    private JLabel maxLengthLabel;
    private JLabel minWidthLabel;
    private JLabel maxWidthLabel;
    private DimensionSlider minLength;
    private DimensionSlider maxLength;
    private DimensionSlider minWidth;
    private DimensionSlider maxWidth;
    private JTextField minLengthText;
    private JTextField maxLengthText;
    private JTextField minWidthText;
    private JTextField maxWidthText;
    private RectangleDialogInfo info;
    
    public RectangleDisplayDialog(Frame frame, String title, DialogClient dialogClient)
    {
        super(frame, title, dialogClient);
        this.info = new RectangleDialogInfo();
        
    }
    
    @Override
    protected void setLayout()
    {
        layout = new FormLayout("5dlu, pref, 10dlu,pref , 10dlu, fill:pref:grow,10dlu, pref, 5dlu, pref",
                "5dlu, pref, 5dlu, pref,  5dlu, pref, 5dlu, pref,  5dlu, pref, 5dlu");
        panel.setLayout(layout);
        
    }
    
    @Override
    protected void create()
    {
        super.create();
        
        minLengthLabel = new JLabel("Minimal length :");
        maxLengthLabel = new JLabel("Maximal length :");
        minWidthLabel = new JLabel("Minimal width :");
        maxWidthLabel = new JLabel("Maximal width :");
        
        minLength = new DimensionSlider(1, MAX_HEIGHT, 1, MINOR_HEIGHT_TICK, MAJOR_HEIGHT_TICK);
        maxLength = new DimensionSlider(1, MAX_HEIGHT, MAX_HEIGHT / 2, MINOR_HEIGHT_TICK, MAJOR_HEIGHT_TICK);
        minWidth = new DimensionSlider(1, MAX_WIDTH, 1, MINOR_WIDTH_TICK, MAJOR_WIDTH_TICK);
        maxWidth = new DimensionSlider(1, MAX_WIDTH, MAX_WIDTH / 2, MINOR_WIDTH_TICK, MAJOR_WIDTH_TICK);
        
        minLengthText = TextFieldFactory.createDecimalTextField(minLength.getValue());
        maxLengthText = TextFieldFactory.createDecimalTextField(maxLength.getValue());
        minWidthText = TextFieldFactory.createDecimalTextField(minWidth.getValue());
        maxWidthText = TextFieldFactory.createDecimalTextField(maxWidth.getValue());
        
        
    }
    
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
    
    private class OkButtonAction implements ActionListener
    {
        
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
        
        private boolean areRangesOk()
        {
            if ((minLength.getValue() >= maxLength.getValue()) || (minWidth.getValue() >= maxWidth.getValue()))
                return false;
            return true;
        }
        
    }
    
    
}

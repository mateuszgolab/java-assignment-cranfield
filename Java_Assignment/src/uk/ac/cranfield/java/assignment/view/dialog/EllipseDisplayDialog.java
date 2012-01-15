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
    
    private static int MAJOR_TICK = 100;
    private static int MINOR_TICK = 50;
    private JLabel minMinorRadiusLabel;
    private JLabel maxMinorRadiusLabel;
    private JLabel minMajorRadiusLabel;
    private JLabel maxMajorRadiusLabel;
    private DimensionSlider minMinorRadius;
    private DimensionSlider maxMinorRadius;
    private DimensionSlider minMajorRadius;
    private DimensionSlider maxMajorRadius;
    private JTextField minMinorRadiusText;
    private JTextField maxMinorRadiusText;
    private JTextField minMajorRadiusText;
    private JTextField maxMajorRadiusText;
    private EllipseDialogInfo info;
    
    public EllipseDisplayDialog(Frame frame, String title, DialogClient dialogClient)
    {
        super(frame, title, dialogClient);
        this.info = new EllipseDialogInfo();
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
        
        
        minMinorRadiusLabel = new JLabel("Minimal minor radius :");
        maxMinorRadiusLabel = new JLabel("Maximal minor radius :");
        minMajorRadiusLabel = new JLabel("Minimal major radius :");
        maxMajorRadiusLabel = new JLabel("Maximal major radius :");
        
        
        minMinorRadius = new DimensionSlider(1, MAX_RADIUS, 1, MINOR_TICK, MAJOR_TICK);
        maxMinorRadius = new DimensionSlider(1, MAX_RADIUS, MAX_RADIUS / 4, MINOR_TICK, MAJOR_TICK);
        minMajorRadius = new DimensionSlider(1, MAX_RADIUS, 1, MINOR_TICK, MAJOR_TICK);
        maxMajorRadius = new DimensionSlider(1, MAX_RADIUS, MAX_RADIUS / 2, MINOR_TICK, MAJOR_TICK);
        
        minMinorRadiusText = TextFieldFactory.createDecimalTextField(minMinorRadius.getValue());
        maxMinorRadiusText = TextFieldFactory.createDecimalTextField(maxMinorRadius.getValue());
        minMajorRadiusText = TextFieldFactory.createDecimalTextField(minMajorRadius.getValue());
        maxMajorRadiusText = TextFieldFactory.createDecimalTextField(maxMajorRadius.getValue());
        
        
    }
    
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
    
    private class OkButtonAction implements ActionListener
    {
        
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
        
        private boolean areRangesOk()
        {
            if ((minMinorRadius.getValue() >= maxMinorRadius.getValue())
                    || (minMajorRadius.getValue() >= maxMajorRadius.getValue()))
                return false;
            return true;
        }
        
    }
    
}

package uk.ac.cranfield.java.assignment.view.dialog;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;

import uk.ac.cranfield.java.assignment.controller.dialog.DialogClient;
import uk.ac.cranfield.java.assignment.model.info.EllipseDialogInfo;
import uk.ac.cranfield.java.assignment.view.DrawPanel;

import com.jgoodies.forms.layout.FormLayout;


public class EllipseDisplayDialog extends DisplayDialog
{
    
    private JLabel minMinorRadiusLabel;
    private JLabel maxMinorRadiusLabel;
    private JLabel minMajorRadiusLabel;
    private JLabel maxMajorRadiusLabel;
    private JSlider minMinorRadius;
    private JSlider maxMinorRadius;
    private JSlider minMajorRadius;
    private JSlider maxMajorRadius;
    private JTextField minMinorRadiusText;
    private JTextField maxMinorRadiusText;
    private JTextField minMajorRadiusText;
    private JTextField maxMajorRadiusText;
    private EllipseDialogInfo info;
    
    public EllipseDisplayDialog(Frame frame, String title, DialogClient dialogClient, DrawPanel drawPanel)
    {
        super(frame, title, dialogClient, drawPanel);
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
        
        
        minMinorRadiusLabel = new JLabel("minimal minor radius");
        maxMinorRadiusLabel = new JLabel("maximal minor radius");
        minMajorRadiusLabel = new JLabel("minimal major radius");
        maxMajorRadiusLabel = new JLabel("maximal major radius");
        
        
        minMinorRadius = factory.createSlider(0, drawPanel.getHeight() / 2, 0, 50, 100);
        maxMinorRadius = factory.createSlider(0, drawPanel.getHeight() / 2, drawPanel.getHeight() / 4, 50, 100);
        minMajorRadius = factory.createSlider(0, drawPanel.getWidth() / 2, 0, 100, 200);
        maxMajorRadius = factory.createSlider(0, drawPanel.getWidth() / 2, drawPanel.getWidth() / 4, 50, 100);
        
        minMinorRadiusText = factory.createTextField(minMinorRadius.getValue());
        maxMinorRadiusText = factory.createTextField(maxMinorRadius.getValue());
        minMajorRadiusText = factory.createTextField(minMinorRadius.getValue());
        maxMajorRadiusText = factory.createTextField(maxMinorRadius.getValue());
        
        
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
                minMinorRadiusText.setText(Integer.toString(minMinorRadius.getValue()));
            else if (source.equals(maxMinorRadius))
                maxMinorRadiusText.setText(Integer.toString(maxMinorRadius.getValue()));
            else if (source.equals(minMajorRadius))
                minMajorRadiusText.setText(Integer.toString(minMajorRadius.getValue()));
            else if (source.equals(maxMajorRadius))
                maxMajorRadiusText.setText(Integer.toString(maxMajorRadius.getValue()));
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
                client.dialogDimissed(EllipseDisplayDialog.this, info);
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

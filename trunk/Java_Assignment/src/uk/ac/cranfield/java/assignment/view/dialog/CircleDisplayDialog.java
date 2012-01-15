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
import uk.ac.cranfield.java.assignment.model.info.CircleDialogInfo;
import uk.ac.cranfield.java.assignment.view.DrawPanel;

import com.jgoodies.forms.layout.FormLayout;


public class CircleDisplayDialog extends DisplayDialog
{
    
    private JLabel minRadiusLabel;
    private JLabel maxRadiusLabel;
    private JSlider minRadius;
    private JSlider maxRadius;
    private JTextField minRadiusText;
    private JTextField maxRadiusText;
    private CircleDialogInfo info;
    
    public CircleDisplayDialog(Frame frame, String title, DialogClient dialogClient, DrawPanel drawPanel)
    {
        super(frame, title, dialogClient, drawPanel);
        this.info = new CircleDialogInfo();
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
        
        minRadiusLabel = new JLabel("minimal radius");
        maxRadiusLabel = new JLabel("maximal radius");
        
        minRadius = factory.createSlider(0, drawPanel.getHeight() / 2, 0, 50, 100);
        maxRadius = factory.createSlider(0, drawPanel.getHeight() / 2, drawPanel.getHeight() / 4, 50, 100);
        
        minRadiusText = factory.createTextField(minRadius.getValue());
        maxRadiusText = factory.createTextField(maxRadius.getValue());
        
    }
    
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
    
    @Override
    protected void addListeners()
    {
        super.addListeners();
        okButton.addActionListener(new OkButtonAction());
        minRadius.addChangeListener(this);
        maxRadius.addChangeListener(this);
    }
    
    @Override
    public void stateChanged(ChangeEvent e)
    {
        JSlider source = (JSlider) e.getSource();
        if (!source.getValueIsAdjusting())
        {
            if (source.equals(number))
                numberText.setText(Integer.toString(number.getValue()));
            else if (source.equals(minRadius))
                minRadiusText.setText(Integer.toString(minRadius.getValue()));
            else if (source.equals(maxRadius))
                maxRadiusText.setText(Integer.toString(maxRadius.getValue()));
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
                info.setMaxRadius(maxRadius.getValue());
                info.setMinRadius(minRadius.getValue());
                
                dispose();
                client.dialogDimissed(CircleDisplayDialog.this, info);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "minimum range of radius is greater or equal then maximum",
                        "Range error", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        
        private boolean areRangesOk()
        {
            if (minRadius.getValue() >= maxRadius.getValue())
                return false;
            return true;
        }
        
    }
    
}
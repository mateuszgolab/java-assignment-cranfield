package uk.ac.cranfield.java.assignment.view.dialog;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;

import uk.ac.cranfield.java.assignment.controller.RectangleDrawer;
import uk.ac.cranfield.java.assignment.controller.utils.RandomColorGenerator;
import uk.ac.cranfield.java.assignment.controller.utils.RandomNumbersGenerator;
import uk.ac.cranfield.java.assignment.model.dialog.DialogClient;
import uk.ac.cranfield.java.assignment.model.dialog.info.DialogInfo;
import uk.ac.cranfield.java.assignment.model.shape.Rectangle;
import uk.ac.cranfield.java.assignment.view.DrawPanel;

import com.jgoodies.forms.layout.FormLayout;


public class RectangleDisplayDialog extends DisplayDialog
{
    
    
    private JLabel minLengthLabel;
    private JLabel maxLengthLabel;
    private JLabel minWidthLabel;
    private JLabel maxWidthLabel;
    private JSlider minLength;
    private JSlider maxLength;
    private JSlider minWidth;
    private JSlider maxWidth;
    private JTextField minLengthText;
    private JTextField maxLengthText;
    private JTextField minWidthText;
    private JTextField maxWidthText;
    private Rectangle[] rectangles;
    
    public RectangleDisplayDialog(Frame frame, String title, DialogClient dialogClient, DialogInfo info,
            DrawPanel drawPanel)
    {
        super(frame, title, dialogClient, info, drawPanel);
    }
    
    @Override
    protected void setLayout()
    {
        layout = new FormLayout("5dlu, pref, 10dlu,pref , 10dlu, fill:pref:grow,10dlu, pref, 5dlu, pref",
                "5dlu, pref, 5dlu, pref,  5dlu, pref, 5dlu, pref,  5dlu, pref, 5dlu");
        panel.setLayout(layout);
        // panel.setLayout(new GridLayout(4, 2));
        
    }
    
    @Override
    protected void create()
    {
        super.create();
        
        okButton.addActionListener(new OkButtonAction());
        
        minLengthLabel = new JLabel("minimal length");
        maxLengthLabel = new JLabel("maximal length");
        minWidthLabel = new JLabel("minimal width");
        maxWidthLabel = new JLabel("maximal width");
        
        
        minLength = factory.createSlider(0, drawPanel.getHeight(), 0, 50, 100);
        maxLength = factory.createSlider(0, drawPanel.getHeight(), drawPanel.getHeight() / 2, 50, 100);
        minWidth = factory.createSlider(0, drawPanel.getWidth(), 0, 100, 200);
        maxWidth = factory.createSlider(0, drawPanel.getWidth(), drawPanel.getWidth() / 2, 100, 200);
        
        minLengthText = factory.createTextField(minLength.getValue());
        maxLengthText = factory.createTextField(maxLength.getValue());
        minWidthText = factory.createTextField(minLength.getValue());
        maxWidthText = factory.createTextField(maxLength.getValue());
        
        
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
    protected void addListeners()
    {
        super.addListeners();
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
                minLengthText.setText(Integer.toString(minLength.getValue()));
            else if (source.equals(maxLength))
                maxLengthText.setText(Integer.toString(maxLength.getValue()));
            else if (source.equals(minWidth))
                minWidthText.setText(Integer.toString(minWidth.getValue()));
            else if (source.equals(maxWidth))
                maxWidthText.setText(Integer.toString(maxWidth.getValue()));
        }
    }
    
    private class OkButtonAction implements ActionListener
    {
        
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (areRangesOk())
            {
                rectangles = new Rectangle[number.getValue()];
                
                for (int i = 0; i < rectangles.length; i++)
                {
                    double width = RandomNumbersGenerator.getRandomDouble(minWidth.getValue(), maxWidth.getValue());
                    double length = RandomNumbersGenerator.getRandomDouble(minLength.getValue(), maxLength.getValue());
                    int x = RandomNumbersGenerator.getRandomInt((int) (drawPanel.getSize().width - width));
                    int y = RandomNumbersGenerator.getRandomInt((int) (drawPanel.getSize().height - length));
                    
                    rectangles[i] = new Rectangle(width, length, x, y, RandomColorGenerator.getRandomColor());
                }
                
                dispose();
                drawPanel.setDrawer(new RectangleDrawer(rectangles));
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

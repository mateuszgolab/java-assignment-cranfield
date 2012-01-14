package uk.ac.cranfield.java.assignment.view.dialog;


import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeListener;

import uk.ac.cranfield.java.assignment.controller.dialog.DialogClient;
import uk.ac.cranfield.java.assignment.controller.utils.ComponentFactory;
import uk.ac.cranfield.java.assignment.view.DrawPanel;
import uk.ac.cranfield.java.assignment.view.NDialog;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;


public abstract class DisplayDialog extends NDialog implements ChangeListener
{
    
    private static int MAX_SHAPES_NUMBER = 50;
    private static int MAJOR_TICK = 10;
    private static int MINOR_TICK = 5;
    private String title;
    private JLabel numberLabel;
    protected JSlider number;
    protected CellConstraints cc;
    protected FormLayout layout;
    protected JPanel panel;
    protected JButton okButton;
    private JButton cancelButton;
    private JPanel southPanel;
    protected ComponentFactory factory;
    protected JTextField numberText;
    protected DrawPanel drawPanel;
    
    
    public DisplayDialog(Frame frame, String title, DialogClient dialogClient, DrawPanel drawPanel)
    {
        super(frame, title + "s display", dialogClient, true);
        this.title = title;
        this.panel = new JPanel();
        this.drawPanel = drawPanel;
        this.southPanel = new JPanel();
        this.factory = new ComponentFactory();
        
        setLayout();
        create();
        init();
        addListeners();
        add(panel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
        pack();
        
    }
    
    protected abstract void setLayout();
    
    protected void create()
    {
        numberLabel = new JLabel("number of " + title + "s");
        number = factory.createSlider(0, MAX_SHAPES_NUMBER, MAX_SHAPES_NUMBER / 2, MINOR_TICK, MAJOR_TICK);
        numberText = factory.createTextField(number.getValue());
        
        
        okButton = new JButton("Ok");
        
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new CancelButtonAction());
    }
    
    protected void init()
    {
        cc = new CellConstraints();
        panel.add(numberLabel, cc.xy(2, 2));
        panel.add(numberText, cc.xy(4, 2));
        panel.add(number, cc.xy(6, 2));
        
        southPanel.add(okButton);
        southPanel.add(cancelButton);
    }
    
    protected void addListeners()
    {
        number.addChangeListener(this);
    }
    
    private class CancelButtonAction implements ActionListener
    {
        
        @Override
        public void actionPerformed(ActionEvent e)
        {
            dispose();
        }
        
    }
    
}

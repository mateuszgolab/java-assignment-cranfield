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


@SuppressWarnings("serial")
public abstract class DisplayDialog extends NDialog implements ChangeListener
{
    
    protected static int MAX_RADIUS = 401;
    private static int MAX_SHAPES_NUMBER = 50;
    private static int MAJOR_TICK = 7;
    private String title;
    private JLabel numberLabel;
    protected DimensionSlider number;
    protected CellConstraints cc;
    protected FormLayout layout;
    protected JPanel panel;
    protected JButton okButton;
    private JButton cancelButton;
    private JPanel southPanel;
    protected JTextField numberText;
    
    
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
    
    protected abstract void setLayout();
    
    protected void create()
    {
        numberLabel = new JLabel("Number of " + title + "s :");
        number = new DimensionSlider(1, MAX_SHAPES_NUMBER, MAX_SHAPES_NUMBER / 2, MAJOR_TICK);
        numberText = TextFieldFactory.createIntegerTextField(number.getValue());
        
        
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
    
    public void reset()
    {
        pack();
        number.reset();
        numberText.setText(Integer.toString(number.getValue()));
    }
    
    protected void addListeners()
    {
        number.addChangeListener(this);
        addWindowListener(new DialogAdapter());
    }
    
    private class CancelButtonAction implements ActionListener
    {
        
        @Override
        public void actionPerformed(ActionEvent e)
        {
            dispose();
        }
        
    }
    
    private class DialogAdapter extends WindowAdapter
    {
        
        @Override
        public void windowClosing(WindowEvent we)
        {
            dispose();
        }
    }
    
    
}

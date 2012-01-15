package uk.ac.cranfield.java.assignment.controller.utils;

import javax.swing.JTextField;


public class TextFieldFactory
{
    
    public JTextField createDecimalTextField(double value)
    {
        JTextField text = new JTextField(Double.toString(value));
        text.setEditable(false);
        
        return text;
    }
    
    public JTextField createIntegerTextField(int value)
    {
        JTextField text = new JTextField(Integer.toString(value));
        text.setEditable(false);
        
        return text;
    }
}

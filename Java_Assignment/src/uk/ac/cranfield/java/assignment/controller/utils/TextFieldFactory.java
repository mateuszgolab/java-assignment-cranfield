package uk.ac.cranfield.java.assignment.controller.utils;

import javax.swing.JTextField;

/**
 * This class represents TextField component factory.
 * Produces not editable text fields with Integer or Decimal initial values.
 * @author Mateusz Golab
 * @version 1.0
 */
public class TextFieldFactory
{
    
    /**
     * This method creates not editable TextField with double as initial value.
     * @param value double initial value
     * @return created TextField
     */
    public static JTextField createDecimalTextField(double value)
    {
        JTextField text = new JTextField(Double.toString(value));
        text.setEditable(false);
        
        return text;
    }
    
    /**
     * This method creates not editable TextField with integer as initial value.
     * @param value integer initial value
     * @return created TextField
     */
    public static JTextField createIntegerTextField(int value)
    {
        JTextField text = new JTextField(Integer.toString(value));
        text.setEditable(false);
        
        return text;
    }
}

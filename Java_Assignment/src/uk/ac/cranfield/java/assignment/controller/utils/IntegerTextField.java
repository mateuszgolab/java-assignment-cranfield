package uk.ac.cranfield.java.assignment.controller.utils;

import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class IntegerTextField extends JTextField
{
    
    private Integer minimalValue;
    private Integer maximalValue;
    private Integer offsetLimit;
    
    public IntegerTextField(int min, int max, int columns)
    {
        super("", 4);
        minimalValue = min;
        maximalValue = max;
        offsetLimit = (int) (java.lang.Math.log10(maximalValue) + 1);
    }
    
    
    public IntegerTextField(String text, int columns)
    {
        super(text, columns);
        minimalValue = Integer.MIN_VALUE;
        maximalValue = Integer.MAX_VALUE;
        offsetLimit = (int) (java.lang.Math.log10(maximalValue) + 1);
    }
    
    public IntegerTextField()
    {
        super();
        minimalValue = Integer.MIN_VALUE;
        maximalValue = Integer.MAX_VALUE;
        offsetLimit = (int) (java.lang.Math.log10(maximalValue) + 1);
    }
    
    public Integer getValue()
    {
        final String text = getText();
        if (text == null || text.length() == 0)
        {
            return 0;
        }
        
        return Integer.parseInt(text);
    }
    
    
    /**
     * @return is the given value in specified range
     */
    public boolean isInRange(String value)
    {
        final String text = getText();
        if (text == null || text.length() == 0)
        {
            return true;
        }
        
        Integer val = Integer.parseInt(text);
        val *= 10;
        val += Integer.parseInt(value);
        if (val >= minimalValue && val <= maximalValue)
            return true;
        return false;
    }
    
    /**
     * Create a new document model for this control that only accepts
     * integral values.
     * @return The new document model.
     */
    @Override
    protected Document createDefaultModel()
    {
        return new IntegerDocument();
    }
    
    /**
     * This document only allows integral values to be added to it.
     */
    private class IntegerDocument extends PlainDocument
    {
        
        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException
        {
            if (str != null && offs < offsetLimit && isInRange(str))
            {
                try
                {
                    Integer.decode(str);
                    super.insertString(offs, str, a);
                } catch (NumberFormatException ex)
                {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        }
    }
}

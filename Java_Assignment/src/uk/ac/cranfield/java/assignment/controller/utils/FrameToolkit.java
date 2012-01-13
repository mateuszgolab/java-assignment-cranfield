package uk.ac.cranfield.java.assignment.controller.utils;


import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;


public class FrameToolkit
{
    
    private static Toolkit toolkit = Toolkit.getDefaultToolkit();
    
    
    public static Dimension getSize()
    {
        return new Dimension(toolkit.getScreenSize().width / 2, toolkit.getScreenSize().height / 2);
    }
    
    public static int getMaxWidth()
    {
        return toolkit.getScreenSize().width;
    }
    
    public static int getMaxHeight()
    {
        return toolkit.getScreenSize().height;
    }
    
    public static Dimension getPanelCenter(JPanel panel)
    {
        return new Dimension(panel.getWidth() / 2, panel.getHeight() / 2);
    }
    
}

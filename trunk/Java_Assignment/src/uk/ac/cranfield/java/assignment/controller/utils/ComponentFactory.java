package uk.ac.cranfield.java.assignment.controller.utils;

import javax.swing.JSlider;
import javax.swing.JTextField;


public class ComponentFactory
{
    
    public JSlider createSlider(int min, int max, int init, int minorTick, int majorTick)
    {
        JSlider slider = new JSlider(min, max, init);
        slider.setMinorTickSpacing(minorTick);
        slider.setMajorTickSpacing(majorTick);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setPaintTrack(true);
        return slider;
    }
    
    public JTextField createTextField(int value)
    {
        JTextField text = new JTextField(Integer.toString(value));
        // text.setColumns(3);
        text.setEditable(false);
        
        return text;
    }
}

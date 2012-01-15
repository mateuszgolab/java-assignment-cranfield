package uk.ac.cranfield.java.assignment.view.component;

import javax.swing.JSlider;


@SuppressWarnings("serial")
public class DimensionSlider extends JSlider
{
    
    private Integer initValue;
    
    public DimensionSlider(int min, int max, int init, int minorTick, int majorTick)
    {
        super(min, max, init);
        this.initValue = init;
        setMinorTickSpacing(minorTick);
        setMajorTickSpacing(majorTick);
        setPaintLabels(true);
        setPaintTicks(true);
        setPaintTrack(true);
    }
    
    public void reset()
    {
        setValue(initValue);
    }
    
}

package uk.ac.cranfield.java.assignment.view.component;

import javax.swing.JSlider;


/**
 * This class extends {@link JSlider} It is the component that lets the user graphically select a value by sliding a
 * knob within a bounded interval
 * @author Mateusz Golab
 * @version 1.0
 * @see JSlider
 */
@SuppressWarnings("serial")
public class DimensionSlider extends JSlider
{
    
    /**
     * Represents the initial value of the slider.
     */
    private Integer initValue;
    
    /**
     * The constructor creates new slider.
     * Sets the range of the slider values and minor, major ticks intervals.
     * Calls base class constructor.
     * @param min minimum value of the slider
     * @param max maximum value of the slider
     * @param init slider initial value
     * @param minorTick minor tick interval
     * @param majorTick major tick interval
     */
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
    
    /**
     * The constructor creates new slider.
     * Sets the range of the slider values and major tick interval.
     * Calls base class constructor.
     * @param min minimum value of the slider
     * @param max maximum value of the slider
     * @param init slider initial value
     * @param majorTick major tick interval
     */
    public DimensionSlider(int min, int max, int init, int majorTick)
    {
        super(min, max, init);
        this.initValue = init;
        setMajorTickSpacing(majorTick);
        setPaintLabels(true);
        setPaintTicks(true);
        setPaintTrack(true);
    }
    
    /**
     * This method sets the slider state to initial state.
     */
    public void reset()
    {
        setValue(initValue);
    }
    
}

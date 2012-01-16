package uk.ac.cranfield.java.assignment.model.info;

/**
 * This bean class extends {@link DialogInfo}.
 * Represents minor and major radius boundary values for the Ellipse objects.
 * @author Mateusz Golab
 * @version 1.0
 * @see DialogInfo
 */
public class EllipseDialogInfo extends DialogInfo
{
    
    /**
     * Represents minimum minor radius value.
     */
    private Integer minMinorRadius;
    
    /**
     * Represents maximum minor radius value.
     */
    private Integer maxMinorRadius;
    
    /**
     * Represents minimum major radius value.
     */
    private Integer minMajorRadius;
    
    /**
     * Represents maximum major radius value.
     */
    private Integer maxMajorRadius;
    
    /**
     * Returns the minimum minor radius value.
     * @return the minimum minor radius value.
     */
    public final Integer getMinMinorRadius()
    {
        return minMinorRadius;
    }
    
    /**
     * Sets the minimum minor radius value.
     * @param minMinorRadius the minimum minor radius value to set
     */
    public final void setMinMinorRadius(final Integer minMinorRadius)
    {
        this.minMinorRadius = minMinorRadius;
    }
    
    /**
     * Returns maximum minor radius value.
     * @return the maximum minor radius value.
     */
    public final Integer getMaxMinorRadius()
    {
        return maxMinorRadius;
    }
    
    /**
     * Sets the maximum minor radius value.
     * @param maxMinorRadius the maximum minor radius value to set.
     */
    public final void setMaxMinorRadius(final Integer maxMinorRadius)
    {
        this.maxMinorRadius = maxMinorRadius;
    }
    
    /**
     * Returns minimum major radius value.
     * @return the minimum major radius value.
     */
    public final Integer getMinMajorRadius()
    {
        return minMajorRadius;
    }
    
    /**
     * Sets the minimum major radius value.
     * @param minMajorRadius the minimum major radius value to set.
     */
    public final void setMinMajorRadius(final Integer minMajorRadius)
    {
        this.minMajorRadius = minMajorRadius;
    }
    
    /**
     * Returns maximum major radius value.
     * @return the maximum major radius value.
     */
    public final Integer getMaxMajorRadius()
    {
        return maxMajorRadius;
    }
    
    /**
     * Sets the maximum major radius value.
     * @param maxMajorRadius the maximum major radius value.
     */
    public final void setMaxMajorRadius(final Integer maxMajorRadius)
    {
        this.maxMajorRadius = maxMajorRadius;
    }
    
    
}

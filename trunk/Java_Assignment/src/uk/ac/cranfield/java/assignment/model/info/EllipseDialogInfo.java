package uk.ac.cranfield.java.assignment.model.info;

/**
 * This bean class extends {@link DialogInfo}.
 * Represents minor and major radius boundary values for the Ellipse objects.
 * @author Mateusz Golab
 * @version 1.0
 * @see
 */
public class EllipseDialogInfo extends DialogInfo
{
    
    /**
     * Represents minimal minor radius value.
     */
    private Integer minMinorRadius;
    
    /**
     * Represents maximal minor radius value.
     */
    private Integer maxMinorRadius;
    
    /**
     * Represents minimal major radius value.
     */
    private Integer minMajorRadius;
    
    /**
     * Represents maximal major radius value.
     */
    private Integer maxMajorRadius;
    
    /**
     * Returns the minimal minor radius value.
     * @return the minimal minor radius value.
     */
    public final Integer getMinMinorRadius()
    {
        return minMinorRadius;
    }
    
    /**
     * Sets the minimal minor radius value.
     * @param minMinorRadius the minimal minor radius value to set
     */
    public final void setMinMinorRadius(final Integer minMinorRadius)
    {
        this.minMinorRadius = minMinorRadius;
    }
    
    /**
     * Returns maximal minor radius value.
     * @return the maximal minor radius value.
     */
    public final Integer getMaxMinorRadius()
    {
        return maxMinorRadius;
    }
    
    /**
     * Sets the maximal minor radius value.
     * @param maxMinorRadius the maximal minor radius value to set.
     */
    public final void setMaxMinorRadius(final Integer maxMinorRadius)
    {
        this.maxMinorRadius = maxMinorRadius;
    }
    
    /**
     * Returns minimal major radius value.
     * @return the minimal major radius value.
     */
    public final Integer getMinMajorRadius()
    {
        return minMajorRadius;
    }
    
    /**
     * Sets the minimal major radius value.
     * @param minMajorRadius the minimal major radius value to set.
     */
    public final void setMinMajorRadius(final Integer minMajorRadius)
    {
        this.minMajorRadius = minMajorRadius;
    }
    
    /**
     * Returns maximal major radius value.
     * @return the maximal major radius value.
     */
    public final Integer getMaxMajorRadius()
    {
        return maxMajorRadius;
    }
    
    /**
     * Sets the maximal major radius value.
     * @param maxMajorRadius the maximal major radius value.
     */
    public final void setMaxMajorRadius(final Integer maxMajorRadius)
    {
        this.maxMajorRadius = maxMajorRadius;
    }
    
    
}

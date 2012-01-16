package uk.ac.cranfield.java.assignment.model.info;

/**
 * This bean class extends {@link DialogInfo}.
 * Represents radius boundary values for the Circle objects.
 * @author Mateusz Golab
 * @version 1.0
 * @see DialogInfo
 */
public class CircleDialogInfo extends DialogInfo
{
    
    /**
     * Represents minimum radius value.
     */
    private Integer minRadius;
    
    /**
     * Represents maximum radius value.
     */
    private Integer maxRadius;
    
    /**
     * Returns minimum radius value.
     * @return the minimum radius value.
     */
    public final Integer getMinRadius()
    {
        return minRadius;
    }
    
    /**
     * Sets the minimum Radius value.
     * @param minRadius the minimum radius to set.
     */
    public final void setMinRadius(final Integer minRadius)
    {
        this.minRadius = minRadius;
    }
    
    /**
     * Returns maximum radius value.
     * @return the maximum radius value.
     */
    public final Integer getMaxRadius()
    {
        return maxRadius;
    }
    
    /**
     * Sets the maximum radius value.
     * @param maxRadius the maximum radius value to set.
     */
    public final void setMaxRadius(final Integer maxRadius)
    {
        this.maxRadius = maxRadius;
    }
}

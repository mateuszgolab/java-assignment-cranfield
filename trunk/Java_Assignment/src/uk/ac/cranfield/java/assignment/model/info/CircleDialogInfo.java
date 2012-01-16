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
     * Represents minimal radius value.
     */
    private Integer minRadius;
    
    /**
     * Represents maximal radius value.
     */
    private Integer maxRadius;
    
    /**
     * Returns minimal radius value.
     * @return the minimal radius value.
     */
    public final Integer getMinRadius()
    {
        return minRadius;
    }
    
    /**
     * Sets the minimal Radius value.
     * @param minRadius the minimal radius to set.
     */
    public final void setMinRadius(final Integer minRadius)
    {
        this.minRadius = minRadius;
    }
    
    /**
     * Returns maximal radius value.
     * @return the maximal radius value.
     */
    public final Integer getMaxRadius()
    {
        return maxRadius;
    }
    
    /**
     * Sets the maximal radius value.
     * @param maxRadius the maximal radius value to set.
     */
    public final void setMaxRadius(final Integer maxRadius)
    {
        this.maxRadius = maxRadius;
    }
}

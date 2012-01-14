package uk.ac.cranfield.java.assignment.model.info;


public class CircleDialogInfo extends DialogInfo
{
    
    private Integer minRadius;
    private Integer maxRadius;
    
    /**
     * @return the minRadius
     */
    public final Integer getMinRadius()
    {
        return minRadius;
    }
    
    /**
     * @param minRadius the minRadius to set
     */
    public final void setMinRadius(Integer minRadius)
    {
        this.minRadius = minRadius;
    }
    
    /**
     * @return the maxRadius
     */
    public final Integer getMaxRadius()
    {
        return maxRadius;
    }
    
    /**
     * @param maxRadius the maxRadius to set
     */
    public final void setMaxRadius(Integer maxRadius)
    {
        this.maxRadius = maxRadius;
    }
}

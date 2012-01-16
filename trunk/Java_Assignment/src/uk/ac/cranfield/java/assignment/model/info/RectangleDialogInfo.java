package uk.ac.cranfield.java.assignment.model.info;


/**
 * This bean class extends {@link DialogInfo}.
 * Represents length and width boundary values for the Rectangle objects.
 * @author Mateusz Golab
 * @version 1.0
 * @see
 */
public class RectangleDialogInfo extends DialogInfo
{
    
    /**
     * Represents minimal length value.
     */
    private Integer minLength;
    
    /**
     * Represents maximal length value.
     */
    private Integer maxLength;
    
    /**
     * Represents minimal width value.
     */
    private Integer minWidth;
    
    /**
     * Represents maximal width value.
     */
    private Integer maxWidth;
    
    /**
     * Returns minimal length value.
     * @return the minimal length value.
     */
    public final Integer getMinLength()
    {
        return minLength;
    }
    
    
    /**
     * Sets the minimal length value.
     * @param minLength the minimal length value to set
     */
    public final void setMinLength(final Integer minLength)
    {
        this.minLength = minLength;
    }
    
    
    /**
     * Returns maximal length value.
     * @return the maximal length value.
     */
    public final Integer getMaxLength()
    {
        return maxLength;
    }
    
    
    /**
     * Sets the maximal length value.
     * @param maxLength the maximal length value to set
     */
    public final void setMaxLength(final Integer maxLength)
    {
        this.maxLength = maxLength;
    }
    
    
    /**
     * Returns minimal width value.
     * @return the minimal width value.
     */
    public final Integer getMinWidth()
    {
        return minWidth;
    }
    
    
    /**
     * Sets the minimal width value.
     * @param minWidth the minimal width value to set
     */
    public final void setMinWidth(final Integer minWidth)
    {
        this.minWidth = minWidth;
    }
    
    
    /**
     * Returns the maximal width value.
     * @return the maximal width value.
     */
    public final Integer getMaxWidth()
    {
        return maxWidth;
    }
    
    
    /**
     * Sets the maximal width value.
     * @param maxWidth the maximal width value to set
     */
    public final void setMaxWidth(final Integer maxWidth)
    {
        this.maxWidth = maxWidth;
    }
    
}

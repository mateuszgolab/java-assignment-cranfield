package uk.ac.cranfield.java.assignment.model.info;


/**
 * This bean class extends {@link DialogInfo}.
 * Represents length and width boundary values for the Rectangle objects.
 * @author Mateusz Golab
 * @version 1.0
 * @see RectangleDialogInfo
 */
public class RectangleDialogInfo extends DialogInfo
{
    
    /**
     * Represents minimum length value.
     */
    private Integer minLength;
    
    /**
     * Represents maximum length value.
     */
    private Integer maxLength;
    
    /**
     * Represents minimum width value.
     */
    private Integer minWidth;
    
    /**
     * Represents maximum width value.
     */
    private Integer maxWidth;
    
    /**
     * Returns minimum length value.
     * @return the minimum length value.
     */
    public final Integer getMinLength()
    {
        return minLength;
    }
    
    
    /**
     * Sets the minimum length value.
     * @param minLength the minimum length value to set
     */
    public final void setMinLength(final Integer minLength)
    {
        this.minLength = minLength;
    }
    
    
    /**
     * Returns maximum length value.
     * @return the maximum length value.
     */
    public final Integer getMaxLength()
    {
        return maxLength;
    }
    
    
    /**
     * Sets the maximum length value.
     * @param maxLength the maximum length value to set
     */
    public final void setMaxLength(final Integer maxLength)
    {
        this.maxLength = maxLength;
    }
    
    
    /**
     * Returns minimum width value.
     * @return the minimum width value.
     */
    public final Integer getMinWidth()
    {
        return minWidth;
    }
    
    
    /**
     * Sets the minimum width value.
     * @param minWidth the minimum width value to set
     */
    public final void setMinWidth(final Integer minWidth)
    {
        this.minWidth = minWidth;
    }
    
    
    /**
     * Returns the maximum width value.
     * @return the maximum width value.
     */
    public final Integer getMaxWidth()
    {
        return maxWidth;
    }
    
    
    /**
     * Sets the maximum width value.
     * @param maxWidth the maximum width value to set
     */
    public final void setMaxWidth(final Integer maxWidth)
    {
        this.maxWidth = maxWidth;
    }
    
}

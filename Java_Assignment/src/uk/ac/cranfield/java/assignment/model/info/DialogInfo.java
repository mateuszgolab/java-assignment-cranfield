package uk.ac.cranfield.java.assignment.model.info;


/**
 * Bean containing information related to the Dialog's fields.
 * Contains number of objects.
 * @author
 * @version 2.0
 */
public abstract class DialogInfo
{
    
    /**
     * NUmber of objects.
     */
    protected Integer numberOfObjects;
    
    /**
     * The default constructor.
     * Sets the number of objects to 0.
     */
    public DialogInfo()
    {
        numberOfObjects = 0;
    }
    
    /**
     * This method returns the number of objects.
     * @return the number of objects
     */
    public final Integer getNumberOfObjects()
    {
        return numberOfObjects;
    }
    
    /**
     * This method sets the number of objects.
     * @param numberOfObjects the number of objects to set
     */
    public final void setNumberOfObjects(final Integer numberOfObjects)
    {
        this.numberOfObjects = numberOfObjects;
    }
    
    
}

package uk.ac.cranfield.java.assignment.model.info;



/**
 * Bean containing information related to the Dialog's fields.
 * @author
 * @version 2.0
 */
public abstract class DialogInfo
{
    
    protected Integer numberOfObjects;
    
    
    public DialogInfo()
    {
        numberOfObjects = 0;
    }
    
    /**
     * @return the numberOfObjects
     */
    public final Integer getNumberOfObjects()
    {
        return numberOfObjects;
    }
    
    /**
     * @param numberOfObjects the numberOfObjects to set
     */
    public final void setNumberOfObjects(Integer numberOfObjects)
    {
        this.numberOfObjects = numberOfObjects;
    }
    
    
}

package uk.ac.cranfield.java.assignment.model.shape;

import java.awt.Color;

import uk.ac.cranfield.java.assignment.controller.utils.Sortable;

/**
 * The abstract class MyShape is the root of the hierarchy of shapes. This class
 * has been introduced so that any class representing a shape that has area
 * could be compared to any other one.
 * It implements the Sortable interface
 * @author
 * @version 1.0
 * @see Sortable
 */
public abstract class MyShape implements Sortable
{
    
    
    protected Color color;
    
    /**
     * Abstract method that calculates the area of a Shape. Any class
     * representing a shape should implement this method.
     */
    public abstract double area();
    
    /**
     * It allows sorting the shapes from bigger to smaller areas.
     * @param b
     * The other element to be compared with.
     * @return Returns 0 if the areas are equal, 1 if this is bigger or -1 if it
     * is smaller.
     */
    @Override
    public int compare(Sortable b)
    {
        MyShape other = (MyShape) b;
        
        double a1 = this.area();
        double a2 = other.area();
        
        if (a1 == a2)
            return 0;
        else if (a1 < a2)
            return 1;
        else
            return -1;
    }
    
    
    /**
     * @return the color
     */
    public final Color getColor()
    {
        return color;
    }
    
    
    /**
     * @param color the color to set
     */
    public final void setColor(Color color)
    {
        this.color = color;
    }
    
}

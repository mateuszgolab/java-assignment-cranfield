package uk.ac.cranfield.java.assignment.model.shape;

import java.awt.Color;
import java.io.Serializable;


/**
 * The class Ellipse represents a geometric shape.
 * An Ellipse is defined by its major radius, minor radius and centre (x,y).
 * It implements the area method of the abstract base class MyShape.
 * @author Mateusz Golab
 * @version 1.0
 * @see MyShape
 */
public class Ellipse extends MyShape implements Serializable
{
    
    /**
     * serial UID
     */
    private static final long serialVersionUID = -5303480891724484467L;
    
    /**
     * double representing the minor radius of the Ellipse.
     */
    protected double minorRadius;
    
    /**
     * double representing the major radius of the Ellipse.
     */
    protected double majorRadius;
    
    /**
     * integer representing the x - coordinate of the centre of the Ellipse
     */
    protected int x;
    
    /**
     * integer representing the y - coordinate of the centre of the Ellipse
     */
    protected int y;
    
    /**
     * Represents the color of the Ellipse.
     */
    protected Color color;
    
    /**
     * This constructor generates a new Ellipse with the proper values for its
     * fields.
     * @param minorRadius double representing the minor radius of the Ellipse.
     * @param majorRadius double representing the major radius of the Ellipse.
     * @param x integer representing the x - coordinate of the centre of Ellipse.
     * @param y integer representing the y - coordinate of the centre of Ellipse.
     * @param color represents the color of the Ellipse.
     */
    public Ellipse(double minorRadius, double majorRadius, int x, int y, Color color)
    {
        this.minorRadius = minorRadius;
        this.majorRadius = majorRadius;
        this.x = x;
        this.y = y;
        this.color = color;
    }
    
    /**
     * Implementation for the abstract method area of the base class MyShape.
     * A Ellipse's area is the product of pi number and its minor and major radius.
     */
    @Override
    public double area()
    {
        return java.lang.Math.PI * minorRadius * majorRadius;
    }
    
    
    /**
     * Returns the x - coordinate of the Ellipse's centre.
     * @return the x - coordinate of the Ellipse's centre.
     */
    public final int getX()
    {
        return x;
    }
    
    
    /**
     * Sets the x - coordinate of the Ellipse's centre.
     * @param x the x - coordinate to set
     */
    public final void setX(final int x)
    {
        this.x = x;
    }
    
    
    /**
     * Returns the y - coordinate of the Ellipse's centre.
     * @return the y - coordinate of the Ellipse's centre
     */
    public final int getY()
    {
        return y;
    }
    
    
    /**
     * Sets the y - coordinate of the Ellipse's centre.
     * @param y the y - coordinate to set
     */
    public final void setY(final int y)
    {
        this.y = y;
    }
    
    
    /**
     * Allows the string representation of the Ellipse for output purposes.
     * Overwrites the default Object method toString.
     */
    @Override
    public String toString()
    {
        StringBuffer s = new StringBuffer();
        
        s.append("minor radius = " + minorRadius + '\n');
        s.append("major radius = " + majorRadius + '\n');
        s.append("area = " + area() + '\n');
        s.append("centre = (" + x + "," + y + ")" + '\n');
        
        return s.toString();
    }
    
    
    /**
     * Returns the minor radius of the Ellipse.
     * @return the minorRadius of the Ellipse
     */
    public final double getMinorRadius()
    {
        return minorRadius;
    }
    
    
    /**
     * Sets the minor radius of the Ellipse.
     * @param minorRadius the minorRadius to set
     */
    public void setMinorRadius(final double minorRadius)
    {
        this.minorRadius = minorRadius;
    }
    
    
    /**
     * Returns the major radius of the Ellipse.
     * @return the majorRadius of the Ellipse
     */
    public double getMajorRadius()
    {
        return majorRadius;
    }
    
    
    /**
     * Sets the major radius of the Ellipse.
     * @param majorRadius the majorRadius to set
     */
    public void setMajorRadius(final double majorRadius)
    {
        this.majorRadius = majorRadius;
    }
    
    /**
     * Returns the color of the Ellipse.
     * @return the color of the Ellipse.
     */
    public final Color getColor()
    {
        return color;
    }
    
    
    /**
     * Sets the color of the Ellipse.
     * @param color the color to set
     */
    public final void setColor(final Color color)
    {
        this.color = color;
    }
    
    
}

package uk.ac.cranfield.java.assignment.model.shape;

import java.awt.Color;
import java.io.Serializable;

/**
 * The class Circle represents a geometric shape.
 * Extends {@link Ellipse} An Circle is defined by its radius and centre (x,y).
 * It implements the area method of the abstract class MyShape.
 * @author Mateusz Golab
 * @version 1.0
 * @see Ellipse , MyShape
 */
public class Circle extends Ellipse implements Serializable
{
    
    /**
     * serial UID
     */
    private static final long serialVersionUID = -8860138513034753591L;
    
    /**
     * This constructor generates a new Circle with the proper values for its
     * fields. Uses base class Ellipse's constructor.
     * @param radius double representing the radius of the Circle.
     * @param x integer representing the x - coordinate of the centre of Circle.
     * @param y integer representing the y - coordinate of the centre of Circle.
     * @param c represents the color of the Circle.
     */
    public Circle(double radius, int x, int y, Color c)
    {
        super(radius, radius, x, y, c);
    }
    
    /**
     * Returns the radius of the Circle.
     * @return the radius.
     */
    public double getRadius()
    {
        return minorRadius;
    }
    
    /**
     * Sets the radius of the Circle.
     * @param radius the radius tio set.
     */
    public void setRadius(final double radius)
    {
        minorRadius = radius;
        majorRadius = radius;
    }
    
    /**
     * Overriden Ellipse method
     * Sets the radius.
     */
    @Override
    public void setMinorRadius(final double radius)
    {
        setRadius(radius);
    }
    
    /**
     * Overriden Ellipse method
     * Sets the radius.
     */
    @Override
    public void setMajorRadius(final double radius)
    {
        setRadius(radius);
    }
    
    
    /**
     * Allows the string representation of the Circle for output purposes.
     * Overwrites the default Object method toString.
     */
    @Override
    public String toString()
    {
        StringBuffer s = new StringBuffer();
        
        s.append("radius = " + minorRadius + '\n');
        s.append("area = " + area() + '\n');
        s.append("centre = (" + x + "," + y + ")" + '\n');
        
        return s.toString();
    }
}

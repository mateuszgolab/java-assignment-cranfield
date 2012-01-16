package uk.ac.cranfield.java.assignment.model.shape;

import java.awt.Color;
import java.io.Serializable;

/**
 * The class Rectangle represents a geometric shape. A Rectangle is defined by
 * its width and height and centre (x,y).
 * It implements the area method of the abstract base class MyShape.
 * @author
 * @version 1.1
 * @see MyShape
 */
public class Rectangle extends MyShape implements Serializable
{
    
    
    /**
     * serial UID
     */
    private static final long serialVersionUID = -2595404648736409317L;
    
    /**
     * This constructor generates a new Rectangle with the proper values for its
     * fields.
     * @param w double representing the width of the Rectangle.
     * @param h double representing the height of the Rectangle.
     * @param x integer representing the x - coordinate of the centre of Rectangle.
     * @param y integer representing the y - coordinate of the centre of Rectangle.
     */
    public Rectangle(double w, double h, int x, int y, Color color)
    {
        width = w;
        height = h;
        this.x = x;
        this.y = y;
        this.color = color;
    }
    
    /**
     * double representing the width of the Rectangle.
     */
    private double width;
    
    /**
     * double representing the height of the Rectangle.
     */
    private double height;
    
    /**
     * integer representing the x - coordinate of the centre of Rectangle.
     */
    private int x;
    
    /**
     * integer representing the y - coordinate of the centre of Rectangle.
     */
    private int y;
    
    /**
     * Represents the color of the Rectangle.
     */
    private Color color;
    
    /**
     * Implementation for the abstract method area of the base class MyShape.
     * A Rectangle's area is the product of its height and its width.
     */
    @Override
    public double area()
    {
        return width * height;
    }
    
    /**
     * Returns the width of the Rectangle.
     * @return width of the Rectangle.
     */
    public double getWidth()
    {
        return width;
    }
    
    /**
     * Returns the height of the Rectangle.
     * @return height of the Rectangle.
     */
    public double getHeight()
    {
        return height;
    }
    
    /**
     * Allows the string representation of the Rectangle for output purposes.
     * Overwrites the default Object method toString.
     */
    @Override
    public String toString()
    {
        StringBuffer s = new StringBuffer();
        
        s.append("width = " + width + '\n');
        s.append("height = " + height + '\n');
        s.append("area = " + area() + '\n');
        s.append("centre = (" + x + "," + y + ")" + '\n');
        
        return s.toString();
    }
    
    
    /**
     * Returns the x - coordinate of the Rectangle's centre.
     * @return the x - coordinate of the Rectangle's centre.
     */
    public final int getX()
    {
        return x;
    }
    
    
    /**
     * Sets the x - coordinate of the Rectangle's centre.
     * @param x the x - coordinate to set
     */
    public final void setX(final int x)
    {
        this.x = x;
    }
    
    
    /**
     * Returns the y - coordinate of the Rectangle's centre.
     * @return the y - coordinate of the Rectangle's centre
     */
    public final int getY()
    {
        return y;
    }
    
    
    /**
     * Sets the y - coordinate of the Rectangle's centre.
     * @param y the y - coordinate to set
     */
    public final void setY(final int y)
    {
        this.y = y;
    }
    
    /**
     * Returns the color of the Rectangle.
     * @return the color of the Rectangle.
     */
    public final Color getColor()
    {
        return color;
    }
    
    
    /**
     * Sets the color of the Rectangle.
     * @param color the color to set
     */
    public final void setColor(final Color color)
    {
        this.color = color;
    }
    
}

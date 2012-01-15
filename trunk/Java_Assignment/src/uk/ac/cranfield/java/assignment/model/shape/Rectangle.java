package uk.ac.cranfield.java.assignment.model.shape;

import java.awt.Color;
import java.io.Serializable;

/**
 * The class Rectangle represents a geometric shape. A Rectangle is defined by
 * its width and height and centre (x,y)..
 * It implements the area method of the abstract base class MyShape.
 * @author
 * @version 1.1
 * @see MyShape
 */
public class Rectangle extends MyShape implements Serializable
{
    
    
    /**
     * 
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
    
    /** double representing the width of the Rectangle. */
    private double width;
    
    /** double representing the height of the Rectangle. */
    private double height;
    
    /** integer representing the x - coordinate of the centre of Rectangle. */
    private int x;
    
    /** integer representing the y - coordinate of the centre of Rectangle. */
    private int y;
    
    private Color color;
    
    /**
     * Implementation for the abstract method area of the base class MyShape. A
     * Rectangle's area is the product of its height against its width.
     */
    @Override
    public double area()
    {
        return width * height;
    }
    
    /** @return width of the Rectangle. */
    public double getWidth()
    {
        return width;
    }
    
    /** @return height of the Rectangle. */
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
    
    
    /** @return the x - coordinate of the centre of Rectangle. */
    public final int getX()
    {
        return x;
    }
    
    
    /**
     * @param x the x to set
     */
    public final void setX(int x)
    {
        this.x = x;
    }
    
    
    /** @return the y - coordinate of the centre of Rectangle. */
    public final int getY()
    {
        return y;
    }
    
    
    /**
     * @param y the y to set
     */
    public final void setY(int y)
    {
        this.y = y;
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

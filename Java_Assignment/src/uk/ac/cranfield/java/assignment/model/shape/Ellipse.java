package uk.ac.cranfield.java.assignment.model.shape;


/**
 * The class Ellipse represents a geometric shape. An Ellipse is defined by
 * its major radius, minor radius and centre (x,y).
 * It implements the area method of the abstract base class MyShape.
 * @author Mateusz Golab
 * @version 1.0
 * @see MyShape
 */
public class Ellipse extends MyShape
{
    
    /** double representing the minor radius of the Ellipse. */
    protected double minorRadius;
    
    /** double representing the major radius of the Ellipse. */
    protected double majorRadius;
    
    /** integer representing the x - coordinate of the centre of the Ellipse */
    protected int x;
    
    /** integer representing the y - coordinate of the centre of the Ellipse */
    protected int y;
    
    /**
     * This constructor generates a new Ellipse with the proper values for its
     * fields.
     * @param minorRadius double representing the minor radius of the Ellipse.
     * @param majorRadius double representing the major radius of the Ellipse.
     * @param x integer representing the x - coordinate of the centre of Ellipse.
     * @param y integer representing the y - coordinate of the centre of Ellipse.
     */
    public Ellipse(double minorRadius, double majorRadius, int x, int y)
    {
        this.minorRadius = minorRadius;
        this.majorRadius = majorRadius;
        this.x = x;
        this.y = y;
    }
    
    /**
     * Implementation for the abstract method area of the base class MyShape. A
     * Circle's area is the product of pi number and its squared radius.
     */
    @Override
    public double area()
    {
        return java.lang.Math.PI * minorRadius * majorRadius;
    }
    
    
    /**
     * @return the x - coordinate of the Ellipse's centre
     */
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
    
    
    /**
     * @return the y - coordinate of the Ellipse's centre
     */
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
     * @return the minorRadius of the Ellipse
     */
    public final double getMinorRadius()
    {
        return minorRadius;
    }
    
    
    /**
     * @param minorRadius the minorRadius to set
     */
    public void setMinorRadius(double minorRadius)
    {
        this.minorRadius = minorRadius;
    }
    
    
    /**
     * @return the majorRadius of the Ellipse
     */
    public double getMajorRadius()
    {
        return majorRadius;
    }
    
    
    /**
     * @param majorRadius the majorRadius to set
     */
    public void setMajorRadius(double majorRadius)
    {
        this.majorRadius = majorRadius;
    }
    
    
}

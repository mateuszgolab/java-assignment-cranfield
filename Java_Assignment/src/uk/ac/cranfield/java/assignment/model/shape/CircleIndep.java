package uk.ac.cranfield.java.assignment.model.shape;


/**
 * The class Circle represents a geometric shape. A Circle is defined by
 * its radius and centre (x,y).
 * It implements the area method of the abstract base class MyShape.
 * @author Mateusz Golab
 * @version 1.0
 * @see MyShape
 */
public class CircleIndep extends MyShape {

    /** double representing the radius of the Circle. */
    private double radius;
    
    /** integer representing the x - coordinate of the centre of the Circle */
    private int x;
    
    /** integer representing the y - coordinate of the centre of the Circle */
    private int y;
    
    /**
     * This constructor generates a new Circle with the proper values for its
     * fields.
     * @param radius double representing the radius of the Circle.
     * @param x integer representing the x - coordinate of the centre of Circle.
     * @param y integer representing the y - coordinate of the centre of Circle.
     */
    public CircleIndep(double radius, int x, int y) {
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    /**
     * Implementation for the abstract method area of the base class MyShape. A
     * Circle's area is the product of pi number and its squared radius.
     */
    @Override
    public double area() {
        return java.lang.Math.PI * radius * radius;
    }
    
    /**
     * @return the radius of the Circle
     */
    public final double getRadius() {
        return radius;
    }
    
    
    /**
     * @param radius the radius to set
     */
    public final void setRadius(double radius) {
        this.radius = radius;
    }
    
    
    /**
     * @return the x - coordinate of the Circle's centre
     */
    public final int getX() {
        return x;
    }
    
    
    /**
     * @param x the x to set
     */
    public final void setX(int x) {
        this.x = x;
    }
    
    
    /**
     * @return the y - coordinate of the Circle's centre
     */
    public final int getY() {
        return y;
    }
    
    
    /**
     * @param y the y to set
     */
    public final void setY(int y) {
        this.y = y;
    }


    /**
     * Allows the string representation of the Circle for output purposes.
     * Overwrites the default Object method toString.
     */
    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        
        s.append("radius = " + radius + '\n');
        s.append("area = " + area() + '\n');
        s.append("centre = (" + x + "," + y + ")" + '\n');
        
        return s.toString();
    }


}

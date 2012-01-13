package uk.ac.cranfield.java.assignment.model.shape;


public class Circle extends Ellipse
{
    
    public Circle(double radius, int x, int y)
    {
        super(radius, radius, x, y);
    }
    
    public double getRadius()
    {
        return minorRadius;
    }
    
    public void setRadius(final double radius)
    {
        minorRadius = radius;
        majorRadius = radius;
    }
    
    @Override
    public void setMinorRadius(final double radius)
    {
        setRadius(radius);
    }
    
    @Override
    public void setMajorRadius(final double radius)
    {
        setRadius(radius);
    }
    
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
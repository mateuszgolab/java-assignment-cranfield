package uk.ac.cranfield.java.assignment.view.shape;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import uk.ac.cranfield.java.assignment.model.shape.Circle;
import uk.ac.cranfield.java.assignment.model.shape.MyShape;
import uk.ac.cranfield.java.assignment.view.interfaces.Drawable;


public class CircleView implements Drawable
{
    
    @Override
    public void draw(MyShape[] shapes, Graphics2D graphics)
    {
        Circle[] circles = (Circle[]) shapes;
        
        for (Circle cir : circles)
        {
            graphics.setPaint(cir.getColor());
            Ellipse2D circle = new Ellipse2D.Double(cir.getX(), cir.getY(), 2 * cir.getRadius(), 2 * cir.getRadius());
            graphics.fill(circle);
        }
        
    }
    
}

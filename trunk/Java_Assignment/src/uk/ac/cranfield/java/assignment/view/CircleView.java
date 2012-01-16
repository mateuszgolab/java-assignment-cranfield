package uk.ac.cranfield.java.assignment.view;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import uk.ac.cranfield.java.assignment.model.shape.Circle;
import uk.ac.cranfield.java.assignment.model.shape.MyShape;
import uk.ac.cranfield.java.assignment.view.interfaces.Drawable;

/**
 * This class is responsible for view of the Circle shape.
 * Implements {@link Drawable} interface.
 * Provides method of drawing Circles on the screen.
 * @author Mateusz Golab
 * @version 1.0
 * @see Drawable
 */
public class CircleView implements Drawable
{
    
    /**
     * This method implements Circle drawing mechanism
     * @param shapes circles to be drawn.
     * @param graphics rendering object.
     */
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

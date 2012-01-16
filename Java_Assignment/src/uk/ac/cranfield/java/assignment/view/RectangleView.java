package uk.ac.cranfield.java.assignment.view;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import uk.ac.cranfield.java.assignment.model.shape.MyShape;
import uk.ac.cranfield.java.assignment.model.shape.Rectangle;
import uk.ac.cranfield.java.assignment.view.interfaces.Drawable;

/**
 * This class is responsible for view of the Rectangle shape.
 * Implements {@link Drawable} interface.
 * Provides method of drawing Rectangles on the screen.
 * @author Mateusz Golab
 * @version 1.0
 * @see Drawable
 */
public class RectangleView implements Drawable
{
    
    /**
     * This method implements Rectangle drawing mechanism
     * @param shapes rectangles to be drawn.
     * @param graphics rendering object.
     */
    @Override
    public void draw(MyShape[] shapes, Graphics2D graphics)
    {
        Rectangle[] rectangles = (Rectangle[]) shapes;
        
        for (Rectangle rec : rectangles)
        {
            graphics.setColor(rec.getColor());
            Rectangle2D rectangle = new Rectangle2D.Double(rec.getX(), rec.getY(), rec.getWidth(), rec.getHeight());
            graphics.fill(rectangle);
        }
        
    }
    
}

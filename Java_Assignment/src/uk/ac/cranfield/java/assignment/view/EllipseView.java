package uk.ac.cranfield.java.assignment.view;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import uk.ac.cranfield.java.assignment.model.shape.Ellipse;
import uk.ac.cranfield.java.assignment.model.shape.MyShape;
import uk.ac.cranfield.java.assignment.view.interfaces.Drawable;

/**
 * This class is responsible for view of the Ellipse shape.
 * Implements {@link Drawable} interface.
 * Provides method of drawing Ellipses on the screen.
 * @author Mateusz Golab
 * @version 1.0
 * @see Drawable
 */
public class EllipseView implements Drawable
{
    
    /**
     * This method implements Ellipse drawing mechanism
     * @param shapes ellipses to be drawn.
     * @param graphics rendering object.
     */
    @Override
    public void draw(MyShape[] shapes, Graphics2D graphics)
    {
        Ellipse[] ellipses = (Ellipse[]) shapes;
        
        for (Ellipse ell : ellipses)
        {
            graphics.setColor(ell.getColor());
            Ellipse2D ellipse = new Ellipse2D.Double(ell.getX(), ell.getY(), 2 * ell.getMajorRadius(),
                    2 * ell.getMinorRadius());
            graphics.fill(ellipse);
        }
        
    }
    
}

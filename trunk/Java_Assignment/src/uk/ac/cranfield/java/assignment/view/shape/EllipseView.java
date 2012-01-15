package uk.ac.cranfield.java.assignment.view.shape;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import uk.ac.cranfield.java.assignment.model.shape.Ellipse;
import uk.ac.cranfield.java.assignment.model.shape.MyShape;
import uk.ac.cranfield.java.assignment.view.interfaces.Drawable;


public class EllipseView implements Drawable
{
    
    
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

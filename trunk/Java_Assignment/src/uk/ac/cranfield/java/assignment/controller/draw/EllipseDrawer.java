package uk.ac.cranfield.java.assignment.controller.draw;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import uk.ac.cranfield.java.assignment.controller.utils.Sort;
import uk.ac.cranfield.java.assignment.model.shape.Ellipse;


public class EllipseDrawer extends ShapeDrawer
{
    
    private Ellipse[] ellipses;
    
    public EllipseDrawer(Ellipse[] ellipses)
    {
        this.ellipses = ellipses;
        if (ellipses == null)
            this.ellipses = new Ellipse[0];
    }
    
    @Override
    public void draw(Graphics2D graphics)
    {
        clearScreen(graphics);
        
        for (Ellipse ell : ellipses)
        {
            graphics.setColor(ell.getColor());
            graphics.fillOval(ell.getX(), ell.getY(), (int) (2 * ell.getMajorRadius()),
                    (int) (2 * ell.getMinorRadius()));
        }
    }
    
    @Override
    public void sort(Graphics graphics, Dimension centre)
    {
        Sort.shell_sort(ellipses);
        
        for (Ellipse ell : ellipses)
        {
            ell.setX((int) (centre.width - ell.getMajorRadius()));
            ell.setY((int) (centre.height - ell.getMinorRadius()));
        }
    }
    
}

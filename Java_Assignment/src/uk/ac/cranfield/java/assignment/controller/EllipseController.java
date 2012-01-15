package uk.ac.cranfield.java.assignment.controller;

import java.awt.Dimension;
import java.awt.Graphics2D;

import uk.ac.cranfield.java.assignment.model.shape.Ellipse;
import uk.ac.cranfield.java.assignment.model.shape.MyShape;
import uk.ac.cranfield.java.assignment.view.interfaces.Drawable;


public class EllipseController extends ShapeController
{
    
    public EllipseController(MyShape[] shapes, Drawable view)
    {
        super(shapes, view);
    }
    
    
    @Override
    public void draw(Graphics2D graphics)
    {
        view.draw(shapes, graphics);
    }
    
    @Override
    public void centralise(Dimension centre)
    {
        
        Ellipse[] ellipses = (Ellipse[]) getShapes();
        
        for (Ellipse ell : ellipses)
        {
            ell.setX((int) (centre.width - ell.getMajorRadius()));
            ell.setY((int) (centre.height - ell.getMinorRadius()));
        }
    }
    
    
}

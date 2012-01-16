package uk.ac.cranfield.java.assignment.controller;

import java.awt.Dimension;
import java.awt.Graphics2D;

import uk.ac.cranfield.java.assignment.model.shape.Ellipse;
import uk.ac.cranfield.java.assignment.model.shape.MyShape;
import uk.ac.cranfield.java.assignment.view.interfaces.Drawable;

/**
 * This class extends {@link ShapeController}.
 * Provides the implementation of the class responsible for controlling Ellipses.
 * @author Mateusz Golab
 * @version 1.0
 * @see ShapeController
 */
public class EllipseController extends ShapeController
{
    
    /**
     * This constructor creates new EllipseController.
     * Based class constructor is called.
     * @param shapes Ellipse objects.
     * @param view object responsible for drawing Ellipses.
     */
    public EllipseController(MyShape[] shapes, Drawable view)
    {
        super(shapes, view);
    }
    
    /**
     * This method provides drawing Ellipses on the panel.
     * @param graphics graphic object used for drawing.
     */
    @Override
    public void draw(Graphics2D graphics)
    {
        view.draw(shapes, graphics);
    }
    
    /**
     * This method sets the central position on the screen for every Ellipse object.
     * @param centre central position of the screen.
     */
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

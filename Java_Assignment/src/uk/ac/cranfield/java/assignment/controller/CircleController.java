package uk.ac.cranfield.java.assignment.controller;

import java.awt.Dimension;
import java.awt.Graphics2D;

import uk.ac.cranfield.java.assignment.model.shape.Circle;
import uk.ac.cranfield.java.assignment.model.shape.MyShape;
import uk.ac.cranfield.java.assignment.view.interfaces.Drawable;

/**
 * This class extends {@link ShapeController}.
 * Provides the implementation of the class responsible for controlling Circles.
 * @author Mateusz Golab
 * @version 1.0
 * @see ShapeController
 */
public class CircleController extends ShapeController
{
    
    /**
     * This constructor creates new CircleController.
     * Based class constructor is called.
     * @param shapes Circle objects.
     * @param view object responsible for drawing Circles.
     */
    public CircleController(MyShape[] shapes, Drawable view)
    {
        super(shapes, view);
    }
    
    /**
     * This method provides drawing Circles on the panel.
     * @param graphics graphic object used for drawing.
     */
    @Override
    public void draw(Graphics2D graphics)
    {
        view.draw(shapes, graphics);
    }
    
    /**
     * This method sets the central position on the screen for every Circle object.
     * @param centre central position of the screen.
     */
    @Override
    public void centralise(Dimension centre)
    {
        Circle[] circles = (Circle[]) getShapes();
        
        for (Circle cir : circles)
        {
            cir.setX((int) (centre.width - cir.getRadius()));
            cir.setY((int) (centre.height - cir.getRadius()));
        }
    }
    
    
}

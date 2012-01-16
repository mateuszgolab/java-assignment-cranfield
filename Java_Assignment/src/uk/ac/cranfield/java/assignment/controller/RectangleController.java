package uk.ac.cranfield.java.assignment.controller;

import java.awt.Dimension;
import java.awt.Graphics2D;

import uk.ac.cranfield.java.assignment.model.shape.MyShape;
import uk.ac.cranfield.java.assignment.model.shape.Rectangle;
import uk.ac.cranfield.java.assignment.view.interfaces.Drawable;

/**
 * This class extends {@link ShapeController}.
 * Provides the implementation of the class responsible for controlling Rectangles.
 * @author Mateusz Golab
 * @version 1.0
 * @see ShapeController
 */
public class RectangleController extends ShapeController
{
    
    /**
     * This constructor creates new RectangleController.
     * Based class constructor is called.
     * @param shapes Rectangle objects.
     * @param view object responsible for drawing Rectangles.
     */
    public RectangleController(MyShape[] shapes, Drawable view)
    {
        super(shapes, view);
    }
    
    /**
     * This method provides drawing Rectangles on the panel.
     * @param graphics graphic object used for drawing.
     */
    @Override
    public void draw(Graphics2D graphics)
    {
        view.draw(shapes, graphics);
    }
    
    /**
     * This method sets the central position on the screen for every Rectangle object.
     * @param centre central position of the screen.
     */
    @Override
    public void centralise(Dimension centre)
    {
        
        Rectangle[] rectangles = (Rectangle[]) getShapes();
        
        for (Rectangle rec : rectangles)
        {
            rec.setX((int) (centre.width - rec.getWidth() / 2));
            rec.setY((int) (centre.height - rec.getHeight() / 2));
        }
    }
    
}

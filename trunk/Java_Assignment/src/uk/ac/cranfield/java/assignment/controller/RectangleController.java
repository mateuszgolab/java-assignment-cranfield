package uk.ac.cranfield.java.assignment.controller;

import java.awt.Dimension;
import java.awt.Graphics2D;

import uk.ac.cranfield.java.assignment.model.shape.MyShape;
import uk.ac.cranfield.java.assignment.model.shape.Rectangle;
import uk.ac.cranfield.java.assignment.view.interfaces.Drawable;


public class RectangleController extends ShapeController
{
    
    public RectangleController(MyShape[] shapes, Drawable view)
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
        
        Rectangle[] rectangles = (Rectangle[]) getShapes();
        
        for (Rectangle rec : rectangles)
        {
            rec.setX((int) (centre.width - rec.getWidth() / 2));
            rec.setY((int) (centre.height - rec.getHeight() / 2));
        }
    }
    
}

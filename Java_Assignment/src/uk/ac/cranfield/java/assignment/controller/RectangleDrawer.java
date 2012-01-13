package uk.ac.cranfield.java.assignment.controller;

import java.awt.Dimension;
import java.awt.Graphics;

import uk.ac.cranfield.java.assignment.controller.utils.Sort;
import uk.ac.cranfield.java.assignment.model.shape.Rectangle;


public class RectangleDrawer extends ShapeDrawer
{
    
    private Rectangle[] rectangles;
    
    public RectangleDrawer(Rectangle[] rectangles)
    {
        this.rectangles = rectangles;
        if (rectangles == null)
            this.rectangles = new Rectangle[0];
    }
    
    @Override
    public void draw(Graphics graphics)
    {
        clearScreen(graphics);
        
        for (Rectangle rec : rectangles)
        {
            graphics.setColor(rec.getColor());
            graphics.fillRect(rec.getX(), rec.getY(), (int) rec.getWidth(), (int) rec.getHeight());
        }
    }
    
    
    @Override
    public void sort(Graphics graphics, Dimension centre)
    {
        Sort.shell_sort(rectangles);
        
        for (Rectangle rec : rectangles)
        {
            rec.setX((int) (centre.width - rec.getWidth() / 2));
            rec.setY((int) (centre.height - rec.getHeight() / 2));
        }
    }
    
}

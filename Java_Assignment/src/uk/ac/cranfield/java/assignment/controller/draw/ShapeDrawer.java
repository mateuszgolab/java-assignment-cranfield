package uk.ac.cranfield.java.assignment.controller.draw;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import uk.ac.cranfield.java.assignment.controller.utils.FrameToolkit;


public abstract class ShapeDrawer
{
    
    public abstract void draw(Graphics2D graphics);
    
    public abstract void sort(Graphics graphics, Dimension centre);
    
    protected void clearScreen(Graphics2D graphics)
    {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, FrameToolkit.getMaxWidth(), FrameToolkit.getMaxWidth());
    }
    
    
}

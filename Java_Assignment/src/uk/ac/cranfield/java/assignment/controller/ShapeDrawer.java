package uk.ac.cranfield.java.assignment.controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import uk.ac.cranfield.java.assignment.controller.utils.FrameToolkit;


public abstract class ShapeDrawer
{
    
    public abstract void draw(Graphics g);
    
    public abstract void sort(Graphics graphics, Dimension centre);
    
    protected void clearScreen(Graphics graphics)
    {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, FrameToolkit.getMaxWidth(), FrameToolkit.getMaxWidth());
    }
    
    
}

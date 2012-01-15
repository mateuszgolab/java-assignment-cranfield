package uk.ac.cranfield.java.assignment.view.interfaces;

import java.awt.Graphics2D;

import uk.ac.cranfield.java.assignment.model.shape.MyShape;


public interface Drawable
{
    
    public abstract void draw(MyShape[] shapes, Graphics2D graphics);
}

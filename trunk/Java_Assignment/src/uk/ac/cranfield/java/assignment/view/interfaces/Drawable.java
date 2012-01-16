package uk.ac.cranfield.java.assignment.view.interfaces;

import java.awt.Graphics2D;

import uk.ac.cranfield.java.assignment.model.shape.MyShape;

/**
 * The interface should be implemented by shape drawing class.
 * @author Mateusz Golab
 * @version 1.0
 */
public interface Drawable
{
    
    /**
     * This method should draw given shapes using given graphics object.
     * @param shapes shapes to be drawn.
     * @param graphics rendering object.
     */
    public void draw(MyShape[] shapes, Graphics2D graphics);
}

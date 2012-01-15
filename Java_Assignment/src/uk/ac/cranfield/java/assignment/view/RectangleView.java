package uk.ac.cranfield.java.assignment.view;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import uk.ac.cranfield.java.assignment.model.shape.MyShape;
import uk.ac.cranfield.java.assignment.model.shape.Rectangle;
import uk.ac.cranfield.java.assignment.view.interfaces.Drawable;


public class RectangleView implements Drawable
{
    
    
    @Override
    public void draw(MyShape[] shapes, Graphics2D graphics)
    {
        Rectangle[] rectangles = (Rectangle[]) shapes;
        
        for (Rectangle rec : rectangles)
        {
            graphics.setColor(rec.getColor());
            Rectangle2D rectangle = new Rectangle2D.Double(rec.getX(), rec.getY(), rec.getWidth(), rec.getHeight());
            graphics.fill(rectangle);
        }
        
    }
    
}

package uk.ac.cranfield.java.assignment.controller.draw;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import uk.ac.cranfield.java.assignment.controller.utils.Sort;
import uk.ac.cranfield.java.assignment.model.shape.Circle;


public class CircleDrawer extends ShapeDrawer
{
    
    private Circle[] circles;
    
    public CircleDrawer(Circle[] Circles)
    {
        this.circles = Circles;
        if (Circles == null)
            this.circles = new Circle[0];
    }
    
    @Override
    public void draw(Graphics2D graphics)
    {
        clearScreen(graphics);
        
        for (Circle cir : circles)
        {
            graphics.setColor(cir.getColor());
            graphics.fillOval(cir.getX(), cir.getY(), (int) (2 * cir.getRadius()), (int) (2 * cir.getRadius()));
        }
    }
    
    @Override
    public void sort(Graphics graphics, Dimension centre)
    {
        Sort.shell_sort(circles);
        
        for (Circle cir : circles)
        {
            cir.setX((int) (centre.width - cir.getRadius()));
            cir.setY((int) (centre.height - cir.getRadius()));
        }
    }
    
}

package uk.ac.cranfield.java.assignment.controller.draw;

import java.awt.Dimension;
import java.awt.Graphics2D;

import uk.ac.cranfield.java.assignment.controller.interfaces.ShapeController;
import uk.ac.cranfield.java.assignment.controller.utils.Sort;
import uk.ac.cranfield.java.assignment.model.shape.Circle;
import uk.ac.cranfield.java.assignment.model.shape.MyShape;
import uk.ac.cranfield.java.assignment.view.interfaces.Drawable;


public class CircleController extends ShapeController
{
    
    public CircleController(MyShape[] shapes, Drawable view)
    {
        super(shapes, view);
    }
    
    
    @Override
    public void draw(Graphics2D graphics)
    {
        view.draw(shapes, graphics);
    }
    
    @Override
    public void sort(Dimension centre)
    {
        Sort.shell_sort(shapes);
        
        Circle[] circles = (Circle[]) shapes;
        
        for (Circle cir : circles)
        {
            cir.setX((int) (centre.width - cir.getRadius()));
            cir.setY((int) (centre.height - cir.getRadius()));
        }
    }
    
    
}

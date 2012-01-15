package uk.ac.cranfield.java.assignment.controller;

import java.awt.Dimension;
import java.awt.Graphics2D;

import uk.ac.cranfield.java.assignment.controller.utils.Sort;
import uk.ac.cranfield.java.assignment.model.shape.MyShape;
import uk.ac.cranfield.java.assignment.view.interfaces.Drawable;


public abstract class ShapeController
{
    
    protected MyShape[] shapes;
    protected Drawable view;
    
    public ShapeController(MyShape[] shapes, Drawable view)
    {
        this.shapes = shapes;
        this.view = view;
    }
    
    public abstract void draw(Graphics2D graphics);
    
    public abstract void centralise(Dimension centre);
    
    public void sort()
    {
        Sort.shell_sort(getShapes());
    }
    
    public synchronized MyShape[] getShapes()
    {
        return shapes;
    }
}

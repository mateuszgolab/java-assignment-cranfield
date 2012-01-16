package uk.ac.cranfield.java.assignment.controller;

import java.awt.Dimension;
import java.awt.Graphics2D;

import uk.ac.cranfield.java.assignment.controller.utils.Sort;
import uk.ac.cranfield.java.assignment.model.shape.MyShape;
import uk.ac.cranfield.java.assignment.view.interfaces.Drawable;

/**
 * The abstract shape controller class.
 * Provides abstract methods for controlling shapes.
 * Also provides sorting method and synchronized data accessor
 * @author Mateusz Golab
 * @version 1.0
 */
public abstract class ShapeController
{
    
    /**
     * The table of shapes.
     */
    protected MyShape[] shapes;
    
    /**
     * The reference to view object.
     */
    protected Drawable view;
    
    /**
     * The constructor initializes shapes objects and view object.
     * @param shapes shapes objects to initialize.
     * @param view the view responisble object.
     */
    public ShapeController(MyShape[] shapes, Drawable view)
    {
        this.shapes = shapes;
        this.view = view;
    }
    
    /**
     * Abstract method responsible for calling specified view object.
     * @param graphics graphic object used for drawing.
     */
    public abstract void draw(Graphics2D graphics);
    
    /**
     * Abstract method responsible for setting the shapes in the central position of the screen.
     * @param centre central position of the screen.
     */
    public abstract void centralise(Dimension centre);
    
    /**
     * Performs shapes sorting.
     */
    public void sort()
    {
        Sort.shell_sort(getShapes());
    }
    
    /**
     * This method is the shapes object accessor.
     * It can be called from many threads so has to be synchronised.
     * @return
     */
    public synchronized MyShape[] getShapes()
    {
        return shapes;
    }
}

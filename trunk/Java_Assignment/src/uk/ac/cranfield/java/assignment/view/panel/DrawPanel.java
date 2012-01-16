package uk.ac.cranfield.java.assignment.view.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import uk.ac.cranfield.java.assignment.controller.ShapeController;
import uk.ac.cranfield.java.assignment.controller.utils.FrameToolkit;
import uk.ac.cranfield.java.assignment.controller.worker.SortingDelayWorker;
import uk.ac.cranfield.java.assignment.model.shape.MyShape;

/**
 * This class provides main drawing panel of the application
 * Extends {@link JPanel}. Every shape in applicaion is drawn on this panel.
 * @author Mateusz Golab
 * @version 1.0
 * @see JPanel
 */
@SuppressWarnings("serial")
public class DrawPanel extends JPanel
{
    
    /**
     * Reference to shape controller.
     */
    private ShapeController controller;
    
    /**
     * The constructor creates drawing panel.
     * Sets background color to white.
     */
    public DrawPanel()
    {
        setBackground(Color.WHITE);
    }
    
    /**
     * This method sets shape controller to provide proper control of drawing shapes.
     * @param controller the instance of shape controller.
     */
    public void setController(ShapeController controller)
    {
        this.controller = controller;
    }
    
    
    /**
     * This method sets shape controller to provide proper control of drawing shapes.
     * Additionally new controller launches sorting and drawing worker.
     * @param controller the instance of shape controller.
     */
    public void setControllerAndSort(ShapeController controller)
    {
        this.controller = controller;
        new SortingDelayWorker(controller, this, ShapeController.SORT_DELAY_TIME).execute();
    }
    
    /**
     * This method is overriden from JPanel.
     * Performs standard painting from JPanel.
     * Additionally sets antialiasing rendering and launches drawing from the controller.
     */
    @Override
    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
        ((Graphics2D) graphics).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, FrameToolkit.getMaxWidth(), FrameToolkit.getMaxWidth());
        
        if (controller != null)
            controller.draw((Graphics2D) graphics);
    }
    
    
    /**
     * This method provides currently used shapes.
     * Returns null if no shapes in use.
     * @return current shapes.
     */
    public MyShape[] getShapes()
    {
        if (controller == null)
            return null;
        return controller.getShapes();
    }
    
    /**
     * This method launches shapes location centralising method from the controller.
     * @param centre centre of the screen location
     */
    public void centralise(Dimension centre)
    {
        if (controller != null)
        {
            controller.centralise(centre);
            repaint();
        }
    }
    
    
}

package uk.ac.cranfield.java.assignment.view.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import uk.ac.cranfield.java.assignment.controller.interfaces.ShapeController;
import uk.ac.cranfield.java.assignment.controller.utils.FrameToolkit;
import uk.ac.cranfield.java.assignment.controller.worker.SortingDelayWorker;
import uk.ac.cranfield.java.assignment.model.shape.MyShape;


@SuppressWarnings("serial")
public class DrawPanel extends JPanel
{
    
    private static long SORT_DELAY_TIME = 1000;
    private ShapeController controller;
    
    public DrawPanel()
    {
        setBackground(Color.WHITE);
    }
    
    public void setController(ShapeController controller)
    {
        this.controller = controller;
    }
    
    public void setControllerAndSort(ShapeController controller)
    {
        this.controller = controller;
        new SortingDelayWorker(controller, this, SORT_DELAY_TIME).execute();
    }
    
    
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
    
    public MyShape[] getShapes()
    {
        if (controller == null)
            return null;
        return controller.getShapes();
    }
    
    public void centralise(Dimension d)
    {
        if (controller != null)
        {
            controller.centralise(d);
            repaint();
        }
    }
    
    
}

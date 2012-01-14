package uk.ac.cranfield.java.assignment.controller;

import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.SwingWorker;

import uk.ac.cranfield.java.assignment.controller.draw.ShapeDrawer;
import uk.ac.cranfield.java.assignment.controller.utils.FrameToolkit;


public class SortingDelayWorker extends SwingWorker<Void, Void>
{
    
    private ShapeDrawer drawer;
    private JPanel panel;
    private long delay;
    
    public SortingDelayWorker(ShapeDrawer drawer, JPanel panel, long delay)
    {
        this.drawer = drawer;
        this.panel = panel;
        this.delay = delay;
    }
    
    @Override
    protected Void doInBackground() throws Exception
    {
        drawer.draw((Graphics2D) panel.getGraphics());
        Thread.sleep(delay);
        drawer.sort(panel.getGraphics(), FrameToolkit.getPanelCenter(panel));
        return null;
    }
    
    @Override
    public void done()
    {
        drawer.draw((Graphics2D) panel.getGraphics());
    }
}

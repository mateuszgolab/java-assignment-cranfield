package uk.ac.cranfield.java.assignment.controller.worker;

import javax.swing.JPanel;
import javax.swing.SwingWorker;

import uk.ac.cranfield.java.assignment.controller.interfaces.ShapeController;
import uk.ac.cranfield.java.assignment.controller.utils.FrameToolkit;


public class SortingDelayWorker extends SwingWorker<Void, Void>
{
    
    private ShapeController controller;
    private JPanel panel;
    private long delay;
    
    public SortingDelayWorker(ShapeController controller, JPanel panel, long delay)
    {
        this.controller = controller;
        this.panel = panel;
        this.delay = delay;
    }
    
    @Override
    protected Void doInBackground() throws Exception
    {
        panel.repaint();
        controller.sort();
        Thread.sleep(delay);
        
        return null;
    }
    
    @Override
    public void done()
    {
        controller.centralise(FrameToolkit.getPanelCenter(panel));
        panel.repaint();
    }
}

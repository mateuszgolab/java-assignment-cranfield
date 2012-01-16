package uk.ac.cranfield.java.assignment.controller.worker;

import javax.swing.JPanel;
import javax.swing.SwingWorker;

import uk.ac.cranfield.java.assignment.controller.ShapeController;
import uk.ac.cranfield.java.assignment.controller.utils.FrameToolkit;

/**
 * This class extends SwingWorker
 * It is responsible for sorting shapes and performing the given delay of the application.
 * Sorting process, the same as delaying performs in worker thread (doInBackground method)
 * Setting shapes position and painting performs after worker has finished (done method)
 * @author Mateusz Golab
 * @version 1.0
 * @see SwingWorker
 */
public class SortingDelayWorker extends SwingWorker<Void, Void>
{
    
    /**
     * The instance of shape controller.
     */
    private ShapeController controller;
    
    /**
     * Instance of panel, where shapes will be drawn.
     */
    private JPanel panel;
    
    /**
     * Delay time in miliseconds.
     */
    private long delay;
    
    /**
     * The constructor initializes controller, drawing panel and sets delay time.
     * @param controller instance of shape controller.
     * @param panel drawing panel.
     * @param delay delay time in ms.
     */
    public SortingDelayWorker(ShapeController controller, JPanel panel, long delay)
    {
        this.controller = controller;
        this.panel = panel;
        this.delay = delay;
    }
    
    /**
     * This method is called in worker thread.
     * Performs sorting and delaying process
     */
    @Override
    protected Void doInBackground() throws Exception
    {
        panel.repaint();
        controller.sort();
        Thread.sleep(delay);
        
        return null;
    }
    
    /**
     * This method is called just after worker thread has finished his job .
     * It is called in Event Dispatch Thread.
     * Performs setting shapes position and drawing them on the panel.
     */
    @Override
    public void done()
    {
        controller.centralise(FrameToolkit.getPanelCenter(panel));
        panel.repaint();
    }
}

package uk.ac.cranfield.java.assignment.controller.worker;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import uk.ac.cranfield.java.assignment.controller.CircleController;
import uk.ac.cranfield.java.assignment.controller.EllipseController;
import uk.ac.cranfield.java.assignment.controller.RectangleController;
import uk.ac.cranfield.java.assignment.controller.utils.FrameToolkit;
import uk.ac.cranfield.java.assignment.model.shape.Circle;
import uk.ac.cranfield.java.assignment.model.shape.Ellipse;
import uk.ac.cranfield.java.assignment.model.shape.MyShape;
import uk.ac.cranfield.java.assignment.model.shape.Rectangle;
import uk.ac.cranfield.java.assignment.view.CircleView;
import uk.ac.cranfield.java.assignment.view.EllipseView;
import uk.ac.cranfield.java.assignment.view.RectangleView;
import uk.ac.cranfield.java.assignment.view.panel.DrawPanel;

/**
 * This class extends SwingWorker
 * It is responsible for reading serializable objects from the file.
 * The reading process performs in dedicated worker thread (doInBackground method).
 * Restored objects are drawn after worker has finished (done method)
 * @author Mateusz Golab
 * @version 1.0
 * @see SwingWorker
 */
public class LoadFileWorker extends SwingWorker<Void, Void>
{
    
    /**
     * Name of the file to read from.
     */
    private String fileName;
    
    /**
     * Instance of drawing panel.
     */
    private DrawPanel panel;
    
    /**
     * The constructor initializes drawing panel and file name.
     * @param fileName name of the file to read from.
     * @param component drawing panel instance.
     */
    public LoadFileWorker(String fileName, DrawPanel component)
    {
        this.fileName = fileName;
        this.panel = component;
    }
    
    /**
     * This method is called in worker thread.
     * Performs objects restoring process.
     */
    @Override
    protected Void doInBackground() throws Exception
    {
        try
        {
            // opening the file
            InputStream file = new FileInputStream(fileName);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);
            try
            {
                // reading from file
                MyShape[] shapes = (MyShape[]) input.readObject();
                
                if (shapes instanceof Rectangle[])
                    panel.setController(new RectangleController(shapes, new RectangleView()));
                else if (shapes instanceof Circle[])
                    panel.setController(new CircleController(shapes, new CircleView()));
                else if (shapes instanceof Ellipse[])
                    panel.setController(new EllipseController(shapes, new EllipseView()));
                
            }
            finally
            {
                input.close();
                file.close();
            }
        }
        catch (ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, "Shapes could not be read from this file", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        catch (IOException ex)
        {
            JOptionPane.showMessageDialog(null, "Shapes could not be read from this file", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        
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
        panel.centralise(FrameToolkit.getPanelCenter(panel));
        panel.repaint();
        
    }
}

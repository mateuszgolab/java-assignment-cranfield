package uk.ac.cranfield.java.assignment.controller.worker;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

import javax.swing.SwingWorker;

import uk.ac.cranfield.java.assignment.controller.shape.CircleController;
import uk.ac.cranfield.java.assignment.controller.shape.EllipseController;
import uk.ac.cranfield.java.assignment.controller.shape.RectangleController;
import uk.ac.cranfield.java.assignment.model.shape.Circle;
import uk.ac.cranfield.java.assignment.model.shape.Ellipse;
import uk.ac.cranfield.java.assignment.model.shape.MyShape;
import uk.ac.cranfield.java.assignment.model.shape.Rectangle;
import uk.ac.cranfield.java.assignment.view.DrawPanel;
import uk.ac.cranfield.java.assignment.view.shape.CircleView;
import uk.ac.cranfield.java.assignment.view.shape.EllipseView;
import uk.ac.cranfield.java.assignment.view.shape.RectangleView;


public class LoadFileWorker extends SwingWorker<Void, Void>
{
    
    private String fileName;
    private DrawPanel panel;
    
    public LoadFileWorker(String fileName, DrawPanel component)
    {
        this.fileName = fileName;
        this.panel = component;
    }
    
    @Override
    protected Void doInBackground() throws Exception
    {
        try
        {
            InputStream file = new FileInputStream(fileName);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);
            try
            {
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
            // fLogger.log(Level.SEVERE, "Cannot perform input. Class not found.", ex);
        }
        catch (IOException ex)
        {
            // fLogger.log(Level.SEVERE, "Cannot perform input.", ex);
        }
        
        return null;
    }
    
    @Override
    public void done()
    {
        panel.repaint();
        
    }
}

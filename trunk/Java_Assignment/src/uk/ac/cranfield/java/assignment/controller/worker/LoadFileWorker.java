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
    
    @Override
    public void done()
    {
        panel.centralise(FrameToolkit.getPanelCenter(panel));
        panel.repaint();
        
    }
}

package uk.ac.cranfield.java.assignment.controller.worker;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import uk.ac.cranfield.java.assignment.model.shape.MyShape;


public class SaveFileWorker extends SwingWorker<Void, Void>
{
    
    private String filePath;
    private String fileName;
    private MyShape[] shapes;
    
    public SaveFileWorker(String path, String name, MyShape[] shapes)
    {
        this.filePath = path;
        this.fileName = name;
        this.shapes = shapes;
    }
    
    @Override
    protected Void doInBackground() throws Exception
    {
        try
        {
            OutputStream file = new FileOutputStream(filePath);
            OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutput output = new ObjectOutputStream(buffer);
            
            try
            {
                output.writeObject(shapes);
            }
            finally
            {
                output.close();
                file.close();
            }
        }
        catch (IOException ex)
        {
            JOptionPane.showMessageDialog(null, "Shapes could not be saved", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return null;
    }
    
    @Override
    public void done()
    {
        JOptionPane.showMessageDialog(null, fileName + " saved successfully", "Success",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
}

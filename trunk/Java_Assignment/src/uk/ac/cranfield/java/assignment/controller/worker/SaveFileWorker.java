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

/**
 * This class extends SwingWorker
 * It is responsible for saving serializable objects to the file.
 * The saving process performs in dedicated worker thread (doInBackground method).
 * Process result is shown after worker has finished (done method)
 * @author Mateusz Golab
 * @version 1.0
 * @see SwingWorker
 */
public class SaveFileWorker extends SwingWorker<Void, Void>
{
    
    /**
     * Full path of the file to save.
     */
    private String filePath;
    
    /**
     * Name of the file to save.
     */
    private String fileName;
    
    /**
     * Table of shape objects to save in a file.
     */
    private MyShape[] shapes;
    
    /**
     * The constructor initializes file path and name.
     * Shapes table is alse set by constructor.
     * @param path file path
     * @param name file name
     * @param shapes shapes to save in a file
     */
    public SaveFileWorker(String path, String name, MyShape[] shapes)
    {
        this.filePath = path;
        this.fileName = name;
        this.shapes = shapes;
    }
    
    /**
     * This method is called in worker thread.
     * Performs objects saving process.
     * Will show an alert if error occured
     */
    @Override
    protected Void doInBackground() throws Exception
    {
        try
        {
            // opening/creating the file
            OutputStream file = new FileOutputStream(filePath);
            OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutput output = new ObjectOutputStream(buffer);
            
            try
            {
                // saving objects to the file
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
    
    /**
     * This method is called just after worker thread has finished his job .
     * It is called in Event Dispatch Thread.
     * Show the result of file saving to the user.
     */
    @Override
    public void done()
    {
        JOptionPane.showMessageDialog(null, fileName + " saved successfully", "Success",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
}

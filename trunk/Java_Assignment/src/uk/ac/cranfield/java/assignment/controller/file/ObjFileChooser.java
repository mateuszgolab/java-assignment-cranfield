package uk.ac.cranfield.java.assignment.controller.file;

import javax.swing.JFileChooser;


/**
 * The class extends JFileChooser.
 * Provides mechanism for the user to choose a .obj file.
 * @author Mateusz Golab
 * @version 1.0
 * @see JFileChooser
 */
@SuppressWarnings("serial")
public class ObjFileChooser extends JFileChooser
{
    
    /**
     * Instance of obj files filer
     */
    private ObjFileFilter filter;
    
    /**
     * The constructor generates new ObjFileChooser.
     * Creates and sets new Instance of ObjFileFilter
     */
    public ObjFileChooser()
    {
        filter = new ObjFileFilter();
        setFileFilter(filter);
    }
    
    /**
     * Returns file extension as a String
     * @return obj file extension
     */
    public String getExtension()
    {
        return filter.getDescription();
    }
    
    
}

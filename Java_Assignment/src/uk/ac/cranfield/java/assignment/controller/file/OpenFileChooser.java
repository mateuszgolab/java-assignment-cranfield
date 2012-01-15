package uk.ac.cranfield.java.assignment.controller.file;

import javax.swing.JFileChooser;


public class OpenFileChooser extends JFileChooser
{
    
    private ObjFileFilter filter;
    
    public OpenFileChooser()
    {
        filter = new ObjFileFilter();
        setFileFilter(filter);
    }
    
    public String getExtension()
    {
        return filter.getDescription();
    }
    
    
}

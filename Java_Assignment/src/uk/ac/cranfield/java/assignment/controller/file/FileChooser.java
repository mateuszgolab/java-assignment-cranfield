package uk.ac.cranfield.java.assignment.controller.file;

import javax.swing.JFileChooser;


@SuppressWarnings("serial")
public class FileChooser extends JFileChooser
{
    
    private ObjFileFilter filter;
    
    public FileChooser()
    {
        filter = new ObjFileFilter();
        setFileFilter(filter);
    }
    
    public String getExtension()
    {
        return filter.getDescription();
    }
    
    
}

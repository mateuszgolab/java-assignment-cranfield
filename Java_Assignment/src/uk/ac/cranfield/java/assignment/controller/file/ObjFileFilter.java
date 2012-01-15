package uk.ac.cranfield.java.assignment.controller.file;

import java.io.File;

import javax.swing.filechooser.FileFilter;


public class ObjFileFilter extends FileFilter
{
    
    public final static String obj = "obj";
    
    @Override
    public boolean accept(File f)
    {
        if (obj.compareToIgnoreCase(getExtension(f)) == 0)
            return true;
        return false;
    }
    
    @Override
    public String getDescription()
    {
        return "." + obj;
    }
    
    private String getExtension(File f)
    {
        String ext = "";
        String s = f.getName();
        int i = s.lastIndexOf('.');
        
        if (i > 0 && i < s.length() - 1)
        {
            ext = s.substring(i + 1).toLowerCase();
        }
        
        return ext;
    }
    
}

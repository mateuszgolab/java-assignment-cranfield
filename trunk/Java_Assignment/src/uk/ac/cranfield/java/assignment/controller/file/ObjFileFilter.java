package uk.ac.cranfield.java.assignment.controller.file;

import java.io.File;

import javax.swing.filechooser.FileFilter;

/**
 * The class extends FileFilter.
 * Provides filter implementation for .obj files.
 * @author Mateusz Golab
 * @version 1.0
 * @see FileFilter
 */
public class ObjFileFilter extends FileFilter
{
    
    /**
     * File extension
     */
    public final static String obj = "obj";
    
    /**
     * This methods filters files.
     * Only files with .obj extension are acceptable.
     * @return if the file has .obj extension.
     */
    @Override
    public boolean accept(File f)
    {
        if (obj.compareToIgnoreCase(getExtension(f)) == 0)
            return true;
        return false;
    }
    
    /**
     * Returns file extension
     * @return file extension as string value
     */
    @Override
    public String getDescription()
    {
        return "." + obj;
    }
    
    /**
     * This method return extension of given File as a String
     * @param f file to check
     * @return file extension as a String
     */
    private static String getExtension(File f)
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

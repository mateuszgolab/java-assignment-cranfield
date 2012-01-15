package uk.ac.cranfield.java.assignment.controller.action.menu;

import java.awt.Frame;

import javax.swing.AbstractAction;

import uk.ac.cranfield.java.assignment.controller.file.OpenFileChooser;
import uk.ac.cranfield.java.assignment.view.DrawPanel;


public abstract class FileMenuAction extends AbstractAction
{
    
    protected OpenFileChooser fileChooser;
    protected Frame parent;
    protected DrawPanel drawPanel;
    
    public FileMenuAction(Frame parent, String title, DrawPanel drawPanel)
    {
        super(title);
        this.parent = parent;
        fileChooser = new OpenFileChooser();
        this.drawPanel = drawPanel;
    }
    
    
}

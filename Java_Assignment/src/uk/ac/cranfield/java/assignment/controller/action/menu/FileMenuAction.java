package uk.ac.cranfield.java.assignment.controller.action.menu;

import java.awt.Frame;

import javax.swing.AbstractAction;
import javax.swing.Icon;

import uk.ac.cranfield.java.assignment.controller.file.FileChooser;
import uk.ac.cranfield.java.assignment.view.DrawPanel;


@SuppressWarnings("serial")
public abstract class FileMenuAction extends AbstractAction
{
    
    protected FileChooser fileChooser;
    protected Frame parent;
    protected DrawPanel drawPanel;
    
    public FileMenuAction(Frame parent, String title, Icon icon, DrawPanel drawPanel)
    {
        super(title, icon);
        this.parent = parent;
        fileChooser = new FileChooser();
        this.drawPanel = drawPanel;
    }
    
    
}

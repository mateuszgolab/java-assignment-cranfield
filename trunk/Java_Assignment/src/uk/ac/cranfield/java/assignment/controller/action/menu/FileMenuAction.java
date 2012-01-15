package uk.ac.cranfield.java.assignment.controller.action.menu;

import java.awt.Frame;

import javax.swing.AbstractAction;
import javax.swing.Icon;

import uk.ac.cranfield.java.assignment.controller.file.ObjFileChooser;
import uk.ac.cranfield.java.assignment.view.panel.DrawPanel;

/**
 * Abstract class representing menu action related to operations on files.
 * Extends abstract class AbstractAction
 * @author Mateusz Golab
 * @version 1.0
 * @see AbstractAction
 */
@SuppressWarnings("serial")
public abstract class FileMenuAction extends AbstractAction
{
    
    /**
     * Instance of the file chooser , providing mechanism for user to choose a file
     */
    protected ObjFileChooser objFileChooser;
    
    /**
     * Instance of the parent frame
     */
    protected Frame parent;
    
    /**
     * Instance of the drawing panel
     */
    protected DrawPanel drawPanel;
    
    /**
     * This constructor is used by inherited classes
     * @param parent instance of parent frame
     * @param title title of the menu item
     * @param icon icon of the menu item
     * @param drawPanel instance of drawing panel
     */
    public FileMenuAction(Frame parent, String title, Icon icon, DrawPanel drawPanel)
    {
        super(title, icon);
        this.parent = parent;
        this.drawPanel = drawPanel;
        objFileChooser = new ObjFileChooser();
    }
    
    
}

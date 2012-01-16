package uk.ac.cranfield.java.assignment.view.menu;

import javax.swing.JMenu;

import uk.ac.cranfield.java.assignment.controller.action.menu.OpenFileAction;
import uk.ac.cranfield.java.assignment.controller.action.menu.SaveFileAction;
import uk.ac.cranfield.java.assignment.view.frame.MainFrame;
import uk.ac.cranfield.java.assignment.view.panel.DrawPanel;

/**
 * This class represents menu for file operations.
 * Extends {@link JMenu}.
 * @author Mateusz Golab
 * @version 1.0
 * @see JMenu
 */
@SuppressWarnings("serial")
public class FileMenu extends JMenu
{
    
    /**
     * The constructor creates new file menu containing open and save actions.
     * @param parent parent frame
     * @param drawPanel drawing panel
     */
    public FileMenu(MainFrame parent, DrawPanel drawPanel)
    {
        super("File");
        
        add(new OpenFileAction(parent, drawPanel));
        add(new SaveFileAction(parent, drawPanel));
    }
}

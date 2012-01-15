package uk.ac.cranfield.java.assignment.controller.action.menu;

import java.awt.Frame;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import uk.ac.cranfield.java.assignment.controller.worker.LoadFileWorker;
import uk.ac.cranfield.java.assignment.view.panel.DrawPanel;

/**
 * The class responsible for opening the files.
 * Inherits from abstract base class FileMenuAction.
 * Implements actionPerformed method of the AbstractAction which is extended by FileMenuAction.
 * @author Mateusz Golab
 * @version 1.0
 * @see FileMenuAction
 */
@SuppressWarnings("serial")
public class OpenFileAction extends FileMenuAction
{
    
    /**
     * The constructor uses super class constructor to create the object.
     * Sets "Open" as a title and specified icon.
     * @param parent parent frame instance
     * @param panel instance of drawing panel
     */
    public OpenFileAction(Frame parent, DrawPanel panel)
    {
        super(parent, "Open", new ImageIcon("icons/Folder-Open-icon.png"), panel);
    }
    
    
    /**
     * Implementation of AbstractAction method.
     * Launches file chooser to make it possible for the user to choose a file from the computer.
     * Worker responsible for Loading file is launched after choosing specified file.
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        int result = objFileChooser.showOpenDialog(parent);
        
        switch (result) {
            case JFileChooser.APPROVE_OPTION:
                new LoadFileWorker(objFileChooser.getSelectedFile().getAbsolutePath(), drawPanel).execute();
                break;
            case JFileChooser.CANCEL_OPTION:
                break;
        }
    }
}

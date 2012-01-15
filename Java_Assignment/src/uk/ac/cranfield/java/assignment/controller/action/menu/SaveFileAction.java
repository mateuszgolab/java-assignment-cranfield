package uk.ac.cranfield.java.assignment.controller.action.menu;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import uk.ac.cranfield.java.assignment.controller.worker.SaveFileWorker;
import uk.ac.cranfield.java.assignment.view.frame.MainFrame;
import uk.ac.cranfield.java.assignment.view.panel.DrawPanel;

/**
 * The class responsible for saving the files.
 * Inherits from abstract base class FileMenuAction.
 * Implements actionPerformed method of the AbstractAction which is extended by FileMenuAction.
 * @author Mateusz Golab
 * @version 1.0
 * @see FileMenuAction
 */
@SuppressWarnings("serial")
public class SaveFileAction extends FileMenuAction
{
    
    /**
     * The constructor uses super class constructor to create the object.
     * Sets "Save" as a title and specified icon.
     * @param parent parent frame instance
     * @param panel instance of drawing panel
     */
    public SaveFileAction(MainFrame parent, DrawPanel panel)
    {
        super(parent, "Save", new ImageIcon("icons/Save-icon.png"), panel);
    }
    
    /**
     * Implementation of AbstractAction method.
     * Launches file chooser to make it possible for the user to write the name fo the file and choose a folder from the
     * computer to be saved in.
     * Worker responsible for saving the file is launched after choosing specified file location and name.
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        int result = objFileChooser.showSaveDialog(parent);
        
        switch (result) {
            case JFileChooser.APPROVE_OPTION:
                String path = objFileChooser.getSelectedFile().getAbsolutePath() + objFileChooser.getExtension();
                String name = objFileChooser.getSelectedFile().getName() + objFileChooser.getExtension();
                new SaveFileWorker(path, name, drawPanel.getShapes()).execute();
                break;
            case JFileChooser.CANCEL_OPTION:
                break;
        }
    }
}

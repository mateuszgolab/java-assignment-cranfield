package uk.ac.cranfield.java.assignment.controller.action.menu;

import java.awt.Frame;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;

import uk.ac.cranfield.java.assignment.view.dialog.DisplayDialog;

/**
 * The class representing menu action related to launching dialog for specified shape.
 * Extends abstract class AbstractAction
 * This class is used for every kind of shape existing in application
 * @author Mateusz Golab
 * @version 1.0
 * @see AbstractAction
 */
@SuppressWarnings("serial")
public class ShapeMenuAction extends AbstractAction
{
    
    /**
     * Instance of dialog to be shown
     */
    private DisplayDialog dialog;
    
    /**
     * The constructor is used by inherited classes
     * @param parent instance of parent frame
     * @param title title of the menu item
     * @param icon icon of the menu item
     * @param dialog instance of dialog to be shown
     */
    public ShapeMenuAction(Frame parent, String title, Icon icon, DisplayDialog dialog)
    {
        super(title, icon);
        this.dialog = dialog;
    }
    
    
    /**
     * Implementation of AbstractAction method.
     * Resets dialog state and then shows it.
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        dialog.reset();
        dialog.show();
    }
    
}

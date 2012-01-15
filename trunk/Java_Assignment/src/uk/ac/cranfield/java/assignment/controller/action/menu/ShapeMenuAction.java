package uk.ac.cranfield.java.assignment.controller.action.menu;

import java.awt.Frame;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;

import uk.ac.cranfield.java.assignment.view.dialog.DisplayDialog;


@SuppressWarnings("serial")
public class ShapeMenuAction extends AbstractAction
{
    
    private DisplayDialog dialog;
    
    public ShapeMenuAction(Frame parent, String title, Icon icon, DisplayDialog dialog)
    {
        super(title, icon);
        this.dialog = dialog;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        dialog.reset();
        dialog.show();
    }
    
}

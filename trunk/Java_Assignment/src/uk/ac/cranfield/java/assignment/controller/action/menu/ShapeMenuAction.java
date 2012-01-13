package uk.ac.cranfield.java.assignment.controller.action.menu;

import java.awt.Frame;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import uk.ac.cranfield.java.assignment.model.dialog.NDialog;


@SuppressWarnings("serial")
public class ShapeMenuAction extends AbstractAction {
    
    private NDialog dialog;

    public ShapeMenuAction(Frame parent, String title, NDialog dialog) {
        super(title);
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dialog.show();
    }
    
}

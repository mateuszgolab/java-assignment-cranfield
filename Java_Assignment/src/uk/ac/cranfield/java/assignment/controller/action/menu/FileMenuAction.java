package uk.ac.cranfield.java.assignment.controller.action.menu;

import java.awt.Frame;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import uk.ac.cranfield.java.assignment.model.dialog.NDialog;


public class FileMenuAction extends AbstractAction {
    
    private NDialog dialog;
    
    public FileMenuAction(Frame parent, String title) {
        super(title);
        this.dialog = new NDialog(parent, title, null, true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dialog.show();
    }
    
}
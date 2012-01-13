package uk.ac.cranfield.java.assignment.model.dialog;

import java.awt.Dialog;


public class DisplayDialogClient implements DialogClient {
    
    @Override
    public void dialogDimissed(Dialog d, Object arg) {
        System.exit(0);
        
    }
    
}

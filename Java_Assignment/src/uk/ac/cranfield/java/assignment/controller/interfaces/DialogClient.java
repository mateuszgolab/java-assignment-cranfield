package uk.ac.cranfield.java.assignment.controller.interfaces;


import java.awt.Dialog;

/**
 * Interface that should be implemented by classes that needes to be notified
 * whether dialog has been dismissed.
 * @author
 * @version 1.1
 * typo in method's name corrected
 */
public interface DialogClient
{
    
    /**
     * Executes an action when a dialog is dismissed.
     * @param d the dialog being dimissed.
     * @param arg useful information during dismissing process.
     */
    abstract public void dialogDismissed(Dialog d, Object arg);
}

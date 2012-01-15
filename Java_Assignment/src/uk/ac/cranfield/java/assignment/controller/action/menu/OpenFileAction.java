package uk.ac.cranfield.java.assignment.controller.action.menu;

import java.awt.Frame;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import uk.ac.cranfield.java.assignment.controller.worker.LoadFileWorker;
import uk.ac.cranfield.java.assignment.view.DrawPanel;


@SuppressWarnings("serial")
public class OpenFileAction extends FileMenuAction
{
    
    public OpenFileAction(Frame parent, DrawPanel panel)
    {
        super(parent, "Open", new ImageIcon("icons/Folder-Open-icon.png"), panel);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        int result = fileChooser.showOpenDialog(parent);
        
        switch (result) {
            case JFileChooser.APPROVE_OPTION:
                new LoadFileWorker(fileChooser.getSelectedFile().getAbsolutePath(), drawPanel).execute();
                break;
            case JFileChooser.CANCEL_OPTION:
                break;
        }
    }
}

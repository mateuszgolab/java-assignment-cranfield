package uk.ac.cranfield.java.assignment.controller.action.menu;

import java.awt.Frame;
import java.awt.event.ActionEvent;

import javax.swing.JFileChooser;

import uk.ac.cranfield.java.assignment.controller.worker.SaveFileWorker;
import uk.ac.cranfield.java.assignment.view.DrawPanel;


public class SaveFileAction extends FileMenuAction
{
    
    public SaveFileAction(Frame parent, DrawPanel panel)
    {
        super(parent, "Save file", panel);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        int result = fileChooser.showSaveDialog(parent);
        
        switch (result) {
            case JFileChooser.APPROVE_OPTION:
                String path = fileChooser.getSelectedFile().getAbsolutePath() + fileChooser.getExtension();
                String name = fileChooser.getSelectedFile().getName() + fileChooser.getExtension();
                new SaveFileWorker(path, name, drawPanel.getShapes()).execute();
                break;
            case JFileChooser.CANCEL_OPTION:
                break;
        }
        
        
    }
    
}

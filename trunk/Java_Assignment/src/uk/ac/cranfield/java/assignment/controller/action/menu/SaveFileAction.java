package uk.ac.cranfield.java.assignment.controller.action.menu;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import uk.ac.cranfield.java.assignment.controller.worker.SaveFileWorker;
import uk.ac.cranfield.java.assignment.view.DrawPanel;
import uk.ac.cranfield.java.assignment.view.MainFrame;


@SuppressWarnings("serial")
public class SaveFileAction extends FileMenuAction
{
    
    public SaveFileAction(MainFrame parent, DrawPanel panel)
    {
        super(parent, "Save", new ImageIcon("icons/Save-icon.png"), panel);
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

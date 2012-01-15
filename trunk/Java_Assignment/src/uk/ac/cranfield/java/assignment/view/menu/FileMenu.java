package uk.ac.cranfield.java.assignment.view.menu;

import javax.swing.JMenu;

import uk.ac.cranfield.java.assignment.controller.action.menu.OpenFileAction;
import uk.ac.cranfield.java.assignment.controller.action.menu.SaveFileAction;
import uk.ac.cranfield.java.assignment.view.frame.MainFrame;
import uk.ac.cranfield.java.assignment.view.panel.DrawPanel;


@SuppressWarnings("serial")
public class FileMenu extends JMenu
{
    
    public FileMenu(MainFrame parent, DrawPanel drawPanel)
    {
        super("File");
        
        add(new OpenFileAction(parent, drawPanel));
        add(new SaveFileAction(parent, drawPanel));
    }
}
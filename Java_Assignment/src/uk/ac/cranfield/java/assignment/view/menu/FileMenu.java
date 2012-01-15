package uk.ac.cranfield.java.assignment.view.menu;

import java.awt.Frame;

import javax.swing.JMenu;

import uk.ac.cranfield.java.assignment.controller.action.menu.OpenFileAction;
import uk.ac.cranfield.java.assignment.controller.action.menu.SaveFileAction;
import uk.ac.cranfield.java.assignment.view.DrawPanel;


public class FileMenu extends JMenu
{
    
    public FileMenu(Frame parent, DrawPanel drawPanel)
    {
        super("File");
        
        add(new OpenFileAction(parent, drawPanel));
        add(new SaveFileAction(parent, drawPanel));
    }
}

package uk.ac.cranfield.java.assignment.view.menu;

import java.awt.Frame;

import javax.swing.JMenu;

import uk.ac.cranfield.java.assignment.controller.action.menu.FileMenuAction;


public class FileMenu extends JMenu {
    
    
    public FileMenu(Frame parent) {
        super("File");
        
        add(new FileMenuAction(parent, "Open"));
        add(new FileMenuAction(parent, "Save"));
    }

}

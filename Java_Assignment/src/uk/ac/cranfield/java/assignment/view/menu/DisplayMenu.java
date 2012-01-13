package uk.ac.cranfield.java.assignment.view.menu;

import java.awt.Frame;

import javax.swing.JMenu;

import uk.ac.cranfield.java.assignment.controller.action.menu.EllipseDisplayAction;
import uk.ac.cranfield.java.assignment.controller.action.menu.ShapeMenuAction;
import uk.ac.cranfield.java.assignment.model.dialog.DisplayDialogClient;
import uk.ac.cranfield.java.assignment.model.dialog.info.RectangleDialogInfo;
import uk.ac.cranfield.java.assignment.view.DrawPanel;
import uk.ac.cranfield.java.assignment.view.dialog.RectangleDisplayDialog;


public class DisplayMenu extends JMenu
{
    
    private static String rectangleTitle = "Rectangle";
    private DisplayDialogClient dialogClient;
    private RectangleDisplayDialog rectangleDialog;
    
    public DisplayMenu(Frame parent, DrawPanel drawPanel)
    {
        super("Display");
        
        dialogClient = new DisplayDialogClient();
        rectangleDialog = new RectangleDisplayDialog(parent, rectangleTitle, dialogClient, new RectangleDialogInfo(),
                drawPanel);
        add(new ShapeMenuAction(parent, rectangleTitle, rectangleDialog));
        
        
        add(new EllipseDisplayAction());
    }
    
    
}

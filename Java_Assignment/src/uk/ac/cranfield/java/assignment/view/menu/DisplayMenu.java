package uk.ac.cranfield.java.assignment.view.menu;

import java.awt.Frame;

import javax.swing.JMenu;

import uk.ac.cranfield.java.assignment.controller.action.menu.ShapeMenuAction;
import uk.ac.cranfield.java.assignment.controller.dialog.CircleDialogClient;
import uk.ac.cranfield.java.assignment.controller.dialog.EllipseDialogClient;
import uk.ac.cranfield.java.assignment.controller.dialog.RectangleDialogClient;
import uk.ac.cranfield.java.assignment.view.DrawPanel;
import uk.ac.cranfield.java.assignment.view.dialog.CircleDisplayDialog;
import uk.ac.cranfield.java.assignment.view.dialog.EllipseDisplayDialog;
import uk.ac.cranfield.java.assignment.view.dialog.RectangleDisplayDialog;


public class DisplayMenu extends JMenu
{
    
    private static String rectangleTitle = "Rectangle";
    private static String ellipseTitle = "Ellipse";
    private static String circleTitle = "Circle";
    
    private RectangleDialogClient rectangleClient;
    private RectangleDisplayDialog rectangleDialog;
    
    private EllipseDialogClient ellipseClient;
    private EllipseDisplayDialog ellipseDialog;
    
    private CircleDialogClient circleClient;
    private CircleDisplayDialog circleDialog;
    
    public DisplayMenu(Frame parent, DrawPanel drawPanel)
    {
        super("Display");
        
        rectangleClient = new RectangleDialogClient(drawPanel);
        rectangleDialog = new RectangleDisplayDialog(parent, rectangleTitle, rectangleClient, drawPanel);
        add(new ShapeMenuAction(parent, rectangleTitle, rectangleDialog));
        
        ellipseClient = new EllipseDialogClient(drawPanel);
        ellipseDialog = new EllipseDisplayDialog(parent, ellipseTitle, ellipseClient, drawPanel);
        add(new ShapeMenuAction(parent, ellipseTitle, ellipseDialog));
        
        circleClient = new CircleDialogClient(drawPanel);
        circleDialog = new CircleDisplayDialog(parent, circleTitle, circleClient, drawPanel);
        add(new ShapeMenuAction(parent, circleTitle, circleDialog));
    }
    
    
}

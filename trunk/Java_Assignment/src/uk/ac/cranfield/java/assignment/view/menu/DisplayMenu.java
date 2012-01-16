package uk.ac.cranfield.java.assignment.view.menu;

import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JMenu;

import uk.ac.cranfield.java.assignment.controller.action.menu.ShapeMenuAction;
import uk.ac.cranfield.java.assignment.controller.dialog.CircleDialogClient;
import uk.ac.cranfield.java.assignment.controller.dialog.EllipseDialogClient;
import uk.ac.cranfield.java.assignment.controller.dialog.RectangleDialogClient;
import uk.ac.cranfield.java.assignment.view.dialog.CircleDisplayDialog;
import uk.ac.cranfield.java.assignment.view.dialog.EllipseDisplayDialog;
import uk.ac.cranfield.java.assignment.view.dialog.RectangleDisplayDialog;
import uk.ac.cranfield.java.assignment.view.panel.DrawPanel;

/**
 * This class represents menu for displayable shapes.
 * Extends {@link JMenu}.
 * @author Mateusz Golab
 * @version 1.0
 * @see JMenu
 */
@SuppressWarnings("serial")
public class DisplayMenu extends JMenu
{
    
    /**
     * The title for rectangle item
     */
    private static String rectangleTitle = "Rectangle";
    
    /**
     * The title for ellipse item
     */
    private static String ellipseTitle = "Ellipse";
    
    /**
     * The title for circle item
     */
    private static String circleTitle = "Circle";
    
    /**
     * Instance of the rectangle client.
     */
    private RectangleDialogClient rectangleClient;
    
    /**
     * Instance of the rectangle dialog
     */
    private RectangleDisplayDialog rectangleDialog;
    
    /**
     * Instance of the ellipse client
     */
    private EllipseDialogClient ellipseClient;
    
    /**
     * Instance of the ellipse dialog
     */
    private EllipseDisplayDialog ellipseDialog;
    
    /**
     * Instance of the circle client
     */
    private CircleDialogClient circleClient;
    
    /**
     * Instance of the circle dialog
     */
    private CircleDisplayDialog circleDialog;
    
    /**
     * The constructor creates new display menu containing menu items for every shape
     * @param parent parent frame
     * @param drawPanel drawing panel
     */
    public DisplayMenu(Frame parent, DrawPanel drawPanel)
    {
        super("Display");
        
        rectangleClient = new RectangleDialogClient(drawPanel);
        rectangleDialog = new RectangleDisplayDialog(parent, rectangleTitle, rectangleClient);
        add(new ShapeMenuAction(parent, rectangleTitle, new ImageIcon("icons/rectangle.png"), rectangleDialog));
        
        ellipseClient = new EllipseDialogClient(drawPanel);
        ellipseDialog = new EllipseDisplayDialog(parent, ellipseTitle, ellipseClient);
        add(new ShapeMenuAction(parent, ellipseTitle, new ImageIcon("icons/ellipse.png"), ellipseDialog));
        
        circleClient = new CircleDialogClient(drawPanel);
        circleDialog = new CircleDisplayDialog(parent, circleTitle, circleClient);
        add(new ShapeMenuAction(parent, circleTitle, new ImageIcon("icons/circle.png"), circleDialog));
    }
    
}

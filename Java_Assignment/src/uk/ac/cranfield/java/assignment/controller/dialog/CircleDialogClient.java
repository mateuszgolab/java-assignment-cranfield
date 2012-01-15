package uk.ac.cranfield.java.assignment.controller.dialog;

import java.awt.Dialog;

import uk.ac.cranfield.java.assignment.controller.CircleController;
import uk.ac.cranfield.java.assignment.controller.interfaces.DialogClient;
import uk.ac.cranfield.java.assignment.controller.utils.RandomColorGenerator;
import uk.ac.cranfield.java.assignment.controller.utils.RandomNumbersGenerator;
import uk.ac.cranfield.java.assignment.model.info.CircleDialogInfo;
import uk.ac.cranfield.java.assignment.model.shape.Circle;
import uk.ac.cranfield.java.assignment.view.CircleView;
import uk.ac.cranfield.java.assignment.view.panel.DrawPanel;

/**
 * The class implements {@link DialogClient} interface.
 * Receives notification from the dialog after it has been dismissed.
 * Class responsible for generating Circles from information received from dialog.
 * @author Mateusz Golab
 * @version 1.0
 * @see DialogClient
 */
public class CircleDialogClient implements DialogClient
{
    
    /**
     * Table of Circles to be created.
     */
    private Circle[] circles;
    
    /**
     * Instance of circle information object .
     */
    private CircleDialogInfo info;
    
    /**
     * Instance of drawing panel.
     */
    private DrawPanel drawPanel;
    
    /**
     * The constructor initialises Circles table and drawing panel.
     * @param panel instance of drawing panel
     */
    public CircleDialogClient(DrawPanel panel)
    {
        this.drawPanel = panel;
        circles = new Circle[0];
    }
    
    /**
     * Implementation of DialogClient method.
     * Creates new Circles with random values from the range based on received information.
     * Sets new controller for drawing panel containing Ellipses table.
     */
    @Override
    public void dialogDismissed(Dialog d, Object arg)
    {
        info = (CircleDialogInfo) arg;
        circles = new Circle[info.getNumberOfObjects()];
        
        for (int i = 0; i < circles.length; i++)
        {
            double radius = RandomNumbersGenerator.getRandomDouble(info.getMinRadius(), info.getMaxRadius());
            int x = RandomNumbersGenerator.getRandomInt((int) (drawPanel.getWidth() - radius));
            int y = RandomNumbersGenerator.getRandomInt((int) (drawPanel.getHeight() - radius));
            
            circles[i] = new Circle(radius, x, y, RandomColorGenerator.getRandomColor());
        }
        
        drawPanel.setControllerAndSort(new CircleController(circles, new CircleView()));
        
    }
    
    
}

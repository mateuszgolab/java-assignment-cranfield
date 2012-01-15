package uk.ac.cranfield.java.assignment.controller.dialog;

import java.awt.Dialog;

import uk.ac.cranfield.java.assignment.controller.RectangleController;
import uk.ac.cranfield.java.assignment.controller.interfaces.DialogClient;
import uk.ac.cranfield.java.assignment.controller.utils.RandomColorGenerator;
import uk.ac.cranfield.java.assignment.controller.utils.RandomNumbersGenerator;
import uk.ac.cranfield.java.assignment.model.info.RectangleDialogInfo;
import uk.ac.cranfield.java.assignment.model.shape.Rectangle;
import uk.ac.cranfield.java.assignment.view.RectangleView;
import uk.ac.cranfield.java.assignment.view.panel.DrawPanel;

/**
 * The class implements {@link DialogClient} interface.
 * Receives notification from the dialog after it has been dismissed.
 * Class responsible for generating Rectangles from information received from dialog.
 * @author Mateusz Golab
 * @version 1.0
 * @see DialogClient
 */
public class RectangleDialogClient implements DialogClient
{
    
    /**
     * Table of Rectangles to be created.
     */
    private Rectangle[] rectangles;
    
    /**
     * Instance of rectangle information object .
     */
    private RectangleDialogInfo info;
    
    /**
     * Instance of drawing panel.
     */
    private DrawPanel drawPanel;
    
    /**
     * The constructor initialises Rectangles table and drawing panel.
     * @param panel instance of drawing panel
     */
    public RectangleDialogClient(DrawPanel panel)
    {
        this.drawPanel = panel;
        rectangles = new Rectangle[0];
    }
    
    /**
     * Implementation of DialogClient method.
     * Creates new Rectangles with random values from the range based on received information.
     * Sets new controller for drawing panel containing Rectangles table.
     */
    @Override
    public void dialogDismissed(Dialog d, Object arg)
    {
        info = (RectangleDialogInfo) arg;
        rectangles = new Rectangle[info.getNumberOfObjects()];
        
        for (int i = 0; i < rectangles.length; i++)
        {
            double width = RandomNumbersGenerator.getRandomDouble(info.getMinWidth(), info.getMaxWidth());
            double length = RandomNumbersGenerator.getRandomDouble(info.getMinLength(), info.getMaxLength());
            int x = RandomNumbersGenerator.getRandomInt((int) (drawPanel.getWidth() - width));
            int y = RandomNumbersGenerator.getRandomInt((int) (drawPanel.getHeight() - length));
            
            rectangles[i] = new Rectangle(width, length, x, y, RandomColorGenerator.getRandomColor());
        }
        
        drawPanel.setControllerAndSort(new RectangleController(rectangles, new RectangleView()));
        
    }
    
}

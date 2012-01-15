package uk.ac.cranfield.java.assignment.controller.dialog;

import java.awt.Dialog;

import uk.ac.cranfield.java.assignment.controller.EllipseController;
import uk.ac.cranfield.java.assignment.controller.interfaces.DialogClient;
import uk.ac.cranfield.java.assignment.controller.utils.RandomColorGenerator;
import uk.ac.cranfield.java.assignment.controller.utils.RandomNumbersGenerator;
import uk.ac.cranfield.java.assignment.model.info.EllipseDialogInfo;
import uk.ac.cranfield.java.assignment.model.shape.Ellipse;
import uk.ac.cranfield.java.assignment.view.EllipseView;
import uk.ac.cranfield.java.assignment.view.panel.DrawPanel;

/**
 * The class implements {@link DialogClient} interface.
 * Receives notification from the dialog after it has been dismissed.
 * Class responsible for generating Ellipses from information received from dialog.
 * @author Mateusz Golab
 * @version 1.0
 * @see DialogClient
 */
public class EllipseDialogClient implements DialogClient
{
    
    /**
     * Table of Ellipses to be created.
     */
    private Ellipse[] ellipses;
    
    /**
     * Instance of ellipse information object .
     */
    private EllipseDialogInfo info;
    
    /**
     * Instance of drawing panel.
     */
    private DrawPanel drawPanel;
    
    /**
     * The constructor initialises Ellipses table and drawing panel.
     * @param panel instance of drawing panel
     */
    public EllipseDialogClient(DrawPanel panel)
    {
        this.drawPanel = panel;
        ellipses = new Ellipse[0];
    }
    
    /**
     * Implementation of DialogClient method.
     * Creates new Ellipses with random values from the range based on received information.
     * Sets new controller for drawing panel containing Ellipses table.
     */
    @Override
    public void dialogDismissed(Dialog d, Object arg)
    {
        info = (EllipseDialogInfo) arg;
        ellipses = new Ellipse[info.getNumberOfObjects()];
        
        for (int i = 0; i < ellipses.length; i++)
        {
            double minorRadius = RandomNumbersGenerator.getRandomDouble(info.getMinMinorRadius(),
                    info.getMaxMinorRadius());
            double majorRadius = RandomNumbersGenerator.getRandomDouble(info.getMinMajorRadius(),
                    info.getMaxMajorRadius());
            int x = RandomNumbersGenerator.getRandomInt((int) (drawPanel.getWidth() - majorRadius));
            int y = RandomNumbersGenerator.getRandomInt((int) (drawPanel.getHeight() - majorRadius));
            
            ellipses[i] = new Ellipse(minorRadius, majorRadius, x, y, RandomColorGenerator.getRandomColor());
        }
        
        drawPanel.setControllerAndSort(new EllipseController(ellipses, new EllipseView()));
        
    }
    
}

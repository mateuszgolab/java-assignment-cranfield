package uk.ac.cranfield.java.assignment.controller.dialog;

import java.awt.Dialog;

import uk.ac.cranfield.java.assignment.controller.draw.EllipseDrawer;
import uk.ac.cranfield.java.assignment.controller.utils.RandomColorGenerator;
import uk.ac.cranfield.java.assignment.controller.utils.RandomNumbersGenerator;
import uk.ac.cranfield.java.assignment.model.info.EllipseDialogInfo;
import uk.ac.cranfield.java.assignment.model.shape.Ellipse;
import uk.ac.cranfield.java.assignment.view.DrawPanel;


public class EllipseDialogClient implements DialogClient
{
    
    private Ellipse[] ellipses;
    private EllipseDialogInfo info;
    private DrawPanel drawPanel;
    
    public EllipseDialogClient(DrawPanel panel)
    {
        this.drawPanel = panel;
        ellipses = new Ellipse[0];
    }
    
    @Override
    public void dialogDimissed(Dialog d, Object arg)
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
        
        drawPanel.setDrawer(new EllipseDrawer(ellipses));
        
    }
    
}

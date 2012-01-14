package uk.ac.cranfield.java.assignment.controller.dialog;

import java.awt.Dialog;

import uk.ac.cranfield.java.assignment.controller.draw.CircleDrawer;
import uk.ac.cranfield.java.assignment.controller.utils.RandomColorGenerator;
import uk.ac.cranfield.java.assignment.controller.utils.RandomNumbersGenerator;
import uk.ac.cranfield.java.assignment.model.info.CircleDialogInfo;
import uk.ac.cranfield.java.assignment.model.shape.Circle;
import uk.ac.cranfield.java.assignment.view.DrawPanel;


public class CircleDialogClient implements DialogClient
{
    
    private Circle[] circles;
    private CircleDialogInfo info;
    private DrawPanel drawPanel;
    
    public CircleDialogClient(DrawPanel panel)
    {
        this.drawPanel = panel;
        circles = new Circle[0];
    }
    
    @Override
    public void dialogDimissed(Dialog d, Object arg)
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
        
        drawPanel.setDrawer(new CircleDrawer(circles));
        
    }
    
    
}

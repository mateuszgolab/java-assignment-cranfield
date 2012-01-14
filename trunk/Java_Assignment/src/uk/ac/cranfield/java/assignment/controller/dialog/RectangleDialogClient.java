package uk.ac.cranfield.java.assignment.controller.dialog;

import java.awt.Dialog;

import uk.ac.cranfield.java.assignment.controller.draw.RectangleDrawer;
import uk.ac.cranfield.java.assignment.controller.utils.RandomColorGenerator;
import uk.ac.cranfield.java.assignment.controller.utils.RandomNumbersGenerator;
import uk.ac.cranfield.java.assignment.model.info.RectangleDialogInfo;
import uk.ac.cranfield.java.assignment.model.shape.Rectangle;
import uk.ac.cranfield.java.assignment.view.DrawPanel;


public class RectangleDialogClient implements DialogClient
{
    
    private Rectangle[] rectangles;
    private RectangleDialogInfo info;
    private DrawPanel drawPanel;
    
    public RectangleDialogClient(DrawPanel panel)
    {
        this.drawPanel = panel;
        rectangles = new Rectangle[0];
    }
    
    @Override
    public void dialogDimissed(Dialog d, Object arg)
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
        
        drawPanel.setDrawer(new RectangleDrawer(rectangles));
        
    }
    
}

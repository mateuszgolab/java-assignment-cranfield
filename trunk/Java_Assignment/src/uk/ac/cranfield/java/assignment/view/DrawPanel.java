package uk.ac.cranfield.java.assignment.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import uk.ac.cranfield.java.assignment.controller.ShapeDrawer;
import uk.ac.cranfield.java.assignment.controller.SortingDelayWorker;


public class DrawPanel extends JPanel
{
    
    private static long SORT_DELAY_TIME = 2000;
    private ShapeDrawer drawer;
    
    public DrawPanel()
    {
        setBackground(Color.WHITE);
    }
    
    public void setDrawer(ShapeDrawer drawer)
    {
        this.drawer = drawer;
        new SortingDelayWorker(drawer, this, SORT_DELAY_TIME).execute();
    }
    
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        if (drawer != null)
            drawer.draw(g);
    }
}

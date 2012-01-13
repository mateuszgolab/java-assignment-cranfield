package uk.ac.cranfield.java.assignment.view;

import javax.swing.JFrame;

import uk.ac.cranfield.java.assignment.controller.utils.FrameToolkit;
import uk.ac.cranfield.java.assignment.view.menu.MainMenu;


public class MainFrame extends JFrame
{
    
    public static FrameToolkit frameToolkit = new FrameToolkit();
    private MainMenu menu;
    private DrawPanel panel;
    
    public MainFrame()
    {
        setTitle("Application");
        setSize(frameToolkit.getSize());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new DrawPanel();
        add(panel);
        setVisible(true);
        
        menu = new MainMenu(this, panel);
        setJMenuBar(menu);
        
        
    }
    
}

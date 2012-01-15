package uk.ac.cranfield.java.assignment.view.menu;

import javax.swing.JMenuBar;

import uk.ac.cranfield.java.assignment.view.DrawPanel;
import uk.ac.cranfield.java.assignment.view.MainFrame;


@SuppressWarnings("serial")
public class MainMenu extends JMenuBar
{
    
    private FileMenu fileMenu;
    private DisplayMenu displayMenu;
    private MainFrame parent;
    private DrawPanel drawPanel;
    
    public MainMenu(MainFrame parent, DrawPanel drawPanel)
    {
        this.parent = parent;
        this.drawPanel = drawPanel;
        create();
        init();
        
        
    }
    
    private void create()
    {
        fileMenu = new FileMenu(parent, drawPanel);
        displayMenu = new DisplayMenu(parent, drawPanel);
    }
    
    private void init()
    {
        add(fileMenu);
        add(displayMenu);
    }
    
}

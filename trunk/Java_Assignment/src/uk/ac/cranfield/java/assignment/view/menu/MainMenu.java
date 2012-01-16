package uk.ac.cranfield.java.assignment.view.menu;

import javax.swing.JMenuBar;

import uk.ac.cranfield.java.assignment.view.frame.MainFrame;
import uk.ac.cranfield.java.assignment.view.panel.DrawPanel;

/**
 * This class represents main menu bar of the application
 * Extends {@link JMenuBar}.
 * @author Mateusz Golab
 * @version 1.0
 * @see JMenuBar
 */
@SuppressWarnings("serial")
public class MainMenu extends JMenuBar
{
    
    /**
     * Instance of file menu
     */
    private FileMenu fileMenu;
    
    /**
     * Instance of display menu
     */
    private DisplayMenu displayMenu;
    
    /**
     * Instance of the application's main frame
     */
    private MainFrame parent;
    
    /**
     * Instance of panel to draw on.
     */
    private DrawPanel drawPanel;
    
    /**
     * The constructor creates main menu bar containing file and display menus.
     * @param parent parent frame
     * @param drawPanel drawing panel
     */
    public MainMenu(MainFrame parent, DrawPanel drawPanel)
    {
        this.parent = parent;
        this.drawPanel = drawPanel;
        create();
        init();
    }
    
    /**
     * This method creates file menus
     */
    private void create()
    {
        fileMenu = new FileMenu(parent, drawPanel);
        displayMenu = new DisplayMenu(parent, drawPanel);
    }
    
    /**
     * This method adds menus to the menu bar.
     */
    private void init()
    {
        add(fileMenu);
        add(displayMenu);
    }
    
}

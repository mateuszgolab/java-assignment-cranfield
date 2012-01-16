package uk.ac.cranfield.java.assignment.view.frame;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

import javax.swing.JFrame;

import uk.ac.cranfield.java.assignment.controller.utils.FrameToolkit;
import uk.ac.cranfield.java.assignment.view.menu.MainMenu;
import uk.ac.cranfield.java.assignment.view.panel.DrawPanel;

/**
 * This class represents the main window of the application.
 * Extends {@link JFrame} and implements {@link WindowListener}.
 * @author Mateusz Golab
 * @version 1.0
 * @see JFrame, WindowListener
 */
@SuppressWarnings("serial")
public class MainFrame extends JFrame implements WindowStateListener
{
    
    /**
     * The instance of the menu bar.
     */
    private MainMenu menu;
    
    /**
     * The instance of the main drawing panel.
     */
    private DrawPanel panel;
    
    /**
     * The constructor creates new main window of the application.
     * Initializes drawing panel and main menu bar.
     * Adds window state listener.
     */
    public MainFrame()
    {
        setTitle("Java Assignment  author : Mateusz Golab");
        setIconImage(FrameToolkit.getImage("icons/shapes-icon.png"));
        setSize(FrameToolkit.getSize());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new DrawPanel();
        add(panel);
        setVisible(true);
        
        menu = new MainMenu(this, panel);
        setJMenuBar(menu);
        
        addWindowStateListener(this);
        
    }
    
    /**
     * This method implements WindowStateListener method.
     * Centralises shape location when window is maximized or changed size.
     */
    @Override
    public void windowStateChanged(WindowEvent evt)
    {
        int oldState = evt.getOldState();
        int newState = evt.getNewState();
        
        if ((oldState == JFrame.NORMAL && newState == JFrame.MAXIMIZED_BOTH)
                || (oldState == JFrame.MAXIMIZED_BOTH && newState == JFrame.NORMAL))
        {
            panel.centralise(new Dimension(getSize().width / 2, getSize().height / 2));
        }
        
    }
    
    
}

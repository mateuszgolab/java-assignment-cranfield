package uk.ac.cranfield.java.assignment;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import uk.ac.cranfield.java.assignment.view.MainFrame;


public class Main {
    
    public static void main(String[] args) throws Exception {
        // Set look and feel
        SwingUtilities.invokeAndWait(new Runnable() {
            
            @Override
            public void run() {
                
                try {
                    
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (Exception e) {
                    
                }
            }
        });
        
        new MainFrame();

    }

}

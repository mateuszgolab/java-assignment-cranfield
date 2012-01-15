package uk.ac.cranfield.java.assignment;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import uk.ac.cranfield.java.assignment.view.frame.MainFrame;


public class Main
{
    
    
    public static void main(String[] args) throws Exception
    {
        
        SwingUtilities.invokeAndWait(new Runnable()
        {
            
            @Override
            public void run()
            {
                try
                {
                    
                    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
                    {
                        if ("Nimbus".equals(info.getName()))
                        {
                            UIManager.setLookAndFeel(info.getClassName());
                            return;
                        }
                    }
                    
                    
                    JOptionPane
                            .showMessageDialog(
                                    null,
                                    "Please update your Java environment to 1.6 version update 10 or higher, to get better visual effect of the application",
                                    "Java update recommended", JOptionPane.INFORMATION_MESSAGE);
                }
                catch (Exception e)
                {
                    JOptionPane.showMessageDialog(null, "Java Look and feel problem occured", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    
                }
                finally
                {
                    new MainFrame();
                }
            }
        });
        
        
    }
    
}

package uk.ac.cranfield.java.assignment.model.dialog.info;

import java.awt.Dimension;


public class RectangleDialogInfo extends DialogInfo {

    private Dimension minDimension;
    private Dimension maxDimension;
    
    public RectangleDialogInfo() {
        super();
        minDimension = new Dimension();
        maxDimension = new Dimension();
    }
    
    /**
     * @return the minDimension
     */
    public final Dimension getMinDimension() {
        return minDimension;
    }
    
    
    /**
     * @param minDimension the minDimension to set
     */
    public final void setMinDimension(Dimension minDimension) {
        this.minDimension = minDimension;
    }
    
    
    /**
     * @return the maxDimension
     */
    public final Dimension getMaxDimension() {
        return maxDimension;
    }
    
    
    /**
     * @param maxDimension the maxDimension to set
     */
    public final void setMaxDimension(Dimension maxDimension) {
        this.maxDimension = maxDimension;
    }
    
}

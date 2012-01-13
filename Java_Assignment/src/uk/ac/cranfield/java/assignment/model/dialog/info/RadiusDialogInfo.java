package uk.ac.cranfield.java.assignment.model.dialog.info;


public class RadiusDialogInfo extends DialogInfo {
    
    private Integer minRadius;
    private Integer maxRadius;
    
    public RadiusDialogInfo(Integer n, Integer minRadius, Integer maxRadius) {
        super();
        this.minRadius = minRadius;
        this.maxRadius = maxRadius;
    }
    
    
    /**
     * @return the minRadius
     */
    public final Integer getMinRadius() {
        return minRadius;
    }
    
    
    /**
     * @param minRadius the minRadius to set
     */
    public final void setMinRadius(Integer minRadius) {
        this.minRadius = minRadius;
    }
    
    
    /**
     * @return the maxRadius
     */
    public final Integer getMaxRadius() {
        return maxRadius;
    }
    
    
    /**
     * @param maxRadius the maxRadius to set
     */
    public final void setMaxRadius(Integer maxRadius) {
        this.maxRadius = maxRadius;
    }
    
}

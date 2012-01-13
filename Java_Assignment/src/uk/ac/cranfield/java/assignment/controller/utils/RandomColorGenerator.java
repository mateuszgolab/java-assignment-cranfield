package uk.ac.cranfield.java.assignment.controller.utils;

import java.awt.Color;


public class RandomColorGenerator
{
    
    protected static Color colors[] = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN,
            Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.YELLOW};
    
    public static Color getRandomColor()
    {
        return colors[RandomNumbersGenerator.getRandomInt(colors.length)];
    }
    
    
}

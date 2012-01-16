package uk.ac.cranfield.java.assignment.controller.utils;

import java.awt.Color;

/**
 * This class provides random Colors.
 * Uses {@link RandomNumbersGenerator}.
 * @author Mateusz Golab
 * @version 1.0
 */
public class RandomColorGenerator
{
    
    /**
     * Creates random Color object.
     * @return random Color object.
     */
    public static Color getRandomColor()
    {
        return new Color(RandomNumbersGenerator.getRandomInt(255), RandomNumbersGenerator.getRandomInt(255),
                RandomNumbersGenerator.getRandomInt(255));
    }
    
}

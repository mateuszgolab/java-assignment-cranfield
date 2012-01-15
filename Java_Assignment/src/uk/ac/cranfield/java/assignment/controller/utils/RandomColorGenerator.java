package uk.ac.cranfield.java.assignment.controller.utils;

import java.awt.Color;


public class RandomColorGenerator
{
    
    public static Color getRandomColor()
    {
        return new Color(RandomNumbersGenerator.getRandomInt(255), RandomNumbersGenerator.getRandomInt(255),
                RandomNumbersGenerator.getRandomInt(255));
    }
    
}

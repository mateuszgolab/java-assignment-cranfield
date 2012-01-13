package uk.ac.cranfield.java.assignment.controller.utils;

import java.util.Random;


public class RandomNumbersGenerator
{
    
    private static Random random;
    
    static
    {
        random = new Random(System.currentTimeMillis());
    }
    
    public static Integer getRandomInt(Integer max)
    {
        return random.nextInt(max);
    }
    
    public static Double getRandomDouble(int min, int max)
    {
        return min + random.nextDouble() * (max - min);
    }
    
}

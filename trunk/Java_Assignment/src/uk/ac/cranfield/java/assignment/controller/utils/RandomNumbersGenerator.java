package uk.ac.cranfield.java.assignment.controller.utils;

import java.util.Random;

/**
 * This class represents pseudorandom numbers generator.
 * It is capable of generating Double and Integer numbers.
 * @author Mateusz Golab
 * @version 1.0
 */
public class RandomNumbersGenerator
{
    
    /**
     * Instance of pseudorandom numbers stream generator.
     */
    private static Random random;
    
    /**
     * initialization of random numbers generator
     */
    static
    {
        random = new Random(System.currentTimeMillis());
    }
    
    /**
     * Returns pseudorandom Integer number between 0 and max
     * @param max the bound of the random integer to be returned
     * @return pseudorandom Integer
     */
    public static Integer getRandomInt(Integer max)
    {
        return random.nextInt(max);
    }
    
    /**
     * Returns pseudorandom Double number between min and max Integers
     * @param max the higher bound of the random integer to be returned
     * @param min the lower bound of the random integer to be returned
     * @return pseudorandom Double.
     */
    public static Double getRandomDouble(Integer min, Integer max)
    {
        return min + random.nextDouble() * (max - min);
    }
    
}

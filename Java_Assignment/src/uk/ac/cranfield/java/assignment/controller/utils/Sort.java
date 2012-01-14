package uk.ac.cranfield.java.assignment.controller.utils;


/**
 * The class Sort provides sorting classic algorithms. Relies on the interface {@link Sortable} to compare different
 * elements.
 * @author
 * @version 1.0
 * @see Sortable
 */
public class Sort
{
    
    /**
     * Shell sorting algorithm.
     * @param a
     * static array of Sortable elements. The array is modified so
     * that elements are sorted in a big-to-little way.
     * Mistake fixed "tmp.compare(a[j - incr]) < 0" instead of
     * "tmp.compare(a[j] - incr) < 0"
     */
    public static void shell_sort(Sortable[] a)
    {
        int n = a.length;
        int incr = n / 2;
        
        while (incr >= 1)
        {
            
            for (int i = incr; i < n; i++)
            {
                Sortable tmp = a[i];
                int j = i;
                while (j >= incr && tmp.compare(a[j - incr]) < 0)
                {
                    a[j] = a[j - incr];
                    j -= incr;
                }
                a[j] = tmp;
            }
            
            incr /= 2;
        }
    }
    
    /**
     * Bubble sorting algorithm.
     * @param a
     * static array of Sortable elements. The array is modified so
     * that elements are sorted in a big-to-little way.
     */
    public static void bubble_sort(Sortable[] a)
    {
        for (int i = 1; i < a.length; i++)
        {
            for (int j = 0; j < a.length - 1; j++)
            {
                if (a[j].compare(a[j + 1]) > 0)
                {
                    Sortable hold = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = hold;
                }
            }
        }
    }
}

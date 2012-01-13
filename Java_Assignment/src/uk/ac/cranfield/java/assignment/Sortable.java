package uk.ac.cranfield.java.assignment;

/**
 * The interface Sortable is the root of the hierarchy of things that can be
 * sorted. This interface should be implemented by any class that could be
 * compared to any other one.
 * 
 * @author 
 * @version 1.0
 */
public interface Sortable {
	/**
	 * It allows sorting elements.
	 * 
	 * @param b
	 *            The other element to be compared with.
	 * @return Returns 0 if the elements are equal, 1 if this is bigger or -1 if
	 *         it is smaller.
	 */
	public int compare(Sortable b);
}

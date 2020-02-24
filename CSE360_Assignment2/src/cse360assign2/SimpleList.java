/** @author Isaiah Boblett 161 
 * Assignment 1
 * The file contains methods to construct a new list, add to that list,
 * remove a certain element from the list, count the number of elements
 * currently in the list, return the list as a string, and to search
 * for an element in the list.
 */

package cse360assign2;

public class SimpleList {
	/**
	 * These attributes store the values in the list, and the count
	 * of the elements in the list.
	 */
	private int[] list;
	private int count;
	
	/**
	 * The SimpleList constructor creates a new list with 10 elements,
	 * and initializes the attribute count to 0.
	 */
	public SimpleList() {
		list = new int[10];
		count = 0;
	}
	
	/**
	 * The void method add, increments count then inserts an integer into the
	 * beginning of the array, before it inserts the integer into the array
	 * though, it must push all other array entries down the array to make room
	 * for the new value.
	 * 
	 * @param newInteger	the integer to be added to the array.
	 */
	public void add(int newInteger) {
		int temp = 0;
		if(count < list.length) {
			count++;
		}
		else {
			int[] tempArray = list;
			list = new int[list.length + (list.length / 2)];
			for(int index = 0; index < list.length; index++) {
				list[index] = tempArray[index];
			}
			count++;
		}
		for(int index = 0; index < list.length; index++) {
			temp = list[index];
			list[index] = newInteger;
			newInteger = temp;
			}
		
		
	}
	
	/**
	 * The remove method goes through the list and checks whether the element
	 * at the index is the same as the number we want to remove, if it is we
	 * shift every element after it to the left once, as well as decrement
	 * count.
	 * 
	 * @param	integerToBeRemoved	the integer we want to remove from the array.
	 */
	public void remove(int integerToBeRemoved) {
		int indexToRemove = search(integerToBeRemoved);
		
		if(count < (list.length / 4)) {
			int[] tempArray = list;
			list = new int[list.length + (list.length / 2)];
			for(int index = 0; index < list.length; index++) {
				list[index] = tempArray[index];
			}
		}
		if(indexToRemove != -1) {
			count--;
			for(int index = indexToRemove + 1; index < list.length; index++) {
				list[index - 1] = list[index];		
			}
			list[list.length-1] = 0;
		}
	}
			
	
	/**
	 * The count method simply returns the count attribute that we have been
	 * incrementing and decrementing during our add and remove methods.
	 * 
	 * @return the current count of the elements in the array
	 */
	public int count() {
		return count;
	}
	
	/**
	 * the toString method goes through the list adding the integer value to 
	 * the string as well as a space between the two, up until the second
	 * to last element, then we return the string + the last element so that we
	 * don't have an extra space at the end.
	 * 
	 * @return	the array as a string including the last element currently in the array.
	 */
	public String toString() {
		int index = 0;
		String returnString = "";
		while(index < count - 1) {
			returnString += list[index] + " ";
			index++;
		}
		return returnString += list[index];
	}
	
	/**
	 * The search method parses through the array looking for the specified
	 * parameter value Wanted, if the value is found in the array then the
	 * value searchReturn is set to the index of the value and firstInstance
	 * is set to false so that if there is another instance of the variable
	 * in the array, it only returns the first instance and not the second one.
	 * If the array does not contain the value we want then we return -1.
	 * 
	 * @param	valueWanted	the integer we want to find in the array.
	 * @return		the integer at the specified index, if it exists.
	 */
	public int search(int valueWanted) {
		int searchReturn = 0;
		boolean firstInstance = true;
		for(int index = 0; index < list.length; index++) {
			if(list[index] == valueWanted && firstInstance == true) {
				searchReturn = index;
				firstInstance = false;
			}
		}
		if(searchReturn == 0 && firstInstance == true) {
			searchReturn = -1;
		}
		return searchReturn;
	}
	
	public void append(int parameter) {
		if(count >= list.length) {
			int[] tempArray = list;
			list = new int[list.length + (list.length / 2)];
			for(int index = 0; index < list.length; index++) {
				list[index] = tempArray[index];
			}
		}
		else {
			list[count] = parameter;
			count++;
		}
	}
	
	public int first() {		
		return list[0];
	}
	
	public int size() {
		int size = 0;
		return size;
	}
}

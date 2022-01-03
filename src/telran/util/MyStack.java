package telran.util;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * 
 * all specified below methods should be written with complexity O[1]
 *
 */
public class MyStack {

	private LinkedList<Integer> list = new LinkedList<>();
	private LinkedList<Integer> listMaxValues = new LinkedList<>();

	/**listMaxValues
	 * adds the given element at the and of stack
	 * 
	 * @param elment
	 */
	void push(Integer elment) {
		list.add(elment);
		/* V.R. It is possible to do the same a little bit shorter 
		if (listMaxValues.isEmpty() || element >= maxElements.getLast()) {
			listMaxValues.add(element);
		}
		 * 
		 */
		if (listMaxValues.isEmpty()) {
			listMaxValues.add(elment);
		} else {
			if (elment >= listMaxValues.getLast()) {
				listMaxValues.add(elment);
			}
		}
	}
	/*
	 * removes the last element and returns it if the stack is empty an exception
	 * "NoSuchElementExceptinon" should be thrown
	 */
	Integer pop() {
		if (list.isEmpty()) {
			throw new NoSuchElementException();
		}
		Integer delElement = list.removeLast();
		if (delElement.equals(listMaxValues.getLast())) {
			listMaxValues.removeLast();
		}
		return delElement;
	}
	/**
	 * @return true is the stack is empty
	 */
	boolean isEmpty() {
		return list.isEmpty();
	}
	/**
	 * 
	 * @return max element existing in the stack
	 */
	Integer max() {
		if (list.isEmpty()) {
			throw new NoSuchElementException();
		}
		return listMaxValues.getLast();
	}
}

package stacklearning;

import java.util.EmptyStackException;

public class MyStack<T> {
	private StackNode<T> top;
	
	private static class StackNode<T> {
		private T data;
		private StackNode<T> next; // next is a slightly misleading name. It's more like the previous element in stack.
		
		public StackNode(T data) {
			this.data = data;
		}
	}
	
	public T pop() {
		if (top == null)
			throw new EmptyStackException();
		
		T item = top.data;
		top = top.next;
		return item;
	}
	
	public void push(T item) {
		StackNode<T> newItem = new StackNode<>(item);
		newItem.next = top;
		top = newItem;
	}
	
	public T peek() {
		if (top == null)
			throw new EmptyStackException();
		
		return top.data;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	
}

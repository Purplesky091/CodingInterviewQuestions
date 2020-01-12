package stacklearning;

import java.util.EmptyStackException;

public class RayStack<T> {
	private static class StackNode<T> {
		T data;
		StackNode<T> prev;
		
		public StackNode(T data) {
			this.data = data;
		}
	}
	
	StackNode<T> top;
	
	public T pop() {
		if(top == null)
			throw new EmptyStackException();
		
		T item = top.data;
		top = top.prev;
		return item;
	}
	
	public T peek() {
		if (top == null)
			throw new EmptyStackException();
		
		return top.data;
	}
	
	public void push(T data) {
		StackNode<T> newTop = new StackNode<>(data);
		newTop.prev = top;
		top = newTop;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
}

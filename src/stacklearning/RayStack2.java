package stacklearning;

import java.util.EmptyStackException;

public class RayStack2<T> {
	private static class StackNode<T> {
		T data;
		StackNode<T> prev;
		
		public StackNode(T data) {
			this.data = data;
		}
	}
	
	StackNode<T> top;
	
	// push()
	public void push(T data) {
		StackNode<T> newNode = new StackNode<>(data);
		newNode.prev = top;
		top = newNode;
	}
	
	// pop()
	public T pop() {
		if(top == null)
			throw new EmptyStackException();
		
		T item = top.data;
		top = top.prev;
		return item;
	}

	// peek()
	public T peek() {
		if(top == null)
			throw new EmptyStackException();
		
		return top.data;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
}

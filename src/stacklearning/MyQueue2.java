package stacklearning;

import java.util.NoSuchElementException;

public class MyQueue2<T> {
	
	private static class QueueNode<T> {
		T data;
		QueueNode<T> next;
		
		public QueueNode(T data) {
			this.data = data;
		}
	}
	
	QueueNode<T> head, tail;
	
	public void add(T data) {
		QueueNode<T> newNode = new QueueNode<>(data);
		if(head == null) {
			head = tail = newNode;
			return;
		}
		
		tail.next = newNode;
		tail = newNode;
	}
	
	public T remove() {
		if (head == null)
			throw new NoSuchElementException();
		
		T item = head.data;
		head = head.next;
		if(head == null)
			tail = null;
		
		return item;
	}
	
	public T peek() {
		if(head == null)
			throw new NoSuchElementException();
		
		return tail.data;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
}

package stacklearning;

import java.util.NoSuchElementException;

public class MyQueue<T> {
	private static class QueueNode<T>{
		T data;
		QueueNode<T> next;
		
		public QueueNode(T data) {
			this.data = data;
		}
	}
	
	private QueueNode<T> first;
	private QueueNode<T> last;
	
	public void add(T data) {
		QueueNode<T> newData = new QueueNode<>(data);
		if(last != null)
			last.next = newData;
		
		last = newData;
		if(first == null)
			first = last;
	}
	
	public T remove() {
		if(first == null)
			throw new NoSuchElementException();
		
		T returnData = first.data;
		first = first.next;
		if(first == null)
			last = null;
		
		return returnData;
	}
	
	public T peek() {
		if(first == null)
			throw new NoSuchElementException();
		
		return first.data;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
}

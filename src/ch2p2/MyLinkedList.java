package ch2p2;

public class MyLinkedList {
	private int size;
	Node head;
	
	public MyLinkedList(int data) {
		head = new Node(data);
	}
	
	public void add(int data) {
		Node newNode = new Node(data);
		Node walker = head;
		
		while(walker.next != null) {
			walker = walker.next;
		}
		
		walker.next = newNode;
		size++;
	}
	
	public int getKthElementFromLast(int k){
		if (k > size)
			return -1;
		
		int numOfJumps = size - k;
		Node walker = head;
		for(int i = 0; i < numOfJumps; i++) {
			walker = walker.next;
		}
		
		return walker.data;
	}
	
	@Override
	public String toString() {
		String result = "[";
		Node n = head;
		while(n != null) {
			if(n.next == null)
				result += n.data;
			else
				result += n.data + " -> ";
			n = n.next;
		}
			
		result += "]";
		return result;
	}
	
	private class Node {
		int data;
		Node next;
	
		public Node(int d) {
			data = d;
		}
	}
}	
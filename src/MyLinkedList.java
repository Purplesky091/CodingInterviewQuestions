import java.util.HashSet;

public class MyLinkedList {
	private LinkedListNode head;
	
	public MyLinkedList(int data) {
		head = new LinkedListNode(data, null, null);
	}
	
	public void add(int data) {
		LinkedListNode n = head;
		
		while(n.next != null) {
			n = n.next;
		} // walk till we get to tail.
		
		LinkedListNode newNode = new LinkedListNode(data, null, null);
		n.next = newNode;
		newNode.prev = n;
	}
	
	private void deleteDups(LinkedListNode n) {
		HashSet<Integer> seenData = new HashSet<>();
		LinkedListNode previous = null;
		
		while(n != null) {
			if(seenData.contains(n.data))
				previous.next = n.next;
			else {
				seenData.add(n.data);
				previous = n;
			}
			
			n = n.next;
		}	
	}
	
	public void deleteDuplicates() {
		deleteDups(head);
	}
	
	public void deleteDuplicates2() {
		deleteDuplicates2(head);
	}
	
	private void deleteDuplicates2(LinkedListNode n) {
		LinkedListNode current = n;
		
		while(current != null) {
			LinkedListNode runner = current;
			while(runner.next != null) {
				if(runner.next.data == current.data)
					runner.next = runner.next.next;
				else
					runner = runner.next;
			}
			
			current = current.next;
		}
	}
	
	
	
	@Override
	public String toString() {
		String result = "[";
		LinkedListNode n = head;
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
	
}
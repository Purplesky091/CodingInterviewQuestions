
public class LinkedListNode {
	public LinkedListNode next, prev, last;
	public int data;
	
	public LinkedListNode(int d, LinkedListNode n, LinkedListNode p) {
		data = d;
		setNext(n);
		setPrevious(p);
	}
	
	public void setNext(LinkedListNode n) {
		next = n;
		if(this == last)
			last = n;
		
		// if what we want to add isn't blank and
		// the node's previous element should be the current node. 
		// If its previous pointer to the current node.
		if(n != null && n.prev != this)
			n.setPrevious(this);
	}
	
	public void setPrevious(LinkedListNode p) {
		prev = p;
		if (p != null && p.next != this)
			p.setNext(this);
	}
	
	public LinkedListNode clone() {
		LinkedListNode next2 = null;
		if (next != null)
			next2 = next.clone();
		
		LinkedListNode head2 = new LinkedListNode(data, next2, null);
		return head2;
	}
}

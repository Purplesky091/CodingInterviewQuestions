package ch2p2;

public class Main {
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList(0);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		System.out.println(list);
		System.out.println(list.getKthElementFromLast(6));
		
	}
}

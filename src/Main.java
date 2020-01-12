import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
	
	public void deleteDuplicates(LinkedList<Integer> list) {
		ListIterator listIterator = list.listIterator();
		HashSet<Integer> seenElements = new HashSet<>();
		
		while(listIterator.hasNext()) {
			Integer element = (Integer) listIterator.next();
			if(seenElements.contains(element))
				listIterator.remove();
			else
				seenElements.add(element);
		}
	}
	
	
	public static void main(String[] args) {
		Main main = new Main();
		/*
		LinkedList<Integer> numList = new LinkedList<>();
		numList.add(1);
		numList.add(3);
		numList.add(4);
		numList.add(6);
		numList.add(4);
		numList.add(5);
		numList.add(3);
		
		System.out.println(numList);
		main.deleteDuplicates(numList);
		System.out.println(numList);
		*/
		
		MyLinkedList list = new MyLinkedList(9);
		list.add(3);
		list.add(4);
		list.add(6);
		list.add(5);
		list.add(5);
		list.add(3);
		System.out.println(list);
		list.deleteDuplicates2();
		System.out.println(list);
	}

}

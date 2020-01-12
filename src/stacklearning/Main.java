package stacklearning;

public class Main {
	public static void main(String[] args) {
		RayStack2<Integer> stack = new RayStack2<>();
		stack.push(10);
		stack.push(9);
		stack.push(8);
		stack.push(7);
		stack.push(6);
		stack.push(5);
		stack.push(4);
		
		while(!stack.isEmpty())
			System.out.print(stack.pop());
		System.out.println();
		
		MyQueue2<String> okiLine = new MyQueue2<>();
		okiLine.add("Ray");
		okiLine.add("Joanne");
		okiLine.add("Daniel");
		okiLine.add("Mom");
		okiLine.add("Dad");
		
		System.out.println("Order of the line goes as follows");
		while(!okiLine.isEmpty())
			System.out.println(okiLine.remove());
	}
}

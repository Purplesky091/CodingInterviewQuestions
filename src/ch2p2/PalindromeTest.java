package ch2p2;

import java.util.Stack;

public class PalindromeTest {
	
	 // Definition for singly-linked list.
	 public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	 }
	 
	 public boolean isPalindrome(ListNode head) {
	        if(head == null || head.next == null)
	            return true;
	        
	        int size = getSize(head);
	        ListNode midPtr = head;
	        ListNode fastPtr = head;
	        Stack<Integer> stack = new Stack<>();
	        
	        while(fastPtr != null) {
	            fastPtr = fastPtr.next;
	            if(fastPtr == null)
	                continue;
	            else
	                fastPtr = fastPtr.next;
	            
	            midPtr = midPtr.next;
	        }
	        
	        ListNode frontPtr = head;
	        
	        if(size % 2 == 1 || size == 2) {
	        	while(frontPtr != midPtr) {
	                stack.push(frontPtr.val);
	                frontPtr = frontPtr.next;
	            }
	        }     
	        else {
	        	while (frontPtr != midPtr) {
	                stack.push(frontPtr.val);
	                frontPtr = frontPtr.next;
	            } 
	        }
	        
	        if(size == 2) {
	        	return midPtr.val == stack.pop();
	        }
	        else if (size % 2 == 1){
	        	midPtr = midPtr.next;
	        }	
	        
        	while(midPtr != null) {
	            if (stack.pop() != midPtr.val)
	                return false;
	            else
	                midPtr = midPtr.next;
	        }
	        
	        
	            
	        return true;
	        
	    }
	    
	    private int getSize(ListNode n) {
	        int count = 0;
	        while(n != null) {
	            count++;
	            n = n.next;
	        }
	        
	        return count;
	            
	    }
	    
	    public static void main(String[] args) {
	    	PalindromeTest pt = new PalindromeTest();
	    	ListNode node1 = new ListNode(1);
	    	ListNode node2 = new ListNode(2);
	    	ListNode node3 = new ListNode(2);
	    	ListNode node4 = new ListNode(1);
	    	
	    	node1.next = node2;
	    	node2.next = node3;
	    	node3.next = node4;
	    	
	    	System.out.println(pt.isPalindrome(node1));
	    }
}

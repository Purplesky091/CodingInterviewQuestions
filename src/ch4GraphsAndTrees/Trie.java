package ch4GraphsAndTrees;

public class Trie {
	private static class TrieNode {
		TrieNode[] arr;
		boolean isLeaf;
		
		public TrieNode() {
			arr = new TrieNode[26];
		}
		
	}
	
	private TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
	
	// inserts a word into the trie
	public void insert(String word) {
		TrieNode p = root;
		
		for(int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			int index = letter - 'a';
			
			if(p.arr[index] == null) {
				TrieNode temp = new TrieNode();
				p.arr[index] = temp;
				p = temp; // move the current trienode to the newly inserted trie node.
			} else {
				p = p.arr[index];
			}
			
			if (i == word.length() - 1)
				p.isLeaf = true;
		}
	}
	
	public boolean search(String word) {
		TrieNode node = searchNode(word);
		
		return node != null && node.isLeaf;
	}
	
	public boolean searchPrefix(String prefix) {
		return searchNode(prefix) != null;
	}
	
	public TrieNode searchNode(String str) {
		TrieNode p = root;
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			int index = c - 'a';
			if(p.arr[index] != null)
				p = p.arr[index];
			else
				return null;
		}
		
		if(p == root)
			return null;
		
		return p;
		
	}
	
}

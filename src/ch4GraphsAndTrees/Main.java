package ch4GraphsAndTrees;

public class Main {
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("pingas");
		trie.insert("dumb");
		trie.insert("dude");
		trie.insert("dung");
		
		System.out.println("Trie contains dung: " + trie.search("dung"));
		System.out.println("Trie contains pingas: " + trie.search("pingas"));
		System.out.println("Trie has words starting with du: " + trie.searchPrefix("du"));
		System.out.println("Trie contains words starting with sf: " + trie.searchPrefix("sf"));
	}
}

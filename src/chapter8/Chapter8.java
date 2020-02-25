package chapter8;

public class Chapter8 {
    public void ex1(){
        Trie trie = new Trie();
        trie.insert("dog");
        trie.insert("deer");
        trie.insert("deal");

        System.out.println(trie.autocomplete("de"));
    }

    public void ex2() {
        PrefixMapSum trie = new PrefixMapSum();
        trie.insert("bag", 4);
        trie.insert("bath", 5);

        System.out.println(trie.sum("ba"));
    }

}

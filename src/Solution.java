public class Solution {
    public static void main(String[] args){
        TrieDS wordList = new TrieDS();
        wordList.insert("preempt");
        wordList.insert("landing");
        wordList.insert("chopper");
        System.out.println(wordList.searchWord("pre"));
        System.out.println(wordList.searchWord("landing"));
        System.out.println(wordList.searchWord("chopper"));

        System.out.println(wordList.prefixSearch("pre"));
        System.out.println(wordList.prefixSearch("land"));
        System.out.println(wordList.prefixSearch("choppers"));
    }
}

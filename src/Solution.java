public class Solution {
    public static void main(String[] args){
        TrieDS wordList = new TrieDS();
        wordList.insert("abc");
        wordList.insert("abgl");
        wordList.insert("xyz");
        System.out.println(wordList.searchWord("abc"));
        System.out.println(wordList.searchWord("xyzz"));
        System.out.println(wordList.searchWord("abgl"));
    }
}

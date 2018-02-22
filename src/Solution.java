import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public class Solution {
    public static void main(String[] args){
        TrieDS wordList = new TrieDS();
        wordList.insert("preempt");
        wordList.insert("landing");
        wordList.insert("chopper");
        wordList.insert("chopping");
        wordList.insert("chip");
        System.out.println(wordList.searchWord("pre"));
        System.out.println(wordList.searchWord("landing"));
        System.out.println(wordList.searchWord("chopper"));

        System.out.println(wordList.prefixSearch("pre"));
        System.out.println(wordList.prefixSearch("land"));
        System.out.println(wordList.prefixSearch("choppers"));

        List<String> temp = wordList.getPrefixWords("ch");
        for(String s:temp)
            System.out.println(s);
    }
}

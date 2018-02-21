import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrieDS {

    //Definition of a Node in Trie data structure
    private class TrieNode{
        HashMap<Character,TrieNode> hash;
        boolean isWordEnd;
        public TrieNode(){
            hash = new HashMap<Character, TrieNode>();
            isWordEnd = false;
        }
    }

    //Declaration of root of Trie data structure
    public final TrieNode root;
    public TrieDS(){
        root = new TrieNode();
    }

    //function to insert a word in Trie data structure. Time-Complexity: O(length of word)
    public boolean insert(String word){
        try{
            if(word.isEmpty()){
                return false;
            }
            char[] wordArray = word.toCharArray();
            insertHelper(wordArray,0,root);
            return true;
        }
        catch (Exception e){
            Logger.getAnonymousLogger().log(Level.SEVERE,"Insertion Failed");
            return false;
        }
    }

    // Recursive helper function to insert a word.
    private void insertHelper(char[] wordArray, int idx, TrieNode node){
        if(idx == wordArray.length){
            node.isWordEnd = true;
            return;
        }
        if(node.hash.containsKey(wordArray[idx])){
            insertHelper(wordArray,idx+1,node.hash.get(wordArray[idx]));
        }
        else{
            TrieNode tempNode = new TrieNode();
            node.hash.put(wordArray[idx],tempNode);
            insertHelper(wordArray,idx+1,node.hash.get(wordArray[idx]));
        }
    }

    // Function to search for a complete word in Trie data structure. Time-Complexity: O(length of word)
    public boolean searchWord(String word){
        if(word.isEmpty()){
            return false;
        }
        char[] wordArray = word.toCharArray();
        boolean isSuccess = swHelper(wordArray,0,root);
        return isSuccess;
    }

    // Recursive helper function to search for a word.
    private boolean swHelper(char[] wordArray, int idx, TrieNode node){
        if(idx == wordArray.length && node.isWordEnd){
            return true;
        }

        if(idx == wordArray.length)
            return false;

        boolean res;
        if(node.hash.containsKey(wordArray[idx])){
            res = swHelper(wordArray,idx+1,node.hash.get(wordArray[idx]));
        }
        else
            res = false;

        return res;
    }

    // Function to search for a word prefix in Trie data structure. Time-Complexity: O(length of word)
    public boolean prefixSearch(String word){
        if(word.isEmpty()){
            return false;
        }
        char[] wordArray = word.toCharArray();
        boolean isSuccess = prefixHelper(wordArray,0,root);
        return isSuccess;
    }

    // Recursive helper function to search for a word prefix.
    private boolean prefixHelper(char[] wordArray, int idx, TrieNode node){
        if(idx == wordArray.length){
            return true;
        }

        boolean res;
        if(node.hash.containsKey(wordArray[idx])){
            res = prefixHelper(wordArray,idx+1,node.hash.get(wordArray[idx]));
        }
        else
            res = false;

        return res;
    }

    
}

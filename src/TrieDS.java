import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrieDS {
    private class TrieNode{
        HashMap<Character,TrieNode> hash;
        boolean isWordEnd;
        public TrieNode(){
            hash = new HashMap<Character, TrieNode>();
            isWordEnd = false;
        }
    }

    public final TrieNode root;
    public TrieDS(){
        root = new TrieNode();
    }

    public boolean insert(String word){
        try{
            char[] wordArray = word.toCharArray();
            insertHelper(wordArray,0,root);
            return true;
        }
        catch (Exception e){
            Logger.getAnonymousLogger().log(Level.SEVERE,"Insertion Failed");
            return false;
        }
    }

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

    public boolean searchWord(String word){
        char[] wordArray = word.toCharArray();
        boolean isSuccess = swHelper(wordArray,0,root);
        return isSuccess;
    }

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

}

class Trie {
    class TrieNode{
        TrieNode ch[];
        boolean ends;
        TrieNode(){
            ch=new TrieNode[26];
            ends=false;
        }
    }
    TrieNode root;
    public Trie() {
        root=new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode temp=root;
        for(char c: word.toCharArray()){
            if(temp.ch[c-'a']==null){
                temp.ch[c-'a']=new TrieNode();
            }
            temp=temp.ch[c-'a'];
        }
        temp.ends=true;
    }
    
    public boolean search(String word) {
        TrieNode temp=root;
        for(char c: word.toCharArray()){
            if(temp.ch[c-'a']==null){
                return false;
            }
            temp=temp.ch[c-'a'];
            
        }
        return temp.ends;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode temp=root;
        for(char c: prefix.toCharArray()){
            if(temp.ch[c-'a']==null){
                return false;
            }
            else{
                temp=temp.ch[c-'a'];
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
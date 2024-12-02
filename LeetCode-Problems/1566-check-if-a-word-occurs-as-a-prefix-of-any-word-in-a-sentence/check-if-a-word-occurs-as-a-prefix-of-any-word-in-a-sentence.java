class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] str=sentence.split(" ");
        int l=searchWord.length();
        for(int i=0;i<str.length;i++){
            if(str[i].length()>=l){
                if(str[i].substring(0,l).equals(searchWord)) return i+1;
            }
        }
        return -1;
    }
}
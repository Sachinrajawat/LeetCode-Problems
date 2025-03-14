class Solution {
    public int countPalindromicSubsequence(String s) {
        int n=s.length();
        int res=0;
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(s.charAt(i));
        }
        for(char ch:set){
            int left=-1,right=-1;
            for(int i=0;i<n;i++){
                if(s.charAt(i)==ch){
                    if(left==-1) left=i;
                    right=i;
                }
            }
            HashSet<Character> uni=new HashSet<>();
            for(int mid=left+1;mid<right;mid++){
                uni.add(s.charAt(mid));
            }
            res+=uni.size();
        }
        return res;
    }
}
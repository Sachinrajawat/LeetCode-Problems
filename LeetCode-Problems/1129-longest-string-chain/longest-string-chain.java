class Solution {
    public boolean isPossible(String s1,String s2){
        if(s1.length()!=s2.length()+1) return false;
        int c=0,i=0,j=0;
        while(i<s1.length() && j<s2.length()){
            if(s1.charAt(i)!=s2.charAt(j)){
                c++;
                i++;
            }
            else{
                i++;
                j++;
            }
            if(c>1) return false;
        }
        return true;
    }
   
    public int longestStrChain(String[] words) {
        Arrays.sort(words,  Comparator.comparingInt(String::length));
        int[] dp=new int[words.length];
        Arrays.fill(dp,1);
        int maxLen=1;
        for(int i=0;i<words.length;i++){
            for(int j=0;j<i;j++){
                if(isPossible(words[i],words[j])){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            maxLen=Math.max(dp[i],maxLen);
        }
        return maxLen;
    }
}
class Solution {
    public int maxFreqSum(String s) {
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            arr[ch-'a']++;
        }
        int cons=0, vow=0;
        for(int i=0;i<26;i++){
            if(i!=0 && i!=4 && i!=8 && i!=14 && i!=20) cons=Math.max(cons,arr[i]);
            else vow=Math.max(vow,arr[i]);
        }
        return cons+vow;
    }
}
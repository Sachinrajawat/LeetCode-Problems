class Solution {
    public int beautySum(String s) {
        int sum=0, n=s.length();
        for(int i=0;i<n;i++){
            for(int j=i+2;j<n;j++){
                String str=s.substring(i,j+1);
                int[] freq=new int[26];
                int max=0, min=500;
                for(int k=0;k<str.length();k++){
                    char ch=str.charAt(k);
                    freq[ch-'a']++;
                }
                for(int fre:freq){
                    max=Math.max(max, fre);
                    if(fre>0) min=Math.min(min, fre);
                }
                // System.out.println(str+" "+ max+" "+ min);
                sum+=max-min;
                // System.out.println(sum);
            }
        }
        return sum;
    }
}
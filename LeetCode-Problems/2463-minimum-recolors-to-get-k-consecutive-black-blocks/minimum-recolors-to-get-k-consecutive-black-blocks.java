class Solution {
    public int minimumRecolors(String blocks, int k) {
        int[] count=new int[blocks.length()];
        int w=0,b=0;
        for(int i=0;i<blocks.length();i++){
            if(blocks.charAt(i)=='W'){
                count[i]=w+1;
                w++;
            }
            else{
                count[i]=w;
            }
        }
        int ans=count[k-1];
        for(int i=k;i<blocks.length();i++){
            ans=Math.min(ans,count[i]-count[i-k]);
        }
        return ans;
    }
}
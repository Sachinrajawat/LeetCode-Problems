class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        if(n==1) return 0;
        int min=Integer.MAX_VALUE, ans=0;
        for(int i=0;i<n;i++){
            min=Math.min(min,prices[i]);
            ans=Math.max(ans,prices[i]-min);
        }
        return ans;
    }
}
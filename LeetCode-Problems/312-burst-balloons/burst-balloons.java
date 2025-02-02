class Solution {
     public int solve(List<Integer> arr, int l, int r,int[][] dp) {
        if(l>r) return 0; 
        if(dp[l][r]!=-1) return dp[l][r];
        int maxCoins=0;
        for (int i=l;i<=r;i++) {
            int coins=arr.get(l - 1)*arr.get(i)*arr.get(r+1)
                +solve(arr,l,i-1,dp) 
                +solve(arr,i+1,r,dp);
            
            maxCoins=Math.max(maxCoins,coins);
        }

        return dp[l][r]=maxCoins;
    }

    public int maxCoins(int[] nums) {
        List<Integer> arr=new ArrayList<>();
        arr.add(1); 
        for (int num:nums) arr.add(num);
        arr.add(1);
        int[][] dp=new int[arr.size()][arr.size()];
        for(int i=0;i<arr.size();i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(arr,1,nums.length,dp);
    }
}
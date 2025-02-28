class Solution {
    public int solve1(int j,int k, int[] arr, HashMap<Integer, Integer> map,int[][] dp){
        if(dp[j][k]!=-1) return dp[j][k];
        int target=arr[k]-arr[j];
        if(map.containsKey(target) && map.get(target)<j){
            int i=map.get(target);
            return dp[j][k]=solve1(i,j,arr,map,dp)+1;
        }
        return dp[j][k]=2;
    }
    public int lenLongestFibSubseq(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        int res=0;
        int[][] dp=new int[arr.length][arr.length];
        for(int i=0;i<arr.length;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int j=1;j<arr.length-1;j++){
            for(int k=j+1;k<arr.length;k++){
                int len=solve1(j,k,arr,map,dp);
                if(len>=3){
                    res=Math.max(res,len);
                }
            }
        }
        return res;
    }
}
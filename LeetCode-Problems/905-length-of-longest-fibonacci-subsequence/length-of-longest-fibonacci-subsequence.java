class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        int res=0;
        int[][] dp=new int[arr.length][arr.length];
        for(int i=0;i<arr.length;i++){
            Arrays.fill(dp[i],2);
        }
        for(int j=1;j<arr.length-1;j++){
            for(int k=j+1;k<arr.length;k++){
                int target=arr[k]-arr[j];
                if(map.containsKey(target) && map.get(target)<j){
                    int i=map.get(target);
                    dp[j][k]=dp[i][j]+1;
                }
                res=Math.max(res,dp[j][k]);
            }
        }
        return res>=3?res:0;
    }
}
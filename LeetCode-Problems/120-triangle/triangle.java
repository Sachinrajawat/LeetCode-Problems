class Solution {
    public int solve(List<List<Integer>> triangle, int idx, int row, int[][] dp){
        if(row==triangle.size()-1) return triangle.get(row).get(idx);
        if(dp[idx][row]!=Integer.MAX_VALUE) return dp[idx][row];
        int first=triangle.get(row).get(idx)+solve(triangle, idx, row+1,dp);
        int sec=triangle.get(row).get(idx)+solve(triangle, idx+1, row+1,dp);
        return dp[idx][row]=Math.min(first, sec);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int row=triangle.size();
        int col=triangle.get(row-1).size();
        int[][] dp=new int[row][col];
        for(int[] d:dp){
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        return solve(triangle, 0,0, dp);
    }
}
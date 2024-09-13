class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n=queries.length;
        int[] ans=new int[n];
        
        int[] prefixXor=new int[arr.length+1];
        prefixXor[1]=arr[0];

        for(int i=2;i<=arr.length;i++) prefixXor[i]=prefixXor[i-1]^arr[i-1];

        for(int i=0;i<n;i++) ans[i]=prefixXor[queries[i][0]]^prefixXor[queries[i][1]+1];
        
        return ans;
    }
}
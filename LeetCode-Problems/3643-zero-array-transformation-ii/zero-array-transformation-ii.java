class Solution {
    public boolean solve(int[] nums,int[][] queries, int k){
        int[] diff=new int[nums.length+1];
        for(int i=0;i<k;i++){
             int st=queries[i][0], end=queries[i][1], val=queries[i][2];
             diff[st]+=val;
              if (end+1<diff.length) {
                diff[end+1]-=val;
            }
        }
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=diff[i];
            if(sum<nums[i]) return false;
        }
        return true;
    }
    public int minZeroArray(int[] nums, int[][] queries) {
        int st=0,end=queries.length+1;
        while(st<end){
            int mid=st+(end-st)/2;
            if(solve(nums,queries,mid)){
                end=mid;
            }
            else st=mid+1;
        }
        return (st== queries.length + 1) ? -1 : st;
    }
}
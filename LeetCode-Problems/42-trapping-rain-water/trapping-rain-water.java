class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] left=new int[n];
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,height[i]);
            left[i]=max;
        }
        max=0;
        int ans=0;
        for(int i=n-1;i>=0;i--){
            max=Math.max(max,height[i]);
            ans+=Math.min(left[i],max)-height[i];
        }
        return ans;
    }
}
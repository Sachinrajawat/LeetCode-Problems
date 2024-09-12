class Solution {
    public long findMaximumScore(List<Integer> nums) {
        long ans = 0;
        int mx = nums.get(0);
        for(int i=1;i<nums.size();i++) {
            ans+=mx;
            mx=Math.max(mx,nums.get(i));
        }
        return ans;
    }
}
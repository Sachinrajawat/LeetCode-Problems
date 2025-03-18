class Solution {
    public int longestNiceSubarray(int[] nums) {
        int ans = 0, l = 0;
        int sum = 0;

        for (int r = 0; r < nums.length; r++) {
            while ((sum & nums[r]) != 0) {
                sum ^= nums[l];
                l++;
            }

            sum |= nums[r];
            ans = Math.max(ans, r - l + 1);
        }
        
        return ans;
    }
}

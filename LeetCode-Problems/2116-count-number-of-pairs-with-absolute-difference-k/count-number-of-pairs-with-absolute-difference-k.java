class Solution {
    public int countKDifference(int[] nums, int k) {
        var n = nums.length;
        var ans = 0;

        var counts = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            if (counts.containsKey(nums[i] - k)) {
                ans += counts.get(nums[i] - k);
            }
            if (counts.containsKey(k + nums[i])) {
                ans += counts.get(k + nums[i]);
            }
            counts.put(nums[i], counts.getOrDefault(nums[i], 0) + 1);
        }

    return ans;
    }
}
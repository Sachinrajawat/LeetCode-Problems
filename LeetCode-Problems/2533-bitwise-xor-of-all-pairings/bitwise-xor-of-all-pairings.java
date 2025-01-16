class Solution {
    private int xor(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    public int xorAllNums(int[] nums1, int[] nums2) {
        if (nums1.length % 2 == 0 && nums2.length % 2 == 0) { // if both arrays have even length
            return 0;
        }
        int xorone = xor(nums1), xortwo = xor(nums2);
        // if both arrays have odd length then xor of both arrays is the answer or else
        // xor of one even length array is the answer
        return nums1.length % 2 == 1 && nums2.length % 2 == 1 ? xorone ^ xortwo
                : (nums1.length % 2 != 0 ? xortwo : xorone);
    }
}
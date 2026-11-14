class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if ((long) n < (long) m * k) return -1;

        int st = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            st = Math.min(st, day);
            end = Math.max(end, day);
        }

        int ans = -1;
        while (st <= end) {
            int mid = st + (end - st) / 2;

            if (canMake(bloomDay, mid, m, k)) {
                ans = mid;
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return ans;
    }

    private boolean canMake(int[] bloomDay, int mid, int m, int k) {
        int count = 0;
        int flowers = 0;

        for (int day : bloomDay) {
            if (day <= mid) {
                flowers++;
                if (flowers == k) {
                    count++;
                    if (count == m) return true; // Early exit once m bouquets are made
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        return false;
    }
}
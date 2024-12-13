import java.util.*;

class Solution {
    public int solve(ArrayList<Integer> sq, int n, int idx, int[][] dp) {
        if (n == 0) return 0; // Base case: If n is 0, no more squares are needed.
        if (idx < 0 || n < 0) return Integer.MAX_VALUE; // If index is out of bounds or n becomes negative, return a large value.
        if (dp[n][idx] != -1) return dp[n][idx]; // Return memoized result if available.

        // Recursive cases:
        // Option 1: Include the current square
        int include = solve(sq, n - sq.get(idx), idx, dp);
        if (include != Integer.MAX_VALUE) include += 1; // Add 1 to the result if we include the square.

        // Option 2: Skip the current square
        int exclude = solve(sq, n, idx - 1, dp);

        // Store the result in the dp table and return the minimum
        dp[n][idx] = Math.min(include, exclude);
        return dp[n][idx];
    }

    public int numSquares(int n) {
        ArrayList<Integer> sq = new ArrayList<>();
        int i = 1;
        while (i * i <= n) { // Generate all perfect squares <= n.
            sq.add(i * i);
            i++;
        }

        int[][] dp = new int[n + 1][sq.size()]; // DP table to store intermediate results.
        for (int[] row : dp) Arrays.fill(row, -1); // Initialize DP table with -1.

        return solve(sq, n, sq.size() - 1, dp); // Call the helper function with all squares.
    }
}

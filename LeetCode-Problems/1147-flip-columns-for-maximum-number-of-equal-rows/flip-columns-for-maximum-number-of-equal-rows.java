class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> patternCount = new HashMap<>();
        int m = matrix.length, n = matrix[0].length;

        for (int[] row : matrix) {
            StringBuilder pattern = new StringBuilder();
            StringBuilder complement = new StringBuilder();
            for (int cell : row) {
                pattern.append(cell);
                complement.append(1 - cell);
            }
            
            String patternStr = pattern.toString();
            String complementStr = complement.toString();
            patternCount.put(patternStr, patternCount.getOrDefault(patternStr, 0) + 1);
            patternCount.put(complementStr, patternCount.getOrDefault(complementStr, 0)+1);
        }

        int maxRows = 0;
        for (int count : patternCount.values()) {
            maxRows = Math.max(maxRows, count);
        }

        return maxRows;
    }
}

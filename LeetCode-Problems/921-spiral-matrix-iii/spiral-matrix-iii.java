class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[rows * cols][2];
        int index = 0;
        result[index++] = new int[]{rStart, cStart};

        int step = 1; // Initial step size
        int direction = 0; // Direction: 0 -> right, 1 -> down, 2 -> left, 3 -> up
        int r = rStart, c = cStart;

        // Direction arrays for right, down, left, up movements
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        while (index < rows * cols) {
            for (int i = 0; i < 2; i++) { // Increase the step size after every two directions
                for (int j = 0; j < step; j++) {
                    r += dr[direction];
                    c += dc[direction];
                    if (r >= 0 && r < rows && c >= 0 && c < cols) {
                        result[index++] = new int[]{r, c};
                    }
                }
                direction = (direction + 1) % 4; // Cycle through directions
            }
            step++;
        }

        return result;
    }
}
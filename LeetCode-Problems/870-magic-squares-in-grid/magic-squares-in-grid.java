class Solution {
    // public boolean isMagicSquares(int[][] grid,int row,int col){
    //     HashMap<Integer,Integer> map=new HashMap<>();
    //     for(int i=row;i<row+3;i++){
    //         for(int j=col;j<col+3;j++){
    //             if(grid[i][j]>0 && grid[i][j]<=9){
    //                 map.put(grid[i][j],map.getOrDefault(grid[i][j],0)+1);
    //             }
    //         }
    //     }
    //     if(map.size()<9) return false;
    //     for(int i=row;i<row+3;i++){
    //         int sum=0;
    //         for(int j=col;j<col+3;j++){
    //             sum+=grid[i][j];
    //         }
    //         if(sum!=15) return false;
    //     }
    //     for(int i=col;i<col+3;i++){
    //         int sum=0;
    //         for(int j=row;j<row+3;j++){
    //             sum+=grid[j][i];
    //         }
    //         if(sum!=15) return false;
    //     }
    //     if(grid[row][col]+grid[row+1][col+1]+grid[row+2][col+2]!=15) return false;
    //     if(grid[row][col+2]+grid[row+1][col+1]+grid[row+2][col]!=15) return false;
    //     return true;
    // }
    // public int numMagicSquaresInside(int[][] grid) {
        
    //     int count=0;
    //     for(int i=0;i<grid.length-2;i++){
    //         for(int j=0;j<grid[i].length-2;j++){
    //             if(isMagicSquares(grid,i,j)){
    //             count++;
    //             }
    //         }
    //     }
    //     System.out.println(count);
    //     return count;

    //gpt ans
    public boolean isMagicSquares(int[][] grid, int row, int col) {
        boolean[] seen = new boolean[10];  // Track digits 1-9
        
        int[] sums = new int[8]; // Holds sums of rows, cols, and diagonals
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = grid[row + i][col + j];
                if (num < 1 || num > 9 || seen[num]) return false;  // Invalid number or duplicate
                seen[num] = true;
                
                // Calculate row, column, and diagonal sums
                sums[i] += num;           // Row sum
                sums[3 + j] += num;       // Column sum
                if (i == j) sums[6] += num;    // Primary diagonal
                if (i + j == 2) sums[7] += num; // Secondary diagonal
            }
        }

        // Check if all sums are equal to 15
        for (int sum : sums) {
            if (sum != 15) return false;
        }

        return true;
    }

    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[i].length - 2; j++) {
                if (grid[i + 1][j + 1] == 5 && isMagicSquares(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }
}
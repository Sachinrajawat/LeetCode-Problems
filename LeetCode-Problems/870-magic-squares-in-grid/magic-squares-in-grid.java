class Solution {
    public boolean isMagicSquares(int[][] grid,int row,int col){
        if(row+3>grid.length || col+3>grid[0].length) return false;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=row;i<row+3;i++){
            for(int j=col;j<col+3;j++){
                if(grid[i][j]>0 && grid[i][j]<=9){
                    map.put(grid[i][j],map.getOrDefault(grid[i][j],0)+1);
                }
            }
        }
        if(map.size()<9) return false;
        for(int i=row;i<row+3;i++){
            int sum=0;
            for(int j=col;j<col+3;j++){
                sum+=grid[i][j];
            }
            if(sum!=15) return false;
        }
        for(int i=col;i<col+3;i++){
            int sum=0;
            for(int j=row;j<row+3;j++){
                sum+=grid[j][i];
            }
            if(sum!=15) return false;
        }
        if(grid[row][col]+grid[row+1][col+1]+grid[row+2][col+2]!=15) return false;
        if(grid[row][col+2]+grid[row+1][col+1]+grid[row+2][col]!=15) return false;
        return true;
    }
    public int numMagicSquaresInside(int[][] grid) {
        
        int count=0;
        for(int i=0;i<grid.length-2;i++){
            for(int j=0;j<grid[i].length-2;j++){
                if(isMagicSquares(grid,i,j)){
                count++;
                }
            }
        }
        System.out.println(count);
        return count;
    }
}
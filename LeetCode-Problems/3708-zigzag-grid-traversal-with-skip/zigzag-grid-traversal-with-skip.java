class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> arr=new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            if(i%2==0){
                for(int j=0;j<grid[i].length;j++){
                    if(j%2==0) arr.add(grid[i][j]);
                }
            }
            else{
                for(int j=grid[i].length-1;j>=0;j--){
                    if(j%2!=0) arr.add(grid[i][j]);
                }
            }
        }
        return arr;
    }
}
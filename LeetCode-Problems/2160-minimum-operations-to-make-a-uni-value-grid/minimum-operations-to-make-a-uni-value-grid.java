class Solution {
    public int minOperations(int[][] grid, int x) {
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                arr.add(grid[i][j]);
            }
        }
        Collections.sort(arr);
        int target=arr.get(arr.size()/2);
        int ans=0;
        for(int i=0;i<arr.size();i++){
            if(Math.abs(arr.get(i)-target)%x!=0) return -1;
            ans+=Math.abs(arr.get(i)-target)/x;
        }
        return ans;
    }
}
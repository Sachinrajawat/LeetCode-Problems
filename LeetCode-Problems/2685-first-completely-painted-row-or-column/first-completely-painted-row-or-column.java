class Solution {
    public boolean check(int[][] mat,int row,int col){
        boolean ans=true;
        for(int i=0;i<mat.length;i++){
            if(mat[i][col]!=-1){
                ans=false;
                break;
            }
        }
        if(!ans) ans=true;
        else return ans;
            for(int i=0;i<mat[0].length;i++){
                if(mat[row][i]!=-1){
                    ans=false;
                    break;
                }
            }
        return ans;
    }
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        HashMap<Integer,int[]> map=new HashMap<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                map.put(mat[i][j],new int[]{i,j});
            }
        }
        for(int i=0;i<arr.length;i++){
            int[] a=map.get(arr[i]);
            mat[a[0]][a[1]]=-1;
            System.out.println(a[0]+" "+a[1]);
            if(check(mat,a[0],a[1])) return i;
        }
        return 0;
    }
}
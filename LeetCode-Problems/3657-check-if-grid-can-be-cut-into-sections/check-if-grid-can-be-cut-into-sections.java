class Solution {
    public boolean merge(int[][] arr){
        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
        int end=arr[0][1];
        int sec=0;
        for(int[] a:arr){
            if(end<=a[0]){
                sec++;
            }
            end=Math.max(end,a[1]);
        }
        return sec>=2;
    }
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int[][] x=new int[rectangles.length][2];
        int[][] y=new int[rectangles.length][2];
        for(int i=0;i<rectangles.length;i++){
            x[i][0]=rectangles[i][0];
            x[i][1]=rectangles[i][2];
            y[i][0]=rectangles[i][1];
            y[i][1]=rectangles[i][3];
        }
        return merge(x) || merge(y);
    }
}
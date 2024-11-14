class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        // 2 11 ans 6
        // 2 5 ans 3
        // 2 2
        // 5  15 ans 10
        // 5 9 ans 7
        // 5 6 ans 5
        if(n==1 || quantities.length==1) return quantities[0];
        int start=1,end=(int)10e5;
        int ans=Integer.MAX_VALUE;
        while(start<=end){
            int mid=start+(end-start)/2;
            int count=0;
            for(int i=0;i<quantities.length;i++){
                count+=quantities[i]/mid;
                if(quantities[i]%mid!=0) count++;
                if(count>n) break;
            }
            if(count<=n){
                ans=mid;
                end=mid-1;
            }
            else start=mid+1;
        }
        return ans;
    }
}
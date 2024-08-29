class Solution {
    public int kthFactor(int n, int k) {
        if(k==1) return 1;
        if(n/2+1<k) return -1;
        int a=1;
        for(int i=2;i<=n/2;i++){
            if(n%i==0){
                a++;
                if(a==k) return i;
            }
        }
        if(a+1==k) return n;
        return -1;
    }
}
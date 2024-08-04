class Solution {
    public int numberOfSubstrings(String s) {
        int ans=0;
        int n=s.length();

        int[] pre=new int[n];
        int curr=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1') curr++;
            pre[i] =curr;
        }
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int one=pre[j];
                if(i != 0) one-= pre[i-1];

                int zero=j-i+1-one;
                if(zero *zero>one){
                    j +=(zero *zero -one -1);
                }
                else{
                    ans++;
                    int onesqrt=(int)Math.sqrt(one);
                    if(j + onesqrt -zero >=n) ans+=n-j-1;
                    else ans+=onesqrt-zero;
                    j+= (onesqrt -zero);
                }
            }
        }
        return ans;
    }
}
class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum=0,m=rolls.length;
        for(int i:rolls) sum+=i;
        int nSum=mean*(n+m)-sum;

        System.out.println(nSum);
        if(nSum>6*n || nSum<0 ||n>nSum) return new int[0];
        int[] ans=new int[n];
        for(int i = 0; i < ans.length; i++) {
            ans[i] += nSum/n;
        }
        int rem=nSum%n;
        if(rem!=0){
            int j=0;
            while(rem>0){
                if(6-ans[j]<=rem){
                    rem-=6-ans[j];
                    ans[j++]=6;
                }
                else{
                    ans[j++]+=rem;
                    rem=0;
                }
            }
        }
        // for(int i = 0; i < ans.length; i++) {
        //     System.out.print(ans[i]+" ");
        // }
        System.out.println(nSum);
        return ans;
    }
}
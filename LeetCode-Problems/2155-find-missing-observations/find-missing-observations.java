class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum=0,m=rolls.length;
        for(int i:rolls) sum+=i;
        int missSum=mean*(n+m)-sum;

        if(missSum>6*n || missSum<0 ||n>missSum) return new int[0];
        
        int[] ans=new int[n];
        int rem=missSum%n, j=0;
        for(int i=0;i<ans.length;i++){
            ans[i]+=missSum/n;
            if(rem!=0){
                if(6-ans[j]<=rem){
                    rem-=6-ans[j];
                    ans[j++]=6;
                }
                else{
                    ans[j]+=rem;
                    rem=0;
                }
            }
        }
        return ans;
    }
}
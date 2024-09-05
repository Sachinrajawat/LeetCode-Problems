class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum=0,m=rolls.length;
        for(int i:rolls) sum+=i;
        int missSum=mean*(n+m)-sum;

        if(missSum>6*n || missSum<n) return new int[0];
        
        int[] ans=new int[n];
        int rem=missSum%n;
        for(int i=0;i<ans.length;i++){
            ans[i]+=missSum/n;
            if(rem>0){
                ans[i]+=1;
                rem--;
            }
        }
        return ans;
    }
}
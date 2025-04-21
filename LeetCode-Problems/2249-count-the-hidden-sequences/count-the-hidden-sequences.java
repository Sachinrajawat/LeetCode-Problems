class Solution {
    public boolean isPossible(int[] differences,int val,int lower,int upper){
        int prev=val;
        for(int j=0;j<differences.length;j++){
                prev=differences[j]+prev;
                if(prev>upper || prev<lower) return false;;

            }
            // if(j==differences.length){
               return true;
            // }
    }
    public int numberOfArrays(int[] differences, int lower, int upper) {
        
        int min=Integer.MAX_VALUE;
        for(int i=lower;i<=upper;i++){
            if(isPossible(differences,i,lower,upper)){
                min=i;
                break;
            }
        }
        int max=Integer.MAX_VALUE;
        for(int i=upper;i>=lower;i--){
            if(isPossible(differences,i,lower,upper)){
                max=i;
                break;
            }
        }
        if(max==Integer.MAX_VALUE || min==Integer.MAX_VALUE) return 0;
        // System.out.println(max+" "+min);
        return max-min+1<=0?0:max-min+1;
    }
}
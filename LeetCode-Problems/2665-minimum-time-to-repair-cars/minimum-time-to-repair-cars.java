class Solution {
    public boolean isPossible(int[] ranks,long time, int cars){
        long c=0;
        for(int i=0;i<ranks.length;i++){
            c+=(long)Math.sqrt(time/ranks[i]);
            if(c>=cars) return true;
        }
        return c>=cars;
    }
    public long repairCars(int[] ranks, int cars) {
        Arrays.sort(ranks);
        long st=1,end=(long)ranks[ranks.length-1]*cars*cars;
        long ans=0;
        while(st<=end){
            long mid=st+(end-st)/2;
            if(isPossible(ranks,mid,cars)){
                ans=mid;
                end=mid-1;
            }
            else{
                st=mid+1;
            }
        }
        return ans;
    }
}
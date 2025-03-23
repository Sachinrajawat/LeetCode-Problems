class Solution {
    public int getLargestOutlier(int[] nums) {
        Arrays.sort(nums);
        int sum=0;
        Map<Integer,Integer> map=new HashMap<>();
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            sum+=nums[i];
        }
        int ans=nums[0];
        // System.out.println(sum);
        for(int i=nums.length-1;i>=0;i--){
            int x=nums[i];
            int s=sum-x;
            
            if(s%2==0){
                boolean isOutlier=true;
                int c=s/2;
                int freq=map.getOrDefault(c,0);
                if(c==x){
                    if(freq<=1)
                    isOutlier=false;
                }
                else{
                    if(freq<=0){
                        isOutlier=false;
                    }
                }
            if(isOutlier) return x;
            }
        }
        return ans;
    }
}
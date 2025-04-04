class Solution {
    
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        int[] hash=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            hash[i]=i;
        }
        int maxLen=1;
        int lastIdx=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && (nums[i]%nums[j]==0 || nums[j]%nums[i]==0) && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                    hash[i]=j;
                }
            }
            if(maxLen<dp[i]){
                lastIdx=i;
                maxLen=dp[i];
            }
        }
        List<Integer> arr=new ArrayList<>();
        while(hash[lastIdx]!=lastIdx){
            arr.add(nums[lastIdx]);
            lastIdx=hash[lastIdx];
        }
        arr.add(nums[lastIdx]);
        Collections.reverse(arr);
        return arr;
    }
}
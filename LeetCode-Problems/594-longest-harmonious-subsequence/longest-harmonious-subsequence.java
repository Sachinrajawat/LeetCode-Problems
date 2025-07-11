class Solution {
    public int findLHS(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int ans=0;
        for(var key:map.keySet()){
            if(map.containsKey(key+1)){
                ans=Math.max((map.get(key)+map.get(key+1)),ans);
            }
        }
        return ans;
    }
}
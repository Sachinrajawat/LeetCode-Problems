class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++) map.put(nums[i],map.getOrDefault(nums[i],0)+1);

        if(map.size()==nums.length) return 1;
        
        int deg=0;
        ArrayList<Integer> arr=new ArrayList<>();
        for(var key:map.keySet()){
            if(map.get(key)>deg){
                deg=map.get(key);
                arr=new ArrayList<>();
                arr.add(key);
            }
            else if(map.get(key)==deg) arr.add(key);
        }
        int k=0;
        int ans=Integer.MAX_VALUE;
        while(k<arr.size()){
            int start=-1,end=-1;
            for(int i=0;i<nums.length;i++){
                if(start==-1 && nums[i]==arr.get(k)) start=i;

                else if(start!=-1 && nums[i]==arr.get(k)) end=i;
            }
            ans=Math.min(ans,end-start+1);
            k++;
        }
        return ans;
    }
}
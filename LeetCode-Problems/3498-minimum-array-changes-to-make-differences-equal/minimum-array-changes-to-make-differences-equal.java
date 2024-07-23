class Solution {
    public int minChanges(int[] nums, int k) {
        
        int start=0,end=nums.length-1;
        int[] diff=new int[nums.length/2];
        HashMap<Integer,Integer> map=new HashMap<>();
        while(start<end){
            int dif=Math.abs(nums[start]-nums[end]);
            map.put(dif,map.getOrDefault(dif,0)+1);
            diff[start]=dif;
            start++;
            end--;
        }
        int min=Integer.MAX_VALUE;
        int[] maxArray=new int[3];
        for(int i=0;i<3;i++){
        int maxCount=0;
        for(var key:map.keySet()){
            if(maxCount<map.get(key)){
                maxCount=map.get(key);
                maxArray[i]=key;
            }
        }
        map.remove(maxArray[i]);
        }
        end=nums.length-1;
    for(int j=0;j<3;j++){
    int count=0,max=maxArray[j];
        for(int i=0;i<diff.length;i++){
            if(diff[i]!=max){
                if(nums[i]>=max || nums[end-i]>=max){
                    count++;
                }
                else if(nums[i]<max && nums[end-i]<max){
                    int x=Math.min(nums[i],nums[end-i]);
                    if(x+max<=k) count++;
                    else count+=2;
                }
            }
        }
        min=Math.min(min,count);
    }
        return min;
        
    }
}
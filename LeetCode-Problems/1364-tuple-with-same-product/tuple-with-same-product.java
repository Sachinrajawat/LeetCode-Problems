class Solution {
    
    public int tupleSameProduct(int[] nums) {
        int n=nums.length;
        if(n<4) return 0;
        // Arrays.sort(nums);
        int c=0;
        HashMap<Integer,Integer> map=new HashMap<>(); 
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                map.put(nums[i]*nums[j],map.getOrDefault(nums[i]*nums[j],0)+1);
            }
        }
        for(var fre:map.values()){
            if(fre>1) c+=fre*(fre-1)*4;
        }
        return c;
    }
}
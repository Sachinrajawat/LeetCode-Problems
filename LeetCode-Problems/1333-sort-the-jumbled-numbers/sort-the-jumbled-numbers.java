class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[] Nnums=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int x=nums[i];
            int num=0;
            int j=0;
            if(x!=0){while(x!=0){
                int rem=x%10;
                x/=10;
                int y=mapping[rem];
                num+=Math.pow(10,j)*y;
                j++;
            }
            Nnums[i]=num;
            }else{
                Nnums[i]=mapping[x];
            }
        }
        TreeMap<Integer,ArrayList<Integer>> t=new TreeMap<>();
        for(int i=0;i<nums.length;i++){
            if(t.containsKey(Nnums[i])){
                ArrayList<Integer> arr=t.get(Nnums[i]);
                arr.add(nums[i]);
                t.put(Nnums[i],arr);
            }else{
                ArrayList<Integer> arr=new ArrayList<>();
                arr.add(nums[i]);
                t.put(Nnums[i],arr);
            }
        }
        int k=0;
        for(var key:t.keySet()){
            ArrayList<Integer> arr=t.get(key);
            while(arr.size()!=0){
                nums[k]=arr.get(0);
                arr.remove(0);
                k++;
            }
        }
        return nums;
    }
}
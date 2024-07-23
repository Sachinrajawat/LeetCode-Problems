class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        TreeMap<Integer,ArrayList<Integer>> newMap=new TreeMap<>();
        for(var key:map.keySet()){
            if(newMap.containsKey(map.get(key))){
                ArrayList<Integer> arr=newMap.get(map.get(key));
                arr.add(key);
                newMap.put(map.get(key),arr);
            }
            else{
                ArrayList<Integer> arr=new ArrayList<>();
                arr.add(key);
                newMap.put(map.get(key),arr);
            }
        }
        int j=0;
        for(var key:newMap.keySet()){
            ArrayList<Integer> arr=newMap.get(key);
            Collections.sort(arr,Collections.reverseOrder());
            while(arr.size()!=0){
                for(int i=0;i<key;i++){
                    System.out.print(j+" "+arr.get(0)+" ");
                    nums[j++]=arr.get(0);
                }
                arr.remove(0);
            }
        }
        System.out.println(newMap);
        return nums;
    }
}
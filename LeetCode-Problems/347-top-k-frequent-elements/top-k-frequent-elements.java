class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /*
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums) map.put(i,map.getOrDefault(i,0)+1);
        TreeMap<Integer,ArrayList<Integer>> Tmap=new TreeMap<>(Collections.reverseOrder());
        for(var key:map.keySet()){
            if(!Tmap.containsKey(map.get(key))){
                ArrayList<Integer> arr=new ArrayList<>();
                arr.add(key);
                Tmap.put(map.get(key),arr);
            }
            else{
                ArrayList<Integer> arr=Tmap.get(map.get(key));
                arr.add(key);
                Tmap.put(map.get(key),arr);
            }
        }
        int[] ans=new int[k];
        int j=0;
        while(j<k){
            for(var key:Tmap.keySet()){
                ArrayList<Integer> arr=Tmap.get(key);
                for(int i=0;i<arr.size();i++){
                    ans[j++]=arr.get(i);
                    if(j==k) return ans;
                }
            }
        }
        return ans;*/
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Use a min-heap to keep track of top k elements
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue() // Min-heap based on frequency
        );

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry); // Add entry to min-heap
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the least frequent element if size exceeds k
            }
        }

        // Step 3: Collect the results from the min-heap
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll().getKey(); // Extract the keys of top k frequent elements
        }
        
        return result;
    }
}
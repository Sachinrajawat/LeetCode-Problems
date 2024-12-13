class Solution {
    public long findScore(int[] nums) {
        int n=nums.length;
        Long score=0L;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]) return Integer.compare(a[1],b[1]);
            return Integer.compare(a[0],b[0]);
        });
        for(int i=0;i<n;i++){
            pq.add(new int[]{nums[i],i});
        }
        int[] arr=new int[n];
        while(!pq.isEmpty()){
            int[] a=pq.poll();
            if(arr[a[1]]==0){
                score+=a[0];
                arr[a[1]]++;
                if(a[1]!=0) arr[a[1]-1]++;
                if(a[1]!=n-1) arr[a[1]+1]++;
            }
        }
        return score;
    }
}
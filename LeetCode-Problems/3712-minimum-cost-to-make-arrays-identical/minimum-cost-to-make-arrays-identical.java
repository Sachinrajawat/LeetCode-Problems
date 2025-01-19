class Solution {
    public long minCost(int[] arr, int[] brr, long k) {
        int n=arr.length;
        PriorityQueue<int[]> pq1 = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        PriorityQueue<int[]> pq2 = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        long extraAns=0;
        for(int i=0;i<n;i++){
            pq1.add(new int[]{arr[i],i});
            pq2.add(new int[]{brr[i],i});
            extraAns+=Math.abs(arr[i]-brr[i]);
        }
        
        
        boolean s=false;
        long ans=0;
        while(!pq1.isEmpty()  && !pq2.isEmpty()){
            int[] a=pq1.remove();
            int[] b=pq2.remove();
            // System.out.println(a[0]+" "+a[1]+"  "+b[0]+" "+b[1]);
            if(( a[1]!=b[1])){
                ans+=Math.abs(a[0]-b[0]);
                s=true;
            }
            else if(a[0]!=b[0] && a[1]==b[1] ){
                ans+=Math.abs(a[0]-b[0]);
            }
        }
        if(s) ans+=k;
        return Math.min(ans,extraAns);
    }
}
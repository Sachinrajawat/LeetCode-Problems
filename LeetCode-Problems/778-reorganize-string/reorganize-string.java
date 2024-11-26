class Solution {
    public String reorganizeString(String s) {
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->b[0]-a[0]);
        for(int i=0;i<26;i++){
            if(arr[i]>0){
                pq.add(new int[]{arr[i],i+'a'});
            }
        }
        int[] ar=pq.peek();
        String res="";
        while(pq.size()>1){
            int[] a=pq.poll();
            int[] b=pq.poll();
            res+=(char)(a[1]);
            res+=(char)(b[1]);
            a[0]--;
            b[0]--;
            if(a[0]>0) pq.add(a);
            if(b[0]>0) pq.add(b);
        }
        if(!pq.isEmpty()){
            int[] a=pq.poll();
            if(a[0]>1) return "";
            else res+=(char)a[1];
        }
        return res;
    }
}
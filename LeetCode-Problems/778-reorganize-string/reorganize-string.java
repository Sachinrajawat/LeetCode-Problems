class Solution {
    public String reorganizeString(String s) {
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->b[1]-a[1]);
        for(int i=0;i<26;i++){
            if(arr[i]>0){
                pq.add(new int[]{i+'a',arr[i]});
            }
        }
        int[] ar=pq.peek();
        System.out.println(ar[0]+" "+ar[1]);
        String res="";
        while(pq.size()>1){
            int[] a=pq.poll();
            int[] b=pq.poll();
            res+=(char)(a[0]);
            res+=(char)(b[0]);
            a[1]--;
            b[1]--;
            if(a[1]>0) pq.add(a);
            if(b[1]>0) pq.add(b);
        }
        if(!pq.isEmpty()){
            int[] a=pq.poll();
            if(a[1]>1) return "";
            else res+=(char)a[0];
        }
        return res;
    }
}
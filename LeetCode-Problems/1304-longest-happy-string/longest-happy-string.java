class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq=new PriorityQueue<>(Collections.reverseOrder(Comparator.comparingInt(arr -> arr[0])));
        if(a>0) pq.add(new int[]{a,97});
        if(b>0) pq.add(new int[]{b,98});
        if(c>0) pq.add(new int[]{c,99});
        String s="";
        while(!pq.isEmpty()){
            int[] arr=pq.poll();
            if(s.length()>=2 && s.charAt(s.length()-1)==(char)arr[1] && s.charAt(s.length()-2)==(char)arr[1]){
                if(pq.isEmpty()){
                    break;
                }
                int[] temp=pq.poll();
                s+=(char)temp[1];
                temp[0]--;
                if(temp[0]>0){
                    pq.add(temp);
                }

            }
            else{
                arr[0]--;
                s+=(char)arr[1];
            }
            if(arr[0]>0){
                pq.add(arr);
            }
        }
        return s;
    }
}
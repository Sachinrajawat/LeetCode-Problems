class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        events.sort((a, b) -> {
            int timeA = Integer.parseInt(a.get(1));
            int timeB = Integer.parseInt(b.get(1));
            
            if (timeA != timeB) return Integer.compare(timeA, timeB);
            
            return a.get(0).equals("OFFLINE") ? -1 : 1;
        });

        int[] mentions=new int[numberOfUsers];
        ArrayList<Integer> online=new ArrayList<>();
        for(int i=0;i<numberOfUsers;i++) online.add(i);
        
        int time=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<events.size();i++){
            List<String> l=events.get(i);
            time=Integer.parseInt(l.get(1));

            while (!pq.isEmpty() && pq.peek()[0] <= time) {
                int[] arr = pq.poll();
                online.add(arr[1]);
            }
            if(l.get(0).equals("MESSAGE")){
                if(l.get(2).equals("HERE")){
                    for(int j=0;j<online.size();j++){
                        mentions[online.get(j)]++;
                    }
                }
                else if(l.get(2).equals("ALL")){
                    for(int j=0;j<numberOfUsers;j++){
                        mentions[j]++;
                    }
                }
                else{
                    String[] arr=l.get(2).split(" ");
                    for(int j=0;j<arr.length;j++){
                        int k=Integer.parseInt(arr[j].substring(2));
                        mentions[k]++;
                    }
                }
            }
            else{
                int id=Integer.parseInt(l.get(2));
                int[] arr=new int[]{time+60,id};
                pq.add(arr);
                online.remove(Integer.valueOf(id));
            }
            
        }
        return mentions;
    }
}
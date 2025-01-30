class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        events.sort((a, b) -> {
            int timeA = Integer.parseInt(a.get(1));
            int timeB = Integer.parseInt(b.get(1));
            
            // If times are different, sort by time
            if (timeA != timeB) return Integer.compare(timeA, timeB);
            
            // If times are the same, give priority to "OFFLINE" over "MESSAGE"
            return a.get(0).equals("OFFLINE") ? -1 : 1;
        });
        int[] mentions=new int[numberOfUsers];
        ArrayList<Integer> online=new ArrayList<>();
        ArrayList<Integer> offline=new ArrayList<>();
        for(int i=0;i<numberOfUsers;i++){
            online.add(i);
        }
        int time=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<events.size();i++){
            List<String> l=events.get(i);
            time=Integer.parseInt(l.get(1));

            while (!pq.isEmpty() && pq.peek()[0] <= time) {
                int[] arr = pq.poll();  // Safely remove the top element
                // System.out.println(arr[0]+" "+arr[1]);
                online.add(arr[1]);
            }
            // System.out.println(l);
            if(l.get(0).equals("MESSAGE")){
                
                
                // System.out.println(online);
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
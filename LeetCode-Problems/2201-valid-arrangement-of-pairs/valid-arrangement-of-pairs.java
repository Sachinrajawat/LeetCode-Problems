class Solution {
    public int[][] validArrangement(int[][] pairs) {
        int n=pairs.length;
        HashMap<Integer,ArrayList<Integer>> adj=new HashMap<>();  // adj list
        

        HashMap<Integer, Integer> indeg=new HashMap<>();
        HashMap<Integer, Integer> outdeg=new HashMap<>();
        for(int i=0;i<n;i++){
            int p1=pairs[i][0], p2=pairs[i][1];
            adj.putIfAbsent(p1, new ArrayList<>());
            adj.get(p1).add(p2);
            outdeg.put(p1,outdeg.getOrDefault(p1,0)+1);
            indeg.put(p2,indeg.getOrDefault(p2,0)+1);
        }
        int start=-1;
        for(var key:outdeg.keySet()){
            int out=outdeg.getOrDefault(key, 0);
            int in=indeg.getOrDefault(key, 0);

            if (out-in == 1) {
                start = key;
                break;
            }

        }
        if (start==-1) {
            start = pairs[0][0];
        }
        LinkedList<int[]> result = new LinkedList<>();
        Stack<Integer> st=new Stack<>();
        st.push(start);
        while(!st.isEmpty()){
            int node=st.peek();
            if(adj.containsKey(node) && !adj.get(node).isEmpty()){
                int next= adj.get(node).remove(adj.get(node).size()-1);
                st.push(next);
            }
            else{
                if(st.size()>1){
                    result.addFirst(new int[]{st.get(st.size() - 2), st.pop()});
                }
                else{
                    st.pop();
                }
            }
        }
    return result.toArray(new int[result.size()][]);
    }
}
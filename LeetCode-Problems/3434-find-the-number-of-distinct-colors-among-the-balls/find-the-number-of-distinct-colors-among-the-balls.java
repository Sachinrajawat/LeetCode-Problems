class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int[] ans=new int[queries.length];
        HashMap<Integer,Integer> ballMap=new HashMap<>();
        HashMap<Integer,ArrayList<Integer>> colMap=new HashMap<>();
        for(int i=0;i<queries.length;i++){
            int key=queries[i][0];
            int val=queries[i][1];
            if(ballMap.containsKey(key)){
                ArrayList<Integer> array=colMap.get(ballMap.get(key));
                array.remove((Integer) key);
                if(array.size()==0) colMap.remove(ballMap.get(key));
                if(colMap.containsKey(val)){
                    ArrayList<Integer> arr=colMap.get(val);
                    arr.add(key);
                    colMap.put(val,arr);
                }
                else{
                    ArrayList<Integer> arr=new ArrayList<>();
                    arr.add(key);
                    colMap.put(val,arr);
                }
            }
            else{
                if(colMap.containsKey(val)){
                    ArrayList<Integer> arr=colMap.get(val);
                    arr.add(key);
                    colMap.put(val,arr);
                }
                else{
                    ArrayList<Integer> arr=new ArrayList<>();
                    arr.add(key);
                    colMap.put(val,arr);
                }
            }
            ballMap.put(key,val);
            ans[i]=colMap.size();
        }
        return ans;
    }
}
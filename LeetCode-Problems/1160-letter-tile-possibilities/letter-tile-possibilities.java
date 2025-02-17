class Solution {
    public void solve(boolean[] isVisited, String tiles,String s,HashSet<String> arr){
        for(int i=0;i<tiles.length();i++){
            if(!isVisited[i]){
                isVisited[i]=true;
                solve(isVisited,tiles,s,arr);
                arr.add(s+tiles.charAt(i));
                solve(isVisited,tiles,s+tiles.charAt(i),arr);
                isVisited[i]=false;
            }
        }
        return;
    }
    public int numTilePossibilities(String tiles) {
        // ArrayList<String> arr=new ArrayList<>();
        HashSet<String> arr=new HashSet<>();
        boolean[] isVisited=new boolean[tiles.length()];
        solve(isVisited,tiles,"",arr);
        System.out.println(arr);
        return arr.size();
    }
}
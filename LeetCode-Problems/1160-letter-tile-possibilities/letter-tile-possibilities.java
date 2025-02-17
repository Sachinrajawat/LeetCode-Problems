class Solution {
    public void solve(boolean[] isVisited, String tiles,String s,HashSet<String> set){
        for(int i=0;i<tiles.length();i++){
            if(!isVisited[i]){
                isVisited[i]=true;
                solve(isVisited,tiles,s,set);
                String str=s+tiles.charAt(i);
                if(!set.contains(str)) set.add(str);
                // set.add(s+tiles.charAt(i));
                solve(isVisited,tiles,str,set);
                isVisited[i]=false;
            }
        }
        return;
    }
    public int numTilePossibilities(String tiles) {
        HashSet<String> set=new HashSet<>();
        boolean[] isVisited=new boolean[tiles.length()];
        solve(isVisited,tiles,"",set);
        return set.size();
    }
}
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> l=new ArrayList<>();
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,i);
        }
        int j=0;
        while(j<s.length()){
            char ch=s.charAt(j);
            int mx=map.get(ch);
            int k=j;
            while(k<=mx){
                mx=Math.max(map.get(s.charAt(k)),mx);
                k++;
            }
            l.add(k-j);
            j=k;
        }
        return l;
    }
}
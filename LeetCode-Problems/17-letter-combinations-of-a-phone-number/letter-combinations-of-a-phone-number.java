class Solution {
    public void combinations(HashMap<Integer,ArrayList<Character>> map,List<String> ans,String digits,int idx,StringBuilder s){
        if(s.length()==digits.length()){
            String str=s.toString();
            ans.add(str);
            return;
        }
        for(int i=idx;i<digits.length();i++){
            int num=digits.charAt(i)-'0';
            ArrayList<Character> arr=map.get(num);
            for(int j=0;j<arr.size();j++){
                s.append(arr.get(j));
                combinations(map,ans,digits,i+1,s);
                s.deleteCharAt(s.length()-1);
            }
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        if(digits.length()==0) return ans;
        HashMap<Integer,ArrayList<Character>> map=new HashMap<>();
        int ch=97;
        for(int i=2;i<=9;i++){
            ArrayList<Character> arr=new ArrayList<>();
            arr.add((char)ch++);
            arr.add((char)ch++);
            arr.add((char)ch++);
            if(i==7 || i==9) arr.add((char)ch++);
            map.put(i,arr);
        }
        
        
        StringBuilder sb=new StringBuilder();
        combinations(map,ans,digits,0,sb);
        System.out.println(map);
        return ans;
    }
}
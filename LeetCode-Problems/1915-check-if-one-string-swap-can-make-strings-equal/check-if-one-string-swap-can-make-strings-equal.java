class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)) return true;
        int c=0;
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                arr.add(i);
            }
            if(arr.size()>2) return false;
        }
        if(arr.size()==0) return true;
        else if(arr.size()==1) return false;
        return s1.charAt(arr.get(0))==s2.charAt(arr.get(1)) && s2.charAt(arr.get(0))==s1.charAt(arr.get(1)); 
        // return false;
    }
}
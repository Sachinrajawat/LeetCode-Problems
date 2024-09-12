class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int[] arr=new int[26];
        for(int i=0;i<allowed.length();i++){
            arr[allowed.charAt(i)-'a']=1;
        }
        int count=0;
        for(int i=0;i<words.length;i++){
            String s=words[i];
            boolean exist=true;
            for(int j=0;j<s.length();j++){
                if(arr[s.charAt(j)-'a']==0){
                    exist=false;
                    break;
                }
            }
            if(exist) count++;
        }
        return count;
    }
}
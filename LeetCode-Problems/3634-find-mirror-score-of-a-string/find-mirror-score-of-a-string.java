class Solution {
    public long calculateScore(String s) {
        if(s.length()==1) return 0;
        long ans=0;
        Stack<Integer>[] arr=new Stack[26];
         for (int i = 0; i < 26; i++) {
            arr[i] = new Stack<>();
        }
        boolean[] unmarked=new boolean[s.length()];
        for(int i=0;i<s.length();i++){
            int x=s.charAt(i)-'a';
            if(!arr[25-x].isEmpty()){
                int a=arr[25-x].pop();
                ans+=i-a;
            }
            else{
                arr[x].push(i);
            }
        }
        return ans;
    }
}
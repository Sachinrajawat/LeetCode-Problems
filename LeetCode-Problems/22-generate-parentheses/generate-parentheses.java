class Solution {
    public void solve(int open, int close,int count, String s, List<String> list){
        if(open==0 && close==0){
            list.add(s);
            return;
        }
        if(count==0 && open>0){
            solve(open-1, close,count+1, s+'(', list);
        }
        else if(open==0 && close>0){
            solve(open, close-1,count-1, s+')', list);
        }
        else{
        solve(open, close-1, count-1, s+')', list);
        solve(open-1, close, count+1, s+'(', list);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        solve(n, n, 0,"", list);
        return list;
    }
}
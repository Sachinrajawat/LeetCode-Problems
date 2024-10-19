class Solution {
    public String oper(int curr,int n,String s){
        if(curr==n) return s;
        String inverse = s.replace('1', 'x').replace('0', '1').replace('x', '0');
        StringBuilder sb=new StringBuilder(inverse);
        sb.reverse();
        return oper(curr+1,n,s+"1"+sb.toString());
    }
    public char findKthBit(int n, int k) {
        String ans=oper(0,n,"0");
        return ans.charAt(k-1);
    }
}
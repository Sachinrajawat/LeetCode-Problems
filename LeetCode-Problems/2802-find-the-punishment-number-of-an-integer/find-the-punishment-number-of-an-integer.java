class Solution {
    public boolean solve(int num,String sq,int sum){
        if(sum+Integer.parseInt(sq)==num) return true;
        
        for(int i=1;i<sq.length();i++){
            String s=sq.substring(0,i);
            if(solve(num,sq.substring(i,sq.length()),sum+Integer.parseInt(s))) return true;
        }
        return false;
    }
    public int punishmentNumber(int n) {
        int sum=0;
        for(int i=1;i<=n;i++){
            int x=(int)Math.pow(i,2);
            String str=String.valueOf(x);
            if(x==i || solve(i,str,0)) sum+=x;
            
        }
        return sum;
    }
}
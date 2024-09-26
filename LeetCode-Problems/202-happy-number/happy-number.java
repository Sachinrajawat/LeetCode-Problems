class Solution {
    public static boolean happyNumber(int n,HashSet<Integer> set){
        if(set.contains(n)) return false;
        if(n==1) return true;
        set.add(n);
        int num=0;
        while(n>0){
            int x=n%10;
            num+=Math.pow(x,2);
            n/=10;
        }
        return happyNumber(num, set);
    }
    public boolean isHappy(int n) {
        
        HashSet<Integer> set=new HashSet<>();
        return happyNumber(n,set);
    }
}
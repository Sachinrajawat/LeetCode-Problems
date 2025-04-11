class Solution {
    public int countSymmertric(int num){
        int count=0;
        for(int i=11;i<=num;i++){
            String x=String.valueOf(i);
            if(x.length()%2!=0) continue;
            int sum=0;
            for(int j=0;j<x.length()/2;j++){
                sum+=x.charAt(j)-'0';
            }
            for(int j=x.length()/2;j<x.length();j++){
                sum-=x.charAt(j)-'0';
            }
            if(sum==0) count++;
        }
        return count;
    }
    public int countSymmetricIntegers(int low, int high) {
        return countSymmertric(high) - countSymmertric(low-1);
    }
}
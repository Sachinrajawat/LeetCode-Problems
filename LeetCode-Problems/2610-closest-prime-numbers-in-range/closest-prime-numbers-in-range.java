class Solution {
    public boolean isPrime(int x){
        if(x<=1) return false;
        if(x<=3) return true;
        if(x%2==0 || x%3==0) return false;
        for(int i=5;i*i<=x;i+=6){
            if(x%i==0 || x%(i+2)==0) return false;
        }
        return true;
    }
    public int[] closestPrimes(int left, int right) {
        ArrayList<Integer> arr=new ArrayList<>();
        // System.out.println(isPrime(11));
        for(int i=left;i<=right;i++){
            if(isPrime(i)) arr.add(i);
        }
        int[] ans=new int[]{-1,-1};
        if(arr.size()<2) return ans;
        int diff=Integer.MAX_VALUE;
        // System.out.println(arr);
        for(int i=0;i<arr.size()-1;i++){
            if(arr.get(i+1)-arr.get(i)<diff){
                ans[0]=arr.get(i);
                ans[1]=arr.get(i+1);
                diff=arr.get(i+1)-arr.get(i);
            }
        }
        return ans;
    }
}
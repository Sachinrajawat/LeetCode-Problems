class Solution {
    public boolean isPrime(int n){
        if(n==1) return false;
        if(n==2 || n==3) return true;
        if(n%2==0||n%3==0) return false;
        for(int i=5;i<Math.sqrt(n);i+=6){
            if((n%i==0)||(n%(i+2)==0)) return false;
        }
        return true;
    }
    public int kthFactor(int n, int k) {
        if(k==1) return 1;
        if(isPrime(n)){
            if(k>2) return -1;
            else if(k==2) return n;
        }
        
        if(n/2+1<k) return -1;
        // ArrayList<Integer> arr=new ArrayList<>();
        // arr.add(1);
        int a=1;
        for(int i=2;i<=n/2;i++){
            if(n%i==0){
                a++;
                System.out.println(a+" "+i);
                if(a==k) return i;
            }
        }
        if(a+1==k) return n;
        // arr.add(n);
        // System.out.println(arr);
        // if(arr.size()<k) return -1;
        return -1;
    }
}
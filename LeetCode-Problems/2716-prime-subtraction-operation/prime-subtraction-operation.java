class Solution {
    public boolean isPrime(int num){
        if(num<=1) return false;
        if(num<=3) return true;
        if(num%2==0||num%3==0) return false;
        for(int i=5;i*i<=num;i+=6){
            if(num%i==0 || num%(i+2)==0) return false;
        }
        return true;
    }
    public int prime(int x,int num){
        while(x<num){
            if(isPrime(x)) return x;
            x++;
        }
        return 0;
    }
    public boolean primeSubOperation(int[] nums) {
        if(nums.length==1) return true;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]>=nums[i+1]){
                int x=nums[i]-nums[i+1]+1;
                int sub=prime(x,nums[i]);
                if(sub==0) return false;
                nums[i]-=sub;
            }
        }
        
        return true;
    }
}
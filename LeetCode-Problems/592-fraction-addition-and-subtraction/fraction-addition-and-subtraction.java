class Solution {
    public static int findGCD(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }
    public String fractionAddition(String expression) {
        String[] nums = expression.split("/|(?=[-+])");
        int deno=1;
        for(int i=1;i<nums.length;i+=2){
            deno*=Integer.parseInt(nums[i]);
        }
        // System.out.println(deno);
        int nume=0;
        for(int i=0;i<nums.length-1;i+=2){
            nume+=Integer.parseInt(nums[i])*(deno/Integer.parseInt(nums[i+1]));
        }
        // System.out.println(nume);
        // for(int i=0;i<nums.length;i++){
        //     System.out.println(nums[i]);
        // }
        int gcd=findGCD(nume,deno);
        // System.out.println(gcd);
        if(gcd<0) gcd*=-1;
        nume/=gcd;
        deno/=gcd;
        // System.out.println(nume+" "+deno);
        String ans="";
        ans=String.valueOf(nume)+'/'+String.valueOf(deno);
        
        return ans;
    }
}
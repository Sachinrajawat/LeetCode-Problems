class Solution {
    public boolean lemonadeChange(int[] bills) {
        int sum=0;
        int[] arr={0,0,0}; //count of $5,$10,$20
        for(int i=0;i<bills.length;i++){
            if(bills[i]==10){
                arr[0]--; //decrease $5 count
                if(arr[0]<0) return false;
                arr[1]++; //increase $10 count
            }
            else if(bills[i]==20){
                if(arr[1]>=1){ //if $10 coin present then take $5 & $10 coin
                    arr[0]--;
                    arr[1]--;
                }
                else arr[0]-=3; //if $10 coin not present then take three $5 coin
                if(arr[0]<0 ||arr[1]<0) return false; 
                arr[2]++; //increase $20 count
            }
            else arr[0]++; //increase $5 count
        }
        return true;
    }
}
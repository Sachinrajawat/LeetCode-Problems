class Solution {
    public boolean lemonadeChange(int[] bills) {
        if(bills[0]>5) return false;
        int sum=0;
        int[] arr={0,0,0}; //count of $5,$10,$20
        for(int i=0;i<bills.length;i++){
            if(bills[i]==10){
                arr[0]--;
                if(arr[0]<0) return false;
            }
            else if(bills[i]==20){
                if(arr[1]>=1){arr[0]--;
                arr[1]--;
                }
                else{
                    arr[0]-=3;
                }
                if(arr[0]<0 ||arr[1]<0) return false;
            }
            if(bills[i]==5) arr[0]++;
            else if(bills[i]==10) arr[1]++;
            else arr[2]++;
        }
        return true;
    }
}
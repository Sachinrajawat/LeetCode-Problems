class Solution {
    public int mod=1000000007;
    
    public int numOfSubarrays(int[] arr) {
        int n=arr.length;
        int[] evenCount=new int[n];
        int[] oddCount=new int[n];
        if(arr[0]%2==0) evenCount[0]=2;
        else{
            evenCount[0]=1;
            oddCount[0]++;
        }
        for(int i=1;i<n;i++){
            arr[i]+=arr[i-1];
            if(arr[i]%2==0){
                evenCount[i]=evenCount[i-1]+1;
                oddCount[i]=oddCount[i-1];
            }
            else{
                oddCount[i]=oddCount[i-1]+1;
                evenCount[i]=evenCount[i-1];
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(arr[i]%2==0) count+=oddCount[i];
            else count+=evenCount[i];
            count%=mod;
        }
        return count%mod;
    }
}
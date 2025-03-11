class Solution {
    public int numberOfSubstrings(String s) {
        int a=0,b=0,c=0;
        int n=s.length();
        int[][] arr=new int[n][3];
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='a') a++;
            else if(s.charAt(i)=='b') b++;
            else c++;
            arr[i][0]=a;
            arr[i][1]=b;
            arr[i][2]=c;
            System.out.print(arr[i][0]+" "+arr[i][1]+" "+arr[i][2]+", ");
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(arr[i][0]>0 && arr[i][1]>0 && arr[i][2]>0){
                ans++;
                for(int j=i-3;j>=0;j--){
                    if(arr[i][0]-arr[j][0]>0 && arr[i][1]-arr[j][1]>0 && arr[i][2]-arr[j][2]>0){
                        ans+=j+1;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
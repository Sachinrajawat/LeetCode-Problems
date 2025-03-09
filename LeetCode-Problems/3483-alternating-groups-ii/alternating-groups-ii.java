class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int count=0;
        int n=colors.length;
        int a=1;

        for(int i=0;i<n-1;i++){
            if(colors[i]==colors[i+1]) a=1;
            else{
                a++;
                if(a>=k) count++;
            }
        }
        if(colors[n-1]!=colors[0]){
            a++;
            if(a>=k) count++;
        for(int i=0;i<k-2;i++){
            if(colors[i]==colors[i+1]) break;
            else{
                a++;
                if(a>=k) count++;
            }
        }
    }
        return count;
    }
}
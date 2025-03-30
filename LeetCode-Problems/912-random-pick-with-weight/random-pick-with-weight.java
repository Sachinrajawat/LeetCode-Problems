class Solution {
    int[] pre;
    Random rand;
    
    public Solution(int[] w) {
        rand
        =new Random();
        pre=new int[w.length];
        pre[0]=w[0];
        for(int i=1;i<w.length;i++){
            pre[i]=pre[i-1]+w[i];
        }
    }
    
    public int pickIndex() {
        int max=pre[pre.length-1];
        int randomNum = rand.nextInt(max) + 1;;
        int st=0, end=pre.length-1;
        int idx=0;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(pre[mid]<randomNum){
                st=mid+1;
            }else{
                idx=mid;
                end=mid-1;
            }
        }
        return idx;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
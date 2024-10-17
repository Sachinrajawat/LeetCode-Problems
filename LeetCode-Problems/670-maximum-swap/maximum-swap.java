class Solution {
    public int maximumSwap(int num) {
        String nums=String.valueOf(num);

        
        // if(nums.charAt(0)=='9' || nums.length()==1) return num;
        StringBuilder sb=new StringBuilder(nums);
        boolean swap=false;
        for(int j=0;j<sb.length();j++){
            int idx=j;
            char max=sb.charAt(j);
            for(int i=j+1;i<sb.length();i++){
                if(sb.charAt(j)<sb.charAt(i) && max<=sb.charAt(i)){
                    swap=true;
                    idx=i;
                    max=sb.charAt(i);
                }
            }
            if(swap){
            char ch=sb.charAt(j);
            sb.setCharAt(j,sb.charAt(idx));
            sb.setCharAt(idx,ch);
            break;
            }

        }
        int ans=Integer.parseInt(sb.toString());
        return ans;
    }
}
class Solution {
    public long countGoodIntegers(int n, int k) {
        Set<String> st=new HashSet<>();
        int d=(n+1)/2;
        long start=(long)Math.pow(10,d-1);
        long end=(long)Math.pow(10,d)-1;

        for(long i=start;i<=end;i++){
            String leftHalf=Long.toString(i);
            String full="";
            StringBuilder rightHalf=new StringBuilder(leftHalf);
            rightHalf.reverse();
            if(n%2==0){
                full=leftHalf+rightHalf;
            }
            else{
                full=leftHalf+rightHalf.substring(1);
            }
            long number=Long.parseLong(full);
            if(number%k!=0){
                continue;
            }
            char[] chars = full.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            st.add(sorted);
        }

        long[] factorial=new long[11];
        factorial[0] = 1;
        for(int i=1;i<11;i++){
            factorial[i]=factorial[i-1]*i;
        }
        long result=0;
        for(String s:st){
            int[] count=new int[10];
            for(char ch:s.toCharArray()){
                count[ch-'0']++;
            }
            int totalDigits = s.length();
            int zeroDigits = count[0];
            int nonZeroDigits=totalDigits-zeroDigits;
            long perm = nonZeroDigits* factorial[totalDigits-1];

            for(int i=0;i<10;i++){
                perm/=factorial[count[i]];
            }
            result+=perm;
        }
        return result;
    }
}
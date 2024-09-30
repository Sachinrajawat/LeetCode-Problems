class Solution {
    public char kthCharacter(long k, int[] operations) {
        if(k==1) return 'a';
        long len=1,oprType=0,newk=0;
        for(int i=0;i<operations.length;i++){
            len*=2;
            if(len>=k){
                oprType=operations[i];
                newk=k-(len/2);
                break;
            }
        }
        char ch=kthCharacter(newk,operations);
        if(oprType==0) return ch;
        else{
            if(ch=='z') return 'a';
            return (char)(ch+1);
        }
    }
}
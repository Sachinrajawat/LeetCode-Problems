class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] count=new int[words.length+1];
        int c=0;
        for(int i=0;i<words.length;i++){
            char st=words[i].charAt(0);
            char lt=words[i].charAt(words[i].length()-1);
            if((st=='a' || st=='e' || st=='i' || st=='o' || st=='u')&&(lt=='a' || lt=='e' || lt=='i' || lt=='o' || lt=='u')){
                c++;
            }
            count[i+1]=c;
        }
        int[] ans=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            ans[i]=count[queries[i][1]+1]-count[queries[i][0]];
        }
        return ans;
    }
}
class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int i=0, j=skill.length-1;
        long ans=0, check=skill[i]+skill[j];
        while(i<j){
            if((skill[i]+skill[j])!=check) return -1;
            ans+=skill[i]*skill[j];
            i++;
            j--;
        }
        return ans;
    }
}
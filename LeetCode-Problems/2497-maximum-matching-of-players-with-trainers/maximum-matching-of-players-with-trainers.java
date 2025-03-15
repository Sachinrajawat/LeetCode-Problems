class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int i=0,j=0;
        Arrays.sort(players);
        Arrays.sort(trainers);
        int c=0;
        while(i<players.length && j<trainers.length){
            if(players[i]<=trainers[j]){
                c++;
                j++;
                i++;
            }
            else{
                j++;
            }
        }
        // System.out.println(i+" "+j);
        return c;
    }
}
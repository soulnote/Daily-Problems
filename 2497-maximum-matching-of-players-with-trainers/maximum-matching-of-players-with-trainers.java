class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int p = players.length-1, t = trainers.length-1;
        int count = 0;
        while(p>=0 && t>=0){
            if(players[p]<=trainers[t]){
                count++;
                p--;
                t--;
            }
            else p--;
        }
        return count;
    }
}
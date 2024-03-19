class Solution {
    public int leastInterval(char[] tasks, int n) {
        int [] charArr = new int [26];
        for(int i=0;i<tasks.length;i++){
            charArr[tasks[i]-'A']++;
        }
        Arrays.sort(charArr);
        int max  = charArr[25];
        int idle = (max-1)*n;
        for(int i=24;i>=0;i--){
            idle-=Math.min(max-1,charArr[i]);
        }
        return tasks.length + Math.max(idle,0);
    }
}
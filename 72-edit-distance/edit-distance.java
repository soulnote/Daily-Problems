class Solution {
    public int minDistance(String word1, String word2) {
        int[][]memo = new int[word1.length()][word2.length()];
        for(int[]num : memo){
            Arrays.fill(num, -1);
        }
        return helper(0,0, word1, word2, memo);
    }
    public int helper(int idx1, int idx2 , String word1, String word2, int[][]memo){
        if(idx2 >= word2.length())return word1.length()-idx1;
        if(idx1 >= word1.length())return word2.length()-idx2;

        if(memo[idx1][idx2]!=-1)return memo[idx1][idx2]; 
        int ans = 0 ;
        if(word1.charAt(idx1)== word2.charAt(idx2)){//same char
            ans = helper(idx1+1, idx2+1, word1, word2, memo);
        }
        else{
            //for different chars
            int replace = 1+helper(idx1+1, idx2+1, word1, word2, memo);
            int delete = 1+helper(idx1+1, idx2, word1, word2, memo);
            int insert = 1+helper(idx1, idx2+1, word1, word2, memo);
            ans = Math.min(Math.min(replace, delete), insert);
        }
        
        
        return memo[idx1][idx2] = ans;
    }
}
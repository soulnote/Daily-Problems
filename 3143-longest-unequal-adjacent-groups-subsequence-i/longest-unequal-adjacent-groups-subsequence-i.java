class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int longestsublength = 0,currgroup =-1, n = words.length;
        List<String> longestsub = new ArrayList<>();
        for(int i =0;i<n;i++){
            if(groups[i]!=currgroup){
                currgroup = groups[i];
                longestsub.add(words[i]);
                longestsublength++;
            }
        }
        return longestsub;
    }
}
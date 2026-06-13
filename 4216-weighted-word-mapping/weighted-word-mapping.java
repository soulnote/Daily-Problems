class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        String ans = "";
        for(String s : words){
            int sum = 0;
            for(int i=0;i<s.length();i++){
                sum+= weights[s.charAt(i)-'a'];
            }
            sum%= 26;
            // System.out.println(sum);
            char ch = (char)('a'+26-sum-1);
            ans+= ""+ch;
        }
        return ans;
    }
}
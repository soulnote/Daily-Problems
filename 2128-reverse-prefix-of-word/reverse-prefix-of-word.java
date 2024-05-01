class Solution {
    public String reversePrefix(String word, char ch) {
        String ans = "";
        for(int i=0;i<word.length();i++){
            
            if(word.charAt(i)==ch){
                String reversed = "";
                for(int j=i;j>=0;j--){
                    reversed += ""+ word.charAt(j);
                }
                ans = reversed + word.substring(i+1);
                break;
            }
        }
        if(ans.length()==0)return word;
        return ans;
    }
}
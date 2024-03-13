class Solution {
    public String interpret(String s) {
        StringBuilder ans = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == 'G'){
                ans.append(s.charAt(i));
            }else if(s.charAt(i) == '(' && s.charAt(i+1) == ')'){
                ans.append("o");
            }else if(s.charAt(i) == '(' && s.charAt(i+1) == 'a'){
                ans.append("al");
            }
        }
        return ans.toString();
    }
}
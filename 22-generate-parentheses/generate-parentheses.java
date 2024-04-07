class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate("", 2*n, ans);
        return ans;
    }
    public void generate(String str, int n, List<String> ans){
        if(str.length()==n){
            if(isValid(str))ans.add(str);
            return;
        }
        generate(str+"(", n, ans);
        generate(str+")", n, ans);
    }
    public boolean isValid(String str){
        int count=0;
        for(char ch: str.toCharArray()){
            if(ch=='(')count++;
            else{
                if(count>0)count--;
                else return false;
            }
        }
        if(count==0)return true;
        return false;
    }
}
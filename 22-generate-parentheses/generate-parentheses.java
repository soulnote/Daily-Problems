class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate("", n, n, ans);
        return ans;
    }

    public void generate(String str, int open, int close, List<String> ans) {
        if (open == 0 && close == 0) {
            ans.add(str);
            return;
        }
        if (open > 0) {
            generate(str + "(", open - 1, close, ans);
        }
        if (close > open) {
            generate(str + ")", open, close - 1, ans);
        }
    }
}

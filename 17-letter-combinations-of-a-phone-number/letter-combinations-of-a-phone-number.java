import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length()==0)return ans;
        String[] Kpad = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder sb = new StringBuilder();
        solve(0, digits, sb, Kpad, ans);
        return ans;
    }

    public void solve(int idx, String digits, StringBuilder sb, String[] kPad, List<String> ans) {
        if (idx == digits.length()) {
            ans.add(sb.toString());
            return;
        }

        for (int i = 0; i < kPad[digits.charAt(idx) - '0'].length(); i++) {
            sb.append(kPad[digits.charAt(idx) - '0'].charAt(i));
            solve(idx + 1, digits, new StringBuilder(sb), kPad, ans); // Create a copy of StringBuilder
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

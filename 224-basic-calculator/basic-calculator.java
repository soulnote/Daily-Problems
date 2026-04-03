class Solution {
    int i = 0;

    public int calculate(String s) {
        return helper(s);
    }

    private int helper(String s) {
        int result = 0;
        int sign = 1;
        int num = 0;

        while (i < s.length()) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
                i++;
            } 
            else if (ch == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
                i++;
            } 
            else if (ch == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
                i++;
            } 
            else if (ch == '(') {
                i++; // skip '('
                num = helper(s); // solve inside
            } 
            else if (ch == ')') {
                i++; // skip ')'
                break;
            } 
            else {
                i++; // skip space
            }
        }

        return result + sign * num;
    }
}
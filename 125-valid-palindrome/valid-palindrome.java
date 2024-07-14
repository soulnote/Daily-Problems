class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                if (Character.isUpperCase(ch)) {
                    char newch = Character.toLowerCase(ch);
                    str.append(newch);
                } else {
                    str.append(ch);
                }
            }
        }
        StringBuilder reversed = new StringBuilder(str).reverse();
        return str.toString().equals(reversed.toString());
    }
}
class Solution {

    int i = 0; // global pointer

    public String decodeString(String s) {
        return helper(s);
    }

    private String helper(String s) {
        StringBuilder result = new StringBuilder();
        int k = 0;

        while (i < s.length()) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
                i++;
            } 
            else if (ch == '[') {
                i++; // skip '['
                String decoded = helper(s); // recursive call

                // repeat decoded string k times
                for (int j = 0; j < k; j++) {
                    result.append(decoded);
                }
                k = 0;
            } 
            else if (ch == ']') {
                i++; // skip ']'
                return result.toString();
            } 
            else {
                result.append(ch);
                i++;
            }
        }

        return result.toString();
    }
}
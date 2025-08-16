class Solution {
    public int maximum69Number (int num) {
        String s = Integer.toString(num);
        StringBuilder ans = new StringBuilder(s);

        for (int i = 0; i < ans.length(); i++) {
            if (ans.charAt(i) == '6') {
                ans.setCharAt(i, '9'); 
                break;                 
            }
        }

        return Integer.parseInt(ans.toString());
    }
}

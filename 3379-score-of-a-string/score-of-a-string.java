class Solution {
    public int scoreOfString(String s) {
        int score = 0;
        for (int i = 1; i < s.length(); i++) {
            int ascii1 = (int) s.charAt(i - 1);
            int ascii2 = (int) s.charAt(i);
            score += Math.abs(ascii1 - ascii2);
        }
        return score;
    }
}

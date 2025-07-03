class Solution {
    public char kthCharacter(int k) {
        StringBuilder word = new StringBuilder("a");

        while (word.length() < k) {
            int len = word.length();
            StringBuilder next = new StringBuilder();
            
            for (int i = 0; i < len; i++) {
                char currentChar = word.charAt(i);
                char nextChar = (currentChar == 'z') ? 'a' : (char)(currentChar + 1);
                next.append(nextChar);
            }
            word.append(next);
            next = null;
        }

        return word.charAt(k - 1);
    }
}
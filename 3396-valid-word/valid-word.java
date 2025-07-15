class Solution {
    public boolean isValid(String word) {
        if (word.length() < 3) return false;

        int vowels = 0;
        int consonants = 0;

        for (char ch : word.toCharArray()) {
            if (!Character.isLetterOrDigit(ch)) return false;

            if (Character.isLetter(ch)) {
                char lower = Character.toLowerCase(ch);
                if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        return vowels > 0 && consonants > 0;
    }
}
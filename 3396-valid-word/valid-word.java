class Solution {
    public boolean isValid(String word) {
        if(word.length()<3)return false;
        boolean isDigit = true, isVowelPresent = false, isConstantPresent = false;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!Character.isLetterOrDigit(ch))return false;
            if(Character.isDigit(ch)){
                isDigit = true;
            }
            if(Character.isLetter(ch)){
                if(isVowel(ch))isVowelPresent=true;
                else isConstantPresent=true;
            }
        }
        return isDigit && isVowelPresent && isConstantPresent;
    }
    public boolean isVowel(char ch){
        HashSet<Character> set = new HashSet<>();
        set.add('a');set.add('A');
        set.add('e');set.add('E');
        set.add('o');set.add('O');
        set.add('i');set.add('I');
        set.add('u');set.add('U');
        if(set.contains(ch))return true;
        return false;
    }
}
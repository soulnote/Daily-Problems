class Solution {
    public boolean isPalindrome(String str) {
        String lowerCaseAlphaStr = convertToLowerCaseAlphabetic(str);
        System.out.print(lowerCaseAlphaStr);
        if(lowerCaseAlphaStr.length()==0) return true;
        int left =0,right=lowerCaseAlphaStr.length()-1;
        while(left<=right){
            if(lowerCaseAlphaStr.charAt(left)!=lowerCaseAlphaStr.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
        
    }
    public static String convertToLowerCaseAlphabetic(String str) {
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                result.append(Character.toLowerCase(c));
            } 
        }
        return result.toString();
    }
}
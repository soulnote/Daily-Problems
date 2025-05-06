class Solution {
    public boolean isPalindrome(String s) {
        int start = 0, last = s.length()-1;
        while(start<=last){
            int currStart = start, currLast = last;
            
            if(!Character.isLetterOrDigit(s.charAt(currStart))){
                start++;
            }
            else if(!Character.isLetterOrDigit(s.charAt(currLast))){
                last--;
            }
            else{
                if(Character.toLowerCase(s.charAt(currStart))!=Character.toLowerCase(s.charAt(currLast))){
                    return false;
                }
                start++;
                last--;
            }
        }
        return true;
    }
}
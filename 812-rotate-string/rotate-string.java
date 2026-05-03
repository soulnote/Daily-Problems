class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length())return false;
        if(s.equals(goal))return true;
        boolean possible = false;
        char ch = s.charAt(0);
        for(int i=0;i<s.length();i++){
            if(ch==goal.charAt(i)){
                String str = goal.substring(i, goal.length()) + goal.substring(0, i);
                // System.out.println(str);
                if(str.equals(s)) possible = true;
            }
        }
        return possible;
    }
}
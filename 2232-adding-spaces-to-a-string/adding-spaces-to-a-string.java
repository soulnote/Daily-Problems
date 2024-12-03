class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int pre = 0;
        for(int next: spaces){
            String str = s.substring(pre, next) + " ";
            sb.append(str);
            pre = next;
        }
        sb.append(s.substring(pre, s.length()));
        return sb.toString();
    }
}
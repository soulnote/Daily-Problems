class Solution {
    public int titleToNumber(String columnTitle) {
        int titleNumber = 0;
        int multiplier = 1;
        for(int i=columnTitle.length()-1;i>=0;i--){
            titleNumber+= multiplier * (columnTitle.charAt(i)-'A'+1);
            multiplier*=26;
        }
        return titleNumber;
    }
}
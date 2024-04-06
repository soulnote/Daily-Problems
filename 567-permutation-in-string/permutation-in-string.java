class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1>n2) return false;
        char []chArr = new char[26];
        for(int i=0;i<n1;i++){
            chArr[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<=n2-n1;i++){
            int ch = s2.charAt(i)-'a';
            if(chArr[ch]>0){
                String sb = s2.substring(i,i+n1);
                char[] s1Arr = s1.toCharArray();
                char[] s2Arr = sb.toCharArray();
                Arrays.sort(s1Arr);
                Arrays.sort(s2Arr);
                if (Arrays.equals(s1Arr, s2Arr)) return true;
                else continue;
            }
        }
        return false;
    }
}
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1>n2) return false;
        int []fqArr1 = new int[26];
        // char[] s1Arr = s1.toCharArray();
        // Arrays.sort(s1Arr);
        for(int i=0;i<n1;i++){
            fqArr1[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<=n2-n1;i++){
            int ch = s2.charAt(i)-'a';
            if(fqArr1[ch]>0){
                String sb = s2.substring(i,i+n1);
                int[]fqArr2 = new int[26];
                for(int j=i;j<i+n1;j++){
                    fqArr2[s2.charAt(j)-'a']++;
                }
 
                if (Arrays.equals(fqArr1, fqArr2)) return true;
                else continue;
            }
        }
        return false;
    }
}
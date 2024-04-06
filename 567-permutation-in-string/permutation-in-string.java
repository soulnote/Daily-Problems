class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1= s1.length();
        int n2 = s2.length();
        if(n1>n2) return false;
        int []fqArr = new int[26];
        for(int i=0;i<n1;i++){
            fqArr[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<n1;i++){
            fqArr[s2.charAt(i)-'a']--;
        }
        if(isPresent(fqArr))return true;
        int left = 0,right= n1;
        while(right<n2){
            fqArr[s2.charAt(left)-'a']++;
            fqArr[s2.charAt(right)-'a']--;
            if(isPresent(fqArr)) return true;
            left++;
            right++;
        }
        return false;
    }
    public boolean isPresent(int[]arr){
        for(int i=0;i<26;i++){
            if(arr[i]!=0)return false;
        }
        return true;
    }
}
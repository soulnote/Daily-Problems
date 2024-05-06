class Solution {
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        if(m>n) return "";
        
        int[] tFreq = new int[260];
        int[] sFreq = new int[260];
        
        for(int i = 0 ; i < m; i++){
            tFreq[t.charAt(i)]++;
        }

        int count = 0, left = 0, right = 0, len = Integer.MAX_VALUE, start = -1;
        for(; right < n; right++){
            char ch = s.charAt(right);
            sFreq[ch]++;

            if(sFreq[ch]<=tFreq[ch]) count++;

            while(count==m){
                if(right-left+1<len){
                    len = right-left+1;
                    start = left;
                }
                sFreq[s.charAt(left)]--;
                if(sFreq[s.charAt(left)] < tFreq[s.charAt(left)]) count--;
                left++;
            }
        }
        if(start==-1 ) return "";
        return s.substring(start, start+len);
    }
}
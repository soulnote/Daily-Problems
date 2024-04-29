class Solution {
    public String longestPalindrome(String str) {
        int n = str.length();
        int ans = 1;
        int beg = 0;
        for(int current=0; current<n; current++){
            
            //odd
            int l = current-1, r=current+1;
            while(l>=0 && r<n && str.charAt(l)==str.charAt(r)){
                if(r-l+1 > ans){
                    ans = r-l+1;
                    beg = l;
                }
                
                l--;
                r++;
            }
            
            //even
            l= current;
            r = current+1;
            while(l>=0 && r<n && str.charAt(l)==str.charAt(r)){
                if(r-l+1 > ans){
                    ans = r-l+1;
                    beg = l;
                }
                l--;
                r++;
            }

        }

        return str.substring(beg, beg+ans);
    }
}   
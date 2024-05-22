class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();

        solve(0, s, ans, list);
        return ans;
    }
    public void solve(int idx, String s, List<List<String>>ans , List<String>list){
        if(idx==s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
  
        for(int i=idx; i<s.length();i++){
            String part1 = s.substring(idx, i+1);
            if(isPalindrom(part1)){
                list.add(part1);
                solve(i+1, s, ans, list);
                list.remove(list.size()-1);
            }
        }
    }
    public boolean isPalindrom(String s){
        int left = 0, right = s.length()-1;
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right))return false;
            left++;
            right--;
        }
        
        return true;
    }
}
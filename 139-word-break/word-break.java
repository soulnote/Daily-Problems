class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        HashMap<String, Boolean> dp = new HashMap<>();   
        for(String str : wordDict){
            set.add(str);
        }
        return helper(s, set, dp);
    }
    public boolean helper(String s , HashSet<String> set, HashMap<String, Boolean>dp ){
        if(s.length()==0)return true;
        if(dp.containsKey(s))return dp.get(s);
        for(int i=0;i<=s.length();i++){
            String pre = s.substring(0,i);
            if(set.contains(pre) && helper(s.substring(i), set, dp)){
                dp.put(s, true);
                return true;
            }
        }
        dp.put(s,false);
        return false;
    }
}
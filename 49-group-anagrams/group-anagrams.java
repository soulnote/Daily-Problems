class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i =0;i<strs.length;i++){
            String s = strs[i];
            char[] tempS = s.toCharArray();
            Arrays.sort(tempS);
            String sortedS = new String(tempS);
            if(map.containsKey(sortedS)){
                map.get(sortedS).add(s);
            }
            else{
                map.put(sortedS, new ArrayList());
                map.get(sortedS).add(s);
            }
        }
        for (String key : map.keySet()) {
            ans.add(map.get(key));
        }
        return ans;
    }
}
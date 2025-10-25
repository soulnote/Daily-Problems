class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] charArray = strs[i].toCharArray(); 
            Arrays.sort(charArray);
            String s = new String(charArray);
            if(map.containsKey(s)){
                map.get(s).add(strs[i]);
            }
            else{
                map.put(s, new ArrayList<>());
                map.get(s).add(strs[i]);
            }

        }
        int idx = 0;
        for(String key : map.keySet()){
            ans.add(map.get(key));
        }
        return ans;
    }
}
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        int idx=0;
        for(int i=0;i<strs.length;i++){
            char[] charArray = strs[i].toCharArray();

            Arrays.sort(charArray);
            
            String sortedStr = new String(charArray);

            if(map.containsKey(sortedStr)){
                ans.get(map.get(sortedStr)).add(strs[i]);
            }
            else{
                map.put(sortedStr,idx++);
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                ans.add(list);
            }
        }
        return ans;
    }
}
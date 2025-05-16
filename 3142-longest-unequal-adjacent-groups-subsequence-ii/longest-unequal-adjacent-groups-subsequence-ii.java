class Solution { 
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        HashMap<String,List<String>> map = new HashMap<>();
        List<String> ans = function(0,-1,words,groups,map);
        return ans;
    }

    public List<String> function(int ind,int prev,String[] words,int[] groups,HashMap<String,List<String>> map){

        if(ind>=words.length) return new ArrayList<>();

        String key = ind + " " + prev;

        if(map.containsKey(key)) return map.get(key);

        List<String> takeCurrent = new ArrayList<>();
        if(prev==-1 || ((groups[prev]!=groups[ind]) && (words[prev].length()==words[ind].length()) && (hammingDist(words[prev],words[ind])==1) )){
            takeCurrent = new ArrayList<>(function(ind+1,ind,words,groups,map));
            takeCurrent.add(0,words[ind]);
        }

        List<String> skipCurrent = function(ind+1,prev,words,groups,map);
        
        if(skipCurrent.size()>takeCurrent.size()){
            map.put(key,skipCurrent);
        }else{
            map.put(key,takeCurrent);
        }

        return map.get(key);
    }
    
    static int hammingDist(String str1, String str2) 
    { 
        int i = 0, count = 0; 
        while (i < str1.length()) { 
            if (str1.charAt(i) != str2.charAt(i)) 
                count++; 
            i++; 
        } 
        return count; 
    } 
    
    
}
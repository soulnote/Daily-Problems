class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        List<List<String>> wordsCombination = new ArrayList<>();
        List<String> list = new ArrayList<>();
        int maxValue = 0;
        subsets(0, words, wordsCombination, list);

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<letters.length;i++){
            map.put(letters[i], map.getOrDefault(letters[i],0)+1);
        }
        HashMap<String ,Integer> wordsMap = new HashMap<>();
        for(int i=0;i<words.length;i++){
            String s = words[i];
            int val = 0;
            for(int j =0;j<s.length();j++){
                char ch = s.charAt(j);
                val+= score[ch-'a'];
            }
            wordsMap.put(s, wordsMap.getOrDefault(s,val));
        }
        for(int i=0;i<wordsCombination.size();i++){
            HashMap<Character, Integer> mapNew = new HashMap<>(map);
            boolean possibleCombination = true;
            int combinationValue = 0;
            for(int j=0;j<wordsCombination.get(i).size();j++){
                String word = wordsCombination.get(i).get(j);
                if(mapNew.size()==0){
                    possibleCombination=false;
                    break;
                }
                for(int k=0;k<word.length();k++){
                    char ch = word.charAt(k);
                    if(!mapNew.containsKey(ch)){
                        possibleCombination=false;
                        break;
                    }
                    if(mapNew.get(ch)==1)mapNew.remove(ch);
                    else mapNew.put(ch, mapNew.get(ch)-1);
                }
                
                combinationValue += wordsMap.getOrDefault(word,0) ;
            }
            if(possibleCombination){
                maxValue = Math.max(combinationValue, maxValue);
            }
        }
        return maxValue;
    }
    public void subsets(int idx, String[]words, List<List<String>> wordsCombination, List<String> list){
        if(idx == words.length){
            wordsCombination.add(new ArrayList<>(list));
            return;
        }
        // pick
        list.add(words[idx]);
        subsets(idx+1,words, wordsCombination, list);
        list.remove(list.size()-1);
        //dont pick
        subsets(idx+1,words, wordsCombination, list);
    }
}
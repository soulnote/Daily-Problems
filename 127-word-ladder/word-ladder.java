class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        HashSet<String> visited = new HashSet<>();

        if(!set.contains(endWord))return 0;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int changes = 1;
        int n = beginWord.length();
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                String s = q.poll();
                if(s.equals(endWord))return changes;
                
                for(int j=0;j<n;j++){
                    for(int k='a';k<='z';k++){
                        char[]arr = s.toCharArray();
                        arr[j] = (char) k;

                        String newS = new String(arr);
                        if(set.contains(newS) && !visited.contains(newS)){
                            q.add(newS);
                            visited.add(newS);
                        }
                    }
                }
            }
            changes++;
        }
        return 0;
    }
}
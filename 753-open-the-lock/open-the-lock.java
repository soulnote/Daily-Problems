class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> visited = new HashSet<>();
        Map<Character, Character> nextSlot = Map.of(
            '0', '1', 
            '1', '2', 
            '2', '3', 
            '3', '4', 
            '4', '5', 
            '5', '6', 
            '6', '7', 
            '7', '8', 
            '8', '9', 
            '9', '0'
        );
        // Map the previous slot digit for each current slot digit.
        Map<Character, Character> prevSlot = Map.of(
            '0', '9', 
            '1', '0', 
            '2', '1', 
            '3', '2', 
            '4', '3', 
            '5', '4', 
            '6', '5', 
            '7', '6', 
            '8', '7', 
            '9', '8'
        );
        for(String s : deadends){
            visited.add(s);
        }
        if(visited.contains("0000"))return -1;
        Queue<String> q = new LinkedList<>();
        q.add("0000");
        visited.add("0000");
        int turns = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                String s = q.poll();
                if(s.equals(target))return turns;
                else{
                    for(int w=0;w<4;w++){
                        StringBuilder newS = new StringBuilder(s);
                        newS.setCharAt(w,nextSlot.get(newS.charAt(w)));
                        if(!visited.contains(newS.toString())){
                            q.add(newS.toString());
                            visited.add(newS.toString());
                        }
                        newS = new StringBuilder(s);
                        newS.setCharAt(w,prevSlot.get(newS.charAt(w)));
                        if(!visited.contains(newS.toString())){
                            q.add(newS.toString());
                            visited.add(newS.toString());
                        }
                    }
                }
            }
            turns++;
        }
        return -1;
    }
}
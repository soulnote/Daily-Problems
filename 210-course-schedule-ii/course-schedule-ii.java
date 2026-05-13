class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int[] indegree =  new int[numCourses];
        for(int[]prerequisit : prerequisites){
            int num1 = prerequisit[0];
            int num2 = prerequisit[1];
            indegree[num1]++;
            graph.get(num2).add(num1);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)q.offer(i);
        }
        int[] ans = new int[numCourses];
        int i = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            ans[i++] = curr;
            for(int nbr : graph.get(curr)){
                indegree[nbr]--;
                if(indegree[nbr]==0){
                    q.offer(nbr);
                }
            }
        }
        if(i!=numCourses)return new int[0];
        return ans;
    }
}
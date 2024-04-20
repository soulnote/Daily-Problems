import java.util.*;

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        List<Integer> ansList = new ArrayList<>();
        solve(list, ansList);
        return ans;
    }
    
    public void solve(List<Integer> list, List<Integer> ansList) {
        if (list.size() == 0) {
            ans.add(new ArrayList<>(ansList));
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            int a = list.get(i);
            List<Integer> newList = new ArrayList<>(list);
            newList.remove(i);
            ansList.add(a);
            solve(newList, ansList);
            ansList.remove(ansList.size() - 1);
        }
    }
}

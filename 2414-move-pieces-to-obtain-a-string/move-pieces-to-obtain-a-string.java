class Solution {
    public boolean canChange(String start, String target) {
        if (start.length() != target.length()) return false;

        int l = 0, r = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == 'L') l++;
            if (target.charAt(i) == 'L') l--;
            if (start.charAt(i) == 'R') r++;
            if (target.charAt(i) == 'R') r--;
        }
        if (l != 0 || r != 0) return false;

        int i = 0, j = 0;
        while (i < start.length() && j < target.length()) {
            while (i < start.length() && start.charAt(i) == '_') i++;
            while (j < target.length() && target.charAt(j) == '_') j++;

            if (i == start.length() || j == target.length()) break;
            
            if (start.charAt(i) != target.charAt(j)) return false;

            if (start.charAt(i) == 'L' && i < j) return false;
            if (start.charAt(i) == 'R' && i > j) return false;

            i++;
            j++;
        }

        return true;
    }
}

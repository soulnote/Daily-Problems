import java.util.*;

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        HashSet<String> set = new HashSet<>();
        List<String> result = new ArrayList<>();

        // Sort the folders to ensure sub-folders follow their parents
        Arrays.sort(folder);

        for (String folderPath : folder) {
            StringBuilder sb = new StringBuilder();
            String[] parts = folderPath.split("/");

            boolean isSubFolder = false;
            for (int i = 1; i < parts.length; i++) {
                sb.append("/").append(parts[i]);
                if (set.contains(sb.toString())) {
                    isSubFolder = true;
                    break;
                }
            }

            if (!isSubFolder) {
                set.add(folderPath);
                result.add(folderPath);
            }
        }

        return result;
    }
}

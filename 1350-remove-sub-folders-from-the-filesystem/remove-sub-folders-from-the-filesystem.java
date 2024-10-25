import java.util.*;

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        // Sort the folders first
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        
        String lastAddedFolder = ""; // Track the last added folder
        for (String folderPath : folder) {
            // Only add the folder if it is not a sub-folder of the last added folder
            if (lastAddedFolder.isEmpty() || !folderPath.startsWith(lastAddedFolder + "/")) {
                result.add(folderPath);
                lastAddedFolder = folderPath;
            }
        }
        return result;
    }
}

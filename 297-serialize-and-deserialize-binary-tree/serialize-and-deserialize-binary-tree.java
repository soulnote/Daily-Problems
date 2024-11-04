import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfsSerialize(root, res);
        return String.join(",", res);
    }

    private void dfsSerialize(TreeNode node, List<String> res) {
        if (node == null) {
            res.add("N");
            return;
        }
        res.add(String.valueOf(node.val));
        dfsSerialize(node.left, res);
        dfsSerialize(node.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> vals = Arrays.asList(data.split(","));
        Iterator<String> iterator = vals.iterator();
        return dfsDeserialize(iterator);
    }

    private TreeNode dfsDeserialize(Iterator<String> iterator) {
        if (!iterator.hasNext()) return null;

        String val = iterator.next();
        if (val.equals("N")) {
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = dfsDeserialize(iterator);
        node.right = dfsDeserialize(iterator);
        return node;
    }
}

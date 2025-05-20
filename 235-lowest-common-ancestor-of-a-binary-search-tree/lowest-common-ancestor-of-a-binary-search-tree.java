class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> listP = new ArrayList<>();
        ArrayList<TreeNode> listQ = new ArrayList<>();
        pathTraverse(root,p,listP);
        pathTraverse(root,q,listQ);
       
        int n = Math.min(listP.size(),listQ.size());
        int idx=0;
        while(idx<n && listP.get(idx)==listQ.get(idx)){
            idx++;
        }
        return listP.get(idx-1);
    }
    public void pathTraverse(TreeNode root, TreeNode p,ArrayList<TreeNode> list){
        if(root==null)return ;
        list.add(root);
        if(root.val==p.val)return;
        if(root.val<p.val){
            pathTraverse(root.right,p,list);
        }
        else pathTraverse(root.left,p,list);
        
    }
}
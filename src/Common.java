import javax.swing.tree.TreeNode;

/**
 * Created by jiayicheng on 17/8/11.
 */
public class Common {

    TreeNode common(TreeNode root, TreeNode p, TreeNode q) {
        if (!covers(root, p) || !covers(root, q))
            return null;
        return commonhelper(root,p,q);
    }

    TreeNode commonhelper(TreeNode root,TreeNode p,TreeNode q)
    {
        if(root==null||root==p||root==q)
            return root;
        boolean left=covers(root.left,p);
        boolean right=covers(root.right,q);

        if(left==right)
            return root;

        TreeNode child=left? root.left:root.right;
        return commonhelper(child,p,q);
    }

    boolean covers(TreeNode a,TreeNode b)
    {
      if(a==null)
          return false;
        if(a==b)
            return true;
        return covers(a.left,b)||covers(a.right,b);

    }
}
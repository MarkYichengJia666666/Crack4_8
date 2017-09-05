import javax.swing.tree.TreeNode;

/**
 * Created by jiayicheng on 17/8/11.
 */
public class CommonAncestor {

    TreeNode common(TreeNode root,TreeNode p,TreeNode q)
    {
        if(!covers(root,p)||!covers(root,q))
            return null;
        else
            if(covers(p,q))
                return p;
             else if(covers(q,p))
                 return q;
TreeNode sibling=getSibling(p);
        TreeNode parent=p.parent;
        while(!covers(sibling,p))
        {
            sibling=getSibling(parent);
            parent=parent.parent;
        }
        return parent;
     }

    boolean covers(TreeNode root,TreeNode p)
    {
        if(root==null)
            return false;
        if(p==null)
            return false;
        if(root==p)
            return true;
        return covers(root.left,p)||covers(root.right,p);
    }

    TreeNode getSibling(TreeNode a)
    {
        if(a==null&&a.parent==null)
            return null;
        TreeNode parent=a.parent;
        return parent.left==a? parent.right:parent.left;
    }
}

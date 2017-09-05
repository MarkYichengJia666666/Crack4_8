import javax.swing.tree.TreeNode;

/**
 * Created by jiayicheng on 17/8/11.
 */
public class Com {
    class Result{
        public TreeNode node;
        public boolean isAncestor;
        public Result(TreeNode n,boolean isAnc){
            node=n;
            isAncestor=isAnc;
        }
    }

    TreeNode commonAncestor(TreeNode root,TreeNode p,TreeNode q){
        Result r=commonAncestorHelper(root,p,q);
        if (r.isAncestor) {
            return r.node;
        }
        return null;
    }

    Result commonAncestorHelper(TreeNode root,TreeNode p,TreeNode q)
    {
        if(root==null)
            return new Result(null,false);
        if(root==p&&root==q)
            return new Result(root,true);
        Result rx=commonAncestorHelper(root.left,p,q);
        if(rx.isAncestor)
            return rx;

        Result ty=commonAncestorHelper(root.right,p,q);
        if(ty.isAncestor)
            return ty;
        if(rx.node!=null&&ty.node!=null)
            return new Result(root,true);
        else if (root==p||root==q)
        {
            boolean isAncestor=rx.node!=null||ty.node!=null;
            return new Result(root,isAncestor);
        }
        else{
            return new Result(rx.node!=null? rx.node:ty.node,false);
        }

    }
}

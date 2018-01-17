package com;

import java.util.*;

/**
 * Created by chengcheng on 12/2/16.
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        TreeNode lca = lowestCommonAncestor(root,root.right, root.left.right);


    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                parent.put(cur.left, cur);
                queue.offer(cur.left);
            }

            if (cur.right != null) {
                parent.put(cur.right, cur);
                queue.offer(cur.right);
            }
        }

        Set<TreeNode> pre = new HashSet<>();

        while (p != null) {
            pre.add(p);
            p = parent.get(p);
        }

        while (!pre.contains(q)) {
            q = parent.get(q);
        }

        return q;
    }


}

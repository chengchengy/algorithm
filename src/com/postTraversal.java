package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by chengcheng on 8/31/16.
 */
public class postTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
//        TreeNode left = root.left;
//        left.left = new TreeNode(4);
//        TreeNode right = root.right;
//        right.right = new TreeNode(5);

        TreeNode.printNode(root);


        List<Integer> preorder = preorderTree(root);

        System.out.println(preorder);

    }

    private static List<Integer> preorderTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {


            }
        }
        return list;
    }


}


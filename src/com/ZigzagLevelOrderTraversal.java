package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by chengcheng on 8/31/16.
 */
public class ZigzagLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode left = root.left;
        left.left = new TreeNode(4);
        TreeNode right = root.right;
        right.right = new TreeNode(5);

        TreeNode.printNode(root);


        List<List<Integer>> zigzag = zigzagLevelOrder(root);
        System.out.println("List: " + zigzag);

    }

    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        boolean flag = true;

        while (!stack.isEmpty()) {
            int size = stack.size();
            List<Integer> currentLevel = new ArrayList<>();
            List<TreeNode> currentNode = new ArrayList<>();

            while (!stack.isEmpty()) {
                TreeNode p = stack.pop();
                currentLevel.add(p.val);
                currentNode.add(p);
            }
//            list.add(currentLevel);
            if (!flag) {
                list.add(currentLevel);
                Collections.reverse(currentNode);
            } else {
                Collections.reverse(currentLevel);
                list.add(currentLevel);

            }

            for (int i = 0; i < currentNode.size(); i++) {
                TreeNode node = currentNode.get(i);
                if (node.left != null) stack.add(node.left);
                if (node.right != null) stack.add(node.right);
            }
            flag = !flag;

        }
        return list;
    }


}


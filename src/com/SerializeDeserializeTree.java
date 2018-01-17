package com;


import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by chengcheng on 9/1/17.
 */
public class SerializeDeserializeTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        String s = serialize(root);
        TreeNode r = deserialize(s);

    }

    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) return sb.toString();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        //preorder
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                sb.append("#").append(",");
                continue;
            }
            sb.append(cur.val).append(",");
            queue.offer(cur.left);
            queue.offer(cur.right);
        }

        return sb.toString();
    }

    public static TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] val = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(val[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        for (int i = 1; i < val.length; i += 2) {
            TreeNode cur = queue.poll();
            if (!val[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(val[i]));
                cur.left = left;
                queue.offer(left);
            }
            if (i + 1 < data.length() && !val[i + 1].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(val[i + 1]));
                cur.right = right;
                queue.offer(right);
            }
        }
        return root;
    }


}




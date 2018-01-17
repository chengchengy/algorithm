package com;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by chengcheng on 12/20/16.
 */
public class TwoSumBST {
    enum example { //example is the class name
        GREE, YELLOW, RED
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5,6,7,8};
        int[] arr1 = Arrays.copyOfRange(nums, 0, 4);
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = Arrays.copyOfRange(nums, 4, nums.length);
        System.out.println(Arrays.toString(arr2));

//        example color = example.RED;
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(3);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(4);
//        root.right = new TreeNode(7);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(8);
//        boolean find = findTarget(root, 20);
//        System.out.println(find);

    }

    public static boolean findTarget(TreeNode root, int k) {
        return dfs(root, root, k);
    }

    public static boolean dfs(TreeNode root, TreeNode cur, int k) {
        if (root == null) return false;
        return search(root, cur, k - cur.val) ||
                dfs(root, cur.left, k) ||
                dfs(root, cur.right, k);
    }

    private static boolean search(TreeNode root, TreeNode cur, int value) {
        if (root == null) return false;
        return root.val == value && root != cur ||
                root.val < value && search(root.right, cur, value) ||
                root.val > value && search(root.left, cur, value);
    }


}

package com.jonas.tree;

import com.jonas.util.TreeNode;

/**
 * 检测是否合法BST
 *
 * @author shenjy
 * @version 1.0
 * @date 2021-01-01
 */
public class IsValidBST {
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /* 限定以 root 为根的子树节点必须满足 max.val > root.val > min.val */
    private static boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (null == root) return true;
        // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
        if (null != min && min.val >= root.val) return false;
        if (null != max && max.val <= root.val) return false;
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
}
